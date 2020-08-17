package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateCinemaRequest;
import com.example.cinema.dto.request.SetNewManagerRequest;
import com.example.cinema.dto.response.CinemaResponse;
import com.example.cinema.entity.Cinema;
import com.example.cinema.entity.Manager;
import com.example.cinema.repository.ICinemaRepository;
import com.example.cinema.repository.IManagerRepository;
import com.example.cinema.service.ICinemaService;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CinemaService implements ICinemaService {

    DozerBeanMapper mapper = new DozerBeanMapper();

    private final ICinemaRepository _cinemaRepository;

    private final IManagerRepository _managerRepository;

    public CinemaService(ICinemaRepository cinemaRepository, IManagerRepository managerRepository) {
        _cinemaRepository = cinemaRepository;
        _managerRepository = managerRepository;
    }

    @Override
    public CinemaResponse createCinema(CreateCinemaRequest request) throws Exception {
        if(_cinemaRepository.findOneByNameAndDeleted(request.getName(), false) != null || _cinemaRepository.findOneByEmailAndDeleted(request.getEmail(), false) != null || _cinemaRepository.findOneByAddressAndDeleted(request.getAddress(), false) != null ){
            throw new Exception();
        }
        Cinema cinema = new Cinema();
        cinema.setAddress(request.getAddress());
        cinema.setEmail(request.getEmail());
        cinema.setPhone(request.getPhone());
        cinema.setName(request.getName());
        cinema.setDeleted(false);
        Manager manager = _managerRepository.findOneById(request.getManagerId());
        cinema.getManagers().add(manager);
        Cinema savedCinema = _cinemaRepository.save(cinema);
        manager.getCinemas().add(savedCinema);
        _managerRepository.save(manager);
        return mapCinemaToCinemaResponse(savedCinema);
    }

    @Override
    public CinemaResponse getCinema(UUID id) throws Exception {
        Cinema cinema = _cinemaRepository.findOneById(id);
        return mapCinemaToCinemaResponse(cinema);
    }

    @Override
    public CinemaResponse updateCinema(CreateCinemaRequest request) throws Exception {
        Cinema cinema = _cinemaRepository.findOneByNameAndDeleted(request.getName(), false);
        if(_cinemaRepository.findOneByEmailAndDeleted(request.getEmail(), false) != null || _cinemaRepository.findOneByEmailAndDeleted(request.getEmail(), false) != null){
            throw new Exception();
        }
        cinema.setPhone(request.getPhone());
        cinema.setEmail(request.getPhone());
        cinema.setAddress(request.getAddress());
        _cinemaRepository.save(cinema);
        return mapCinemaToCinemaResponse(cinema);
    }

    @Override
    public Set<CinemaResponse> getAllCinemas() throws Exception {
        Set<Cinema> cinemas = _cinemaRepository.findAllByDeleted(false);
        return cinemas.stream()
                .map(cinema -> mapCinemaToCinemaResponse(cinema))
                .collect(Collectors.toSet());
    }

    @Override
    public CinemaResponse deleteCinema(UUID id) throws Exception {
        Cinema cinema = _cinemaRepository.findOneById(id);
        cinema.setDeleted(true);
        _cinemaRepository.save(cinema);
        return mapCinemaToCinemaResponse(cinema);
    }

    @Override
    public CinemaResponse setNewManager(SetNewManagerRequest request) throws Exception {
        Cinema cinema = _cinemaRepository.findOneById(request.getCinemaId());
        Manager manager = _managerRepository.findOneById(request.getManagerId());
        if(cinema.getManagers().contains(manager)){
            throw new Exception();
        }
        cinema.getManagers().add(manager);
        Cinema savedCinema = _cinemaRepository.save(cinema);
        manager.getCinemas().add(savedCinema);
        return mapCinemaToCinemaResponse(savedCinema);
    }

    private CinemaResponse mapCinemaToCinemaResponse(Cinema cinema){
        CinemaResponse cinemaResponse = new CinemaResponse();
        cinemaResponse.setId(cinema.getId());
        cinemaResponse.setName(cinema.getName());
        cinemaResponse.setAddress(cinema.getAddress());
        cinemaResponse.setEmail(cinema.getEmail());
        cinemaResponse.setPhone(cinema.getPhone());
        return cinemaResponse;
    }
}
