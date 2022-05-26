package test.com.company.service;

import com.company.dao.impl.UserDao;
import com.company.entity.User;
import com.company.service.impl.UserService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserServiceTest {

    private UserService userService;
    private UserDao userDao;

    @BeforeEach
    void setUp() {

        userService = new UserService();
        userDao = new UserDao();
    }

    @Test
    public void testDeregisterUser() {

        User user = new User(null, "Iron Man", "321", "man.iron@gmail.com");

        userService.deregisterUser(user);

        assertNull(userDao.getUserByUsername(user.getUsername()));
    }

    @Test
    public void testRegisterUser() {

        User user = new User(null, "Iron Man", "321", "man.iron@gmail.com");

        userService.registerUser(user);

        assertNotNull(userDao.getUserByUsername(user.getUsername()));
    }

    @Test
    public void testLogin() {

        assertNotNull(userService.login("Iron Man", "321"));
    }

    @Test
    public void testIsUsernameDuplicated() {

        assertTrue(userService.isUsernameDuplicated("Iron Man"));
        assertFalse(userService.isUsernameDuplicated("Batman"));
    }

}
