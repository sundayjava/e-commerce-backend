package com.ecom.backend.service;

import com.ecom.backend.exception.UserException;
import com.ecom.backend.model.User;

public interface UserService {

    public User findUserById(Long userId)throws UserException;
    public User findUserProfileByJwt(String jwt) throws UserException;
}
