package br.com.spring.jersey.dao;

import br.com.spring.jersey.dao.metadata.Tables;
import br.com.spring.jersey.dto.User;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    private final DSLContext dslContext;

    @Autowired
    public UserDAOImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }


    @Override
    public User get(Integer idUser) {
        return this.dslContext
                .selectFrom(Tables.USER)
                .where(Tables.USER.ID_USER.eq(idUser))
                .fetchOneInto(User.class);
    }

    @Override
    public User get(String username, String password) {
        return this.dslContext
                .selectFrom(Tables.USER)
                .where(Tables.USER.USERNAME.eq(username).and(Tables.USER.PASSWORD.eq(password)))
                .fetchOneInto(User.class);
    }

    @Override
    public int register(User user) {
        return this.dslContext
                .insertInto(Tables.USER)
                .set(Tables.USER.NAME, user.getName())
                .set(Tables.USER.USERNAME, user.getUsername())
                .set(Tables.USER.PASSWORD, user.getPassword())
                .execute();
    }
}
