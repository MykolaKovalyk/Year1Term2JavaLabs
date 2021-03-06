package ua.lviv.iot;

import com.lpnu.iot.term2.lab7.StringNegativeNumberReplacer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.BeforeEach;


/**
 * Unit test for simple App.
 */
public class LabSevenTest
    extends TestCase
{


    @BeforeEach
    public void setUp() {
    }


    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public LabSevenTest(String testName ) {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite( LabSevenTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testStringNegativeNumberReplacer()
    {
        var testString1 = "I got -123 as an answer in my 2-nd task";
        var testString2 = "+380-456-654-119";
        var testString3 = "Look at user-2 in the chat";
        var testString4 = "Moskva ascended -122 meters below the sea level";
        var testString5 = "";

        var answerString1 = "I got 321 as an answer in my 2-nd task";
        var answerString2 = "+380654456911";
        var answerString3 = "Look at user2 in the chat";
        var answerString4 = "Moskva ascended 221 meters below the sea level";
        var answerString5 = "";

        var replacer = new StringNegativeNumberReplacer();

        assertEquals(replacer.getModifiedString(testString1), answerString1);
        assertEquals(replacer.getModifiedString(testString2), answerString2);
        assertEquals(replacer.getModifiedString(testString3), answerString3);
        assertEquals(replacer.getModifiedString(testString4), answerString4);
        assertEquals(replacer.getModifiedString(testString5), answerString5);
    }

}
