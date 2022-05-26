package test.com.company.dao;

import com.company.dao.impl.UserDao;
import com.company.entity.User;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserDaoTest {

    private UserDao userDao;

    @BeforeEach
    void setUp() {

        userDao = new UserDao();
    }

    @Test
    public void testDeleteUser() {

        User user = new User(null, "admin", "123", "admin@gmail.com");

        assertNotEquals(-1, userDao.deleteUser(user));
    }

    @Test
    public void testSaveUser() {

        User user = new User(null, "admin", "123", "admin@gmail.com");

        assertNotEquals(-1, userDao.saveUser(user));
    }

    @Test
    public void testGetUserByUsername() {

        assertNotNull(userDao.getUserByUsername("admin"));
    }

    @Test
    public void testGetUserByUsernameAndPassword() {

        assertNotNull(userDao.getUserByUsernameAndPassword("admin", "123"));
    }
}
