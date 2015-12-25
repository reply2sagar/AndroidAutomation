package sampletests;

import org.junit.Test;

/**
 * Created by sagar on 24-12-2015.
 */
public class SampleTestClass {

    @Test
    public void testSomething() {

        System.out.println("System Property P1 -> " + System.getProperty("P1"));

        System.out.println("Environment Variable V1 -> " + System.getenv("V1"));
    }

    @Test
    public void testOtherThing() {
        System.out.println("test other thing");
    }

}
