package br.com.tcc.services;

import br.com.tcc.dto.User;
import br.com.tcc.dto.UserLogin;
import br.com.tcc.exceptions.BusinessException;

public interface UserService {

    UserLogin login(User user) throws BusinessException;

    Integer register(User user);

    User get(Integer idUser);

    int update(Integer idUser, User user);
}
