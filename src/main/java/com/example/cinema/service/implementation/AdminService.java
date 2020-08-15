package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.Admin;
import com.example.cinema.entity.User;
import com.example.cinema.repository.IAdminRepository;
import com.example.cinema.service.IAdminService;
import com.example.cinema.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AdminService implements IAdminService {

    private final IAdminRepository _adminRepository;

    private final IUserService _userService;

    public AdminService(IAdminRepository adminRepository, IUserService userService) {
        _adminRepository = adminRepository;
        _userService = userService;
    }

    @Override
    public UserResponse getAdmin(UUID id) throws Exception {
        Admin admin = _adminRepository.findOneById(id);
        return _userService.getUser(admin.getUser().getId());
    }

    @Override
    public Set<UserResponse> getAllAdmins() throws Exception {
        Set<Admin> admins = _adminRepository.findAllByUser_Deleted(false);
        return admins.stream()
                .map(admin -> mapUserToUserResponse(admin.getUser()))
                .collect(Collectors.toSet());
    }

    @Override
    public UserResponse deleteAdmin(UUID id) throws Exception {
        Admin admin = _adminRepository.findOneById(id);
        return _userService.deleteUser(admin.getUser().getId());
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
