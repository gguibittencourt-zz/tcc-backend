package br.com.tcc.dao;

import br.com.tcc.dao.metadata.tables.records.UserRecord;
import br.com.tcc.dto.User;

public interface UserDAO {
    User get(Integer idUser);

    UserRecord register(User user);

    User get(String username, String password);

    int update(Integer idUser, User user);
}
