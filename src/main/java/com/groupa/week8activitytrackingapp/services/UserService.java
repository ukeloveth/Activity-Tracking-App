package com.groupa.week8activitytrackingapp.services;

import com.groupa.week8activitytrackingapp.dtos.LoginDto;
import com.groupa.week8activitytrackingapp.dtos.UserDto;
import com.groupa.week8activitytrackingapp.model.User;

public interface UserService {
    void createMember(UserDto userDto);
    User login(LoginDto loginDto);
}
