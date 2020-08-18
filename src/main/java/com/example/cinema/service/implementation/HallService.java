package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateHallRequest;
import com.example.cinema.dto.request.UpdateHallRequest;
import com.example.cinema.dto.response.HallResponse;
import com.example.cinema.entity.Cinema;
import com.example.cinema.entity.Hall;
import com.example.cinema.repository.ICinemaRepository;
import com.example.cinema.repository.IHallRepository;
import com.example.cinema.service.IHallService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class HallService implements IHallService {

    private final IHallRepository _hallRepository;

    private final ICinemaRepository _cinemaRepository;

    public HallService(IHallRepository hallRepository, ICinemaRepository cinemaRepository) {
        _hallRepository = hallRepository;
        _cinemaRepository = cinemaRepository;
    }

    @Override
    public HallResponse createHall(CreateHallRequest request) throws Exception {
        Cinema cinema = _cinemaRepository.findOneById(request.getCinemaId());
        if(_hallRepository.findOneByCinemaAndMarkAndDeleted(cinema, request.getMark(), false) != null){
            throw new Exception();
        }
        Hall hall = new Hall();
        hall.setMark(request.getMark());
        hall.setCapacity(request.getCapacity());
        hall.setDeleted(false);
        hall.setCinema(cinema);
        Hall savedHall = _hallRepository.save(hall);
        cinema.getHalls().add(savedHall);
        _cinemaRepository.save(cinema);
        return mapHallToHallResponse(savedHall);
    }

    @Override
    public HallResponse updateHall(UpdateHallRequest request) throws Exception {
        Hall hall = _hallRepository.findOneById(request.getHallId());
        if(_hallRepository.findOneByCinemaAndMarkAndDeleted(hall.getCinema(), request.getMark(), false) != null){
            throw new Exception();
        }
        hall.setMark(request.getMark());
        hall.setCapacity(request.getCapacity());
        _hallRepository.save(hall);
        return mapHallToHallResponse(hall);
    }

    @Override
    public HallResponse getHall(UUID id) throws Exception {
        Hall hall = _hallRepository.findOneById(id);
        return mapHallToHallResponse(hall);
    }

    @Override
    public Set<HallResponse> getAllHallsByCinema(UUID id) throws Exception {
        Cinema cinema = _cinemaRepository.findOneById(id);
        Set<Hall> halls = _hallRepository.findAllByCinemaAndDeleted(cinema, false);
        return halls.stream()
                .map(hall -> mapHallToHallResponse(hall))
                .collect(Collectors.toSet());

    }

    @Override
    public HallResponse deleteHall(UUID id) throws Exception {
        Hall hall = _hallRepository.findOneById(id);
        hall.setDeleted(true);
        _hallRepository.save(hall);
        return mapHallToHallResponse(hall);
    }

    private HallResponse mapHallToHallResponse(Hall hall){
        HallResponse hallResponse = new HallResponse();
        hallResponse.setId(hall.getId());
        hallResponse.setMark(hall.getMark());
        hallResponse.setCapacity(hall.getCapacity());
        hallResponse.setCinemaName(hall.getCinema().getName());
        return hallResponse;
    }
}
