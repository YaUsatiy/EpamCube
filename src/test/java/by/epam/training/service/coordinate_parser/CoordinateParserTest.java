package by.epam.training.service.coordinate_parser;

import by.epam.training.service.ServiceException;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateParserTest {
    private static CoordinateParser coordinateParser;

    @BeforeClass
    public static void setUp() {
        coordinateParser = new CoordinateParser();
    }

    @Test
    public void testParse() throws ServiceException {
        String actualContent = coordinateParser.parse("/testData/testData.txt");
        String expectedContent = "0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,1";
        assertEquals(expectedContent, actualContent);
    }

    @Test(expected = ServiceException.class)
    public void testParse2() throws ServiceException {
        String actualContent = coordinateParser.parse(null);
        String expectedContent = "0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,1";
        assertEquals(expectedContent, actualContent);
    }

    @Test(expected = ServiceException.class)
    public void testParse3() throws ServiceException {
        String actualContent = coordinateParser.parse("/d");
        String expectedContent = "0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,1";
        assertEquals(expectedContent, actualContent);
    }
}