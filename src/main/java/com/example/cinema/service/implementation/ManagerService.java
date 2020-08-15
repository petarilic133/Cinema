package com.example.cinema.service.implementation;

import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.Manager;
import com.example.cinema.entity.User;
import com.example.cinema.repository.IManagerRepository;
import com.example.cinema.service.IManagerService;
import com.example.cinema.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ManagerService implements IManagerService {

    private final IManagerRepository _managerRepository;

    private final IUserService _userService;

    public ManagerService(IManagerRepository managerRepository, IUserService userService) {
        _managerRepository = managerRepository;
        _userService = userService;
    }

    @Override
    public UserResponse getManager(UUID id) throws Exception {
        Manager manager = _managerRepository.findOneById(id);
        return _userService.getUser(manager.getUser().getId());
    }

    @Override
    public Set<UserResponse> getAllManagers() throws Exception {
        Set<Manager> managers = _managerRepository.findAllByUser_Deleted(false);
        return managers.stream()
                .map(manager -> mapUserToUserResponse(manager.getUser()))
                .collect(Collectors.toSet());
    }

    @Override
    public UserResponse deleteManager(UUID id) throws Exception {
        Manager manager = _managerRepository.findOneById(id);
        return _userService.deleteUser(manager.getUser().getId());
    }

    private UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getManager().getId());
        userResponse.setUserType(user.getUserType());
        userResponse.setPhone(user.getPhone());
        userResponse.setEmail(user.getEmail());
        userResponse.setLastName(user.getLastName());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setUsername(user.getUsername());
        userResponse.setDateOfBirth(user.getDateOfBirth());
        return userResponse;
    }
}
