import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


public class MathsUtilTest {


    @Test
    void testDivide() {

        MathsUtil util = new MathsUtil();
        assertThrows(ArithmeticException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                util.divide(1, 0);

            }
        });

        Throwable exception = assertThrows(ArithmeticException.class, () -> util.divide(1, 0));
        assertEquals("divide by zero", exception.getMessage());


//        NumberFormatException thrown = assertThrows(NumberFormatException.class,
//                () -> {Integer.parseInt("-20");},
//                "NumberFormatException was expected");
//
//        Assertions.assertEquals("For input string: \"One\"", thrown.getMessage());

    }
}
