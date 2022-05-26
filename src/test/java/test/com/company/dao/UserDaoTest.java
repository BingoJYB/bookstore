package test.com.company.dao;

import com.company.dao.impl.UserDao;
import com.company.entity.User;

import org.junit.jupiter.api.Test;

public class UserDaoTest {

    @Test
    public void testSaveUser() {

        User user = new User(null, "admin", "123", "admin@gmail.com");
        UserDao userDao = new UserDao();

        System.out.println(userDao.saveUser(user));
    }

    @Test
    public void testGetUserByUsername() {

        UserDao userDao = new UserDao();

        System.out.println(userDao.getUserByUsername("admin"));
    }

    @Test
    public void testGetUserByUsernameAndPassword() {

        UserDao userDao = new UserDao();

        System.out.println(userDao.getUserByUsernameAndPassword("admin", "123"));
    }
}
