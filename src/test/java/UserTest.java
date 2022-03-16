import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.rmi.server.ExportException;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    @Test
    void test1() {
       try {
            User user = new User(null);
        } catch (Exception e) {

            assertEquals("ERROR1", e.getMessage());
        }
     }
     void test2() {
        try {
            User user = new User("P");
        } catch (Exception e) {

            assertEquals("ERROR2", e.getMessage());
        }
    }

    @Test
    void Test3() {
        User user = new User();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> user.setName("RTTT"),
                "Somthing Like sysos");
        assertEquals("Error1", exception.getMessage());

    }


    @Test
    void Test4() {
        User user = new User();
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {  user.setName("P");});
        assertEquals("Error2", exception.getMessage());

    }



}
