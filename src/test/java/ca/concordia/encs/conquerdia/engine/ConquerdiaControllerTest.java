package ca.concordia.encs.conquerdia.engine;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Unit test for ConquerdiaController.
 */
public class ConquerdiaControllerTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public ConquerdiaControllerTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ConquerdiaControllerTest.class);
    }

    /**
     *
     */
    public void testEditContinentCommand() {
        ConquerdiaController conquerdia = new ConquerdiaController();
        try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            conquerdia.executeCommand("editcontinent", new PrintStream(output));
            assertEquals("Invalid Command" + System.getProperty("line.separator"), output.toString());
        } catch (Exception ex) {
            fail();
        }
    }
}
