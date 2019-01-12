package br.com.spring.jersey.services;

import br.com.spring.jersey.dto.User;
import br.com.spring.jersey.dto.UserLogin;
import br.com.spring.jersey.exceptions.BusinessException;

public interface UserService {

    UserLogin login(User user) throws BusinessException;

    Integer register(User user);
}
