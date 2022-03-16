import org.junit.jupiter.api.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;



public class LengthTest {

    @Test
    void test1() {
        Length cm = Length.centimeter(1000);
        Length m = Length.meter(10);

        assertThat(cm, is(equalTo(m)));
    }

    @Test
    void test2AddinM() {
        Length cm = Length.centimeter(1000);
        Length m = Length.meter(10);

        // first convert cm to cm
        //then cm to m

        Length output = Length.meter(20);

        assertThat(output, is(m.add(cm)));

    }
    @Test
    void test2AddinCM() {
        Length cm = Length.centimeter(1000);
        Length m = Length.meter(10);

        Length output = Length.centimeter(2000);

        assertThat(output, is(cm.add(m)));

    }


    @Test
    void test200cmplus1kmAns100200() {

        Length cm = Length.centimeter(200);
        Length km = Length.kilometer(1);//100000cm

        Length output = Length.centimeter(100200);

        assertThat(output, is(cm.add(km)));
    }

    @Test
    void testminus1m50cmto0point5m() {
        Length meter = Length.meter(1);
        Length centi = Length.centimeter(50);//100000cm

        Length output = Length.meter(0.5);

        assertThat(output, is((meter.subtract(centi))));

    }
}
