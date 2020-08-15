package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.User;
import com.example.cinema.repository.IUserRepository;
import com.example.cinema.service.IUserService;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    DozerBeanMapper mapper = new DozerBeanMapper();

    private final IUserRepository _userRepository;

    public UserService(IUserRepository userRepository) {
        _userRepository = userRepository;
    }

    @Override
    public UserResponse getUser(UUID id) throws Exception {
        User user = _userRepository.findOneByIdAndDeleted(id, false);
        return mapUserToUserResponse(user);
    }

    @Override
    public Set<UserResponse> getAllUsers() throws Exception {
        Set<User> users = _userRepository.findAllByDeleted(false);
        return users.stream()
                .map(user -> mapUserToUserResponse(user))
                .collect(Collectors.toSet());
    }

    @Override
    public UserResponse updateUser(CreateUserRequest request) throws Exception {
        User user = _userRepository.findOneByUsernameAndDeleted(request.getUsername(), false);
        user.setDateOfBirth(request.getDateOfBirth());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        _userRepository.save(user);
        return mapUserToUserResponse(user);
    }

    @Override
    public UserResponse deleteUser(UUID id) throws Exception {
        User user = _userRepository.findOneById(id);
        user.setDeleted(false);
        _userRepository.save(user);
        return mapUserToUserResponse(user);
    }

    private UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        if(user.getCustomer() != null){
            userResponse.setId(user.getCustomer().getId());
        }else if(user.getAdmin() != null){
            userResponse.setId(user.getAdmin().getId());
        }else if(user.getManager() != null){
            userResponse.setId(user.getManager().getId());
        }
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
