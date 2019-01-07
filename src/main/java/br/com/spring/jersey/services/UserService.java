package br.com.spring.jersey.services;

import br.com.spring.jersey.dto.User;
import br.com.spring.jersey.dto.UserLogin;
import br.com.spring.jersey.exceptions.BusinessException;

public interface UserService {

    UserLogin login(User user) throws Exception;

    boolean register(User user);
}
