package br.com.spring.jersey.dao;

import br.com.spring.jersey.dto.User;

public interface UserDAO {
    User get(Integer idUser);

    int register(User user);

    User get(String username, String password);
}
