package com.example.cinema.service.implementation;

import com.example.cinema.dto.request.CreateUserRequest;
import com.example.cinema.dto.request.LoginRequest;
import com.example.cinema.dto.response.UserResponse;
import com.example.cinema.entity.Customer;
import com.example.cinema.entity.Manager;
import com.example.cinema.entity.User;
import com.example.cinema.repository.ICustomerRepository;
import com.example.cinema.repository.IManagerRepository;
import com.example.cinema.repository.IUserRepository;
import com.example.cinema.service.IAuthService;
import com.example.cinema.util.emums.UserType;
import org.dozer.DozerBeanMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {

    DozerBeanMapper mapper = new DozerBeanMapper();

    private final PasswordEncoder _passwordEncoder;

    private final IUserRepository _userRepository;

    private final ICustomerRepository _customerRepository;

    private final IManagerRepository _managerRepository;

    public AuthService(PasswordEncoder passwordEncoder, IUserRepository userRepository, ICustomerRepository customerRepository, IManagerRepository managerRepository) {
        _passwordEncoder = passwordEncoder;
        _userRepository = userRepository;
        _customerRepository = customerRepository;
        _managerRepository = managerRepository;
    }

    @Override
    public User createUser(CreateUserRequest request) throws Exception{
        if(_userRepository.findOneByUsernameAndDeleted(request.getUsername(), false) != null || _userRepository.findOneByEmailAndDeleted(request.getEmail(), false) != null){
            throw new Exception();
        }
        User user = mapper.map(request, User.class);
        user.setDeleted(false);
        user.setPassword(_passwordEncoder.encode(request.getPassword()));
        User savedUser = _userRepository.save(user);
        return savedUser;
    }

    @Override
    public UserResponse registerCustomer(CreateUserRequest request) throws Exception {
        try{
            User user = createUser(request);
            Customer customer = new Customer();
            customer.setUser(user);
            Customer savedCustomer = _customerRepository.save(customer);
            user.setUserType(UserType.CUSTOMER);
            user.setCustomer(savedCustomer);
            _userRepository.save(user);
            return mapUserToUserResponse(user);
        }catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public UserResponse registerManager(CreateUserRequest request) throws Exception {
        try{
            User user = createUser(request);
            Manager manager = new Manager();
            manager.setUser(user);
            Manager savedManager = _managerRepository.save(manager);
            user.setUserType(UserType.MANAGER);
            user.setManager(savedManager);
            _userRepository.save(user);
            return mapUserToUserResponse(user);
        }catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public UserResponse login(LoginRequest request) throws Exception {
        User user = _userRepository.findOneByUsernameAndDeleted(request.getUsername(), false);
        if(user == null){
            throw new Exception();
        }
        if(!_passwordEncoder.matches(request.getPassword(), user.getPassword())){
            throw new Exception();
        }
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
