package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.Cinema;
import com.example.cinema.entity.Manager;
import com.example.cinema.entity.User;
import com.example.cinema.repository.IAdminRepository;
import com.example.cinema.repository.ICustomerRepository;
import com.example.cinema.repository.IManagerRepository;
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

    private final IManagerRepository _managerRepository;

    private final IAdminRepository _adminRepository;

    private final ICustomerRepository _customerRepository;

    public UserService(IUserRepository userRepository, IManagerRepository managerRepository, IAdminRepository adminRepository, ICustomerRepository customerRepository) {
        _userRepository = userRepository;
        _managerRepository = managerRepository;
        _adminRepository = adminRepository;
        _customerRepository = customerRepository;
    }

    @Override
    public UserResponse getUser(UUID id) throws Exception {
        if(_managerRepository.findOneById(id) != null){
            Manager manager = _managerRepository.findOneById(id);
            User user = manager.getUser();
            return mapUserToUserResponse(user);
        }else if(_adminRepository.findOneById(id) != null){
            User user = _adminRepository.findOneById(id).getUser();
            return mapUserToUserResponse(user);
        }else if(_customerRepository.findOneById(id) != null){
            User user = _customerRepository.findOneById(id).getUser();
            return mapUserToUserResponse(user);
        }
        throw new Exception();
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
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhone(request.getPhone());
        _userRepository.save(user);
        return mapUserToUserResponse(user);
    }

    @Override
    public UserResponse deleteUser(UUID id) throws Exception {
        if(_managerRepository.findOneById(id) != null){
            Manager manager = _managerRepository.findOneById(id);
            for(Cinema c: manager.getCinemas()){
                if(c.getManagers().size() == 1){
                    throw new Exception();
                }
            }
            User user = manager.getUser();
            user.setDeleted(true);
            _userRepository.save(user);
            return mapUserToUserResponse(user);
        }else if(_adminRepository.findOneById(id) != null){
            User user = _adminRepository.findOneById(id).getUser();
            user.setDeleted(true);
            _userRepository.save(user);
            return mapUserToUserResponse(user);
        }else if(_customerRepository.findOneById(id) != null){
            User user = _customerRepository.findOneById(id).getUser();
            user.setDeleted(true);
            _userRepository.save(user);
            return mapUserToUserResponse(user);
        }
        throw new Exception();
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
