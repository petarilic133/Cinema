package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateProjectionRequest;
import com.example.cinema.dto.request.GetProjectionsInCinemaForMovieRequest;
import com.example.cinema.dto.request.ReserveRequest;
import com.example.cinema.dto.response.ProjectionResponse;
import com.example.cinema.entity.*;
import com.example.cinema.repository.*;
import com.example.cinema.service.IProjectionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectionService implements IProjectionService {

    private final IProjectionRepository _projectionRepository;

    private final IMovieRepository _movieRepository;

    private final IHallRepository _hallRepository;

    private final ICinemaRepository _cinemaRepository;

    private final ICustomerRepository _customerRepository;

    public ProjectionService(IProjectionRepository projectionRepository, IMovieRepository movieRepository, IHallRepository hallRepository, ICinemaRepository cinemaRepository, ICustomerRepository customerRepository) {
        _projectionRepository = projectionRepository;
        _movieRepository = movieRepository;
        _hallRepository = hallRepository;
        _cinemaRepository = cinemaRepository;
        _customerRepository = customerRepository;
    }

    @Override
    public ProjectionResponse createProjection(CreateProjectionRequest request) throws Exception {
        Hall hall = _hallRepository.findOneById(request.getHallId());
        Movie movie = _movieRepository.findOneById(request.getMovieId());
        Projection projection = new Projection();
        projection.setDeleted(false);
        projection.setDate(request.getDate());
        projection.setTime(request.getTime());
        projection.setPrice(request.getPrice());
        projection.setHall(hall);
        projection.setMovie(movie);
        Projection savedProjection = _projectionRepository.save(projection);
        hall.getProjections().add(savedProjection);
        _hallRepository.save(hall);
        movie.getProjections().add(savedProjection);
        _movieRepository.save(movie);
        return mapProjectionToProjectionResponse(savedProjection);
    }

    @Override
    public ProjectionResponse getProjection(UUID id) throws Exception {
        Projection projection = _projectionRepository.findOneById(id);
        return mapProjectionToProjectionResponse(projection);
    }

    @Override
    public ProjectionResponse deleteProjection(UUID id) throws Exception {
        Projection projection = _projectionRepository.findOneById(id);
        projection.setDeleted(true);
        _projectionRepository.save(projection);
        return mapProjectionToProjectionResponse(projection);
    }

    @Override
    public Set<ProjectionResponse> getAllProjectionsByCinema(UUID id) throws Exception {
        Cinema cinema = _cinemaRepository.findOneById(id);
        Set<Projection> projections = _projectionRepository.findAllByHall_CinemaAndDeleted(cinema, false);
        return projections.stream()
                .map(projection -> mapProjectionToProjectionResponse(projection))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ProjectionResponse> getAllProjectionsByMovie(UUID id) throws Exception {
        Movie movie = _movieRepository.findOneById(id);
        Set<Projection> projections = _projectionRepository.findAllByMovieAndDeleted(movie, false);
        return projections.stream()
                .map(projection -> mapProjectionToProjectionResponse(projection))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ProjectionResponse> getAllProjectionsByMovieAndCinema(GetProjectionsInCinemaForMovieRequest request) throws Exception {
        Movie movie = _movieRepository.findOneById(request.getMovieId());
        Cinema cinema = _cinemaRepository.findOneById(request.getCinemaId());
        Set<Projection> projections = _projectionRepository.findAllByHall_CinemaAndMovieAndDeleted(cinema, movie, false);
        return projections.stream()
                .map(projection -> mapProjectionToProjectionResponse(projection))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<ProjectionResponse> getAllProjectionsByHall(UUID id) throws Exception {
        Hall hall = _hallRepository.findOneById(id);
        Set<Projection> projections = _projectionRepository.findAllByHallAndDeleted(hall, false);
        return projections.stream()
                .map(projection -> mapProjectionToProjectionResponse(projection))
                .collect(Collectors.toSet());
    }

    @Override
    public ProjectionResponse reserve(ReserveRequest request) throws Exception {
        Customer customer = _customerRepository.findOneById(request.getCustomerId());
        Projection projection = _projectionRepository.findOneById(request.getProjectionId());
        if(customer.getProjections().contains(projection)){
            throw new Exception();
        }
        customer.getProjections().add(projection);
        Customer savedCustomer = _customerRepository.save(customer);
        projection.getCustomers().add(savedCustomer);
        _projectionRepository.save(projection);
        return mapProjectionToProjectionResponse(projection);
    }

    @Override
    public ProjectionResponse cancelReservation(ReserveRequest request) throws Exception {
        Projection projection = _projectionRepository.findOneById(request.getProjectionId());
        LocalDate now = LocalDate.now();
        if(projection.getDate().isBefore(now)){
            throw new Exception();
        }
        Customer customer = _customerRepository.findOneById(request.getCustomerId());
        customer.getProjections().remove(projection);
        _customerRepository.save(customer);
        projection.getCustomers().remove(customer);
        _projectionRepository.save(projection);
        return mapProjectionToProjectionResponse(projection);
    }

    @Override
    public Set<ProjectionResponse> getAllProjectionsByCustomer(UUID id) throws Exception {
        Customer customer = _customerRepository.findOneById(id);
        Set<Projection> customersProjections = new HashSet<>();
        for(Projection p: customer.getProjections()){
            if(!p.isDeleted()){
                customersProjections.add(p);
            }
        }
        return customersProjections.stream()
                .map(projection -> mapProjectionToProjectionResponse(projection))
                .collect(Collectors.toSet());
    }

    private ProjectionResponse mapProjectionToProjectionResponse(Projection projection){
        ProjectionResponse projectionResponse = new ProjectionResponse();
        projectionResponse.setId(projection.getId());
        projectionResponse.setDate(projection.getDate());
        projectionResponse.setTime(projection.getTime());
        projectionResponse.setPrice(projection.getPrice());
        projectionResponse.setDuration(projection.getMovie().getDuration());
        projectionResponse.setHallMark(projection.getHall().getMark());
        projectionResponse.setCinemaName(projection.getHall().getCinema().getName());
        projectionResponse.setMovieName(projection.getMovie().getName());
        return projectionResponse;
    }
}
