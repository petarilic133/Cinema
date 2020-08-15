package com.example.cinema.service.implementation;

import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.Admin;
import com.example.cinema.entity.Customer;
import com.example.cinema.entity.User;
import com.example.cinema.repository.ICustomerRepository;
import com.example.cinema.service.ICustomerService;
import com.example.cinema.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    private final ICustomerRepository _customerRepository;

    private final IUserService _userService;

    public CustomerService(ICustomerRepository customerRepository, IUserService userService) {
        _customerRepository = customerRepository;
        _userService = userService;
    }

    @Override
    public UserResponse getCustomer(UUID id) throws Exception {
        Customer customer = _customerRepository.findOneById(id);
        return _userService.getUser(customer.getUser().getId());
    }

    @Override
    public Set<UserResponse> getAllCustomers() throws Exception {
        Set<Customer> customers = _customerRepository.findAllByUser_Deleted(false);
        return customers.stream()
                .map(customer -> mapUserToUserResponse(customer.getUser()))
                .collect(Collectors.toSet());
    }

    @Override
    public UserResponse deleteCustomer(UUID id) throws Exception {
        Customer customer = _customerRepository.findOneById(id);
        return _userService.deleteUser(customer.getUser().getId());
    }

    private UserResponse mapUserToUserResponse(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getCustomer().getId());
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
