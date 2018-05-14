package hu.unideb.inf.snake.snakefx.model.test;

import hu.unideb.inf.snake.snakefx.model.dto.userdto.User;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Zoli
 */
public class UserTest {

    /*
     * default name = ""
     * default score = -1
     */
    User user;

    @Before
    public void setUp() {
        user = new User();
    }

    @Test
    public void defaultUserTest() {
        assertEquals(user.getName(), "");
        assertEquals(user.getScore(), -1);
    }

    @Test
    public void userNameTest() {
        user.setName("Sanyi");
        assertEquals(user.getName(), "Sanyi");
        user.setName("Pisti");
        assertEquals(user.getName(), "Pisti");
        user.setName("Joe");
        assertEquals(user.getName(), "Joe");
    }

    @Test
    public void userScoreTest() {
        user.setScore(0);
        assertEquals(user.getScore(), 0);
        user.setScore(user.getScore() + 1);
        assertEquals(user.getScore(), 1);
        user.setScore(user.getScore() + 1);
        assertEquals(user.getScore(), 2);
    }

}
