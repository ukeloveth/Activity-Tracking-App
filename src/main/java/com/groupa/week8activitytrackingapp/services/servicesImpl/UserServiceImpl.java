package com.groupa.week8activitytrackingapp.services.servicesImpl;

import com.groupa.week8activitytrackingapp.dtos.LoginDto;
import com.groupa.week8activitytrackingapp.dtos.UserDto;
import com.groupa.week8activitytrackingapp.model.User;
import com.groupa.week8activitytrackingapp.repositories.UserRepository;
import com.groupa.week8activitytrackingapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createMember(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        userRepository.save(user);
    }

    @Override
    public User login(LoginDto loginDto) {
        Optional<User> user = userRepository.findByEmail(loginDto.getEmail());
        if (user.isPresent()) {
            User presentUser = user.get();
            if (presentUser.getPassword().equals(loginDto.getPassword()))
                return presentUser;
        }
        return null;
    }
}
