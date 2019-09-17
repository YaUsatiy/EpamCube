package test.epam.training.service.coordinate_parser;

import by.epam.training.service.ServiceException;
import by.epam.training.service.coordinate_parser.CoordinateParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoordinateParserTest {
    CoordinateParser coordinateParser;

    @Before
    public void setUp() {
        coordinateParser = new CoordinateParser();
    }

    @Test
    public void testParse() throws ServiceException {
        String actualContent = coordinateParser.parse("/testData/testData.txt");
        String expectedContent = "0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,1";
        assertEquals(expectedContent, actualContent);
    }
}