package by.epam.training.service.coordinate_validator;

import by.epam.training.service.ServiceException;
import by.epam.training.service.coordinate_parser.CoordinateParser;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CoordinateValidatorTest {
    private static CoordinateParser coordinateParser;

    @BeforeClass
    public static void setUp() {
        coordinateParser = new CoordinateParser();
    }

    @Test
    public void testValidate() throws ServiceException {
        String coordinatesFromFile = coordinateParser.parse("/testData/testData.txt");
        boolean actualValue = CoordinateValidator.validate(coordinatesFromFile);
        assertTrue(actualValue);
    }

    @DataProvider
    public static Object[][] dataForTestNegativeValidate() {
        return new Object[][]{
            {"0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0z; 1,0,1; 1,1,0; 1,1,1"},
            {"0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,=1"},
            {"0,0,0; 0,0,1; 0,1,0; 0,1,1; --1,0,0; 1,0,1; 1,1,0; 1,1,1"},
            {"0,0,0; 0,0,1; 0,1,0; 0,dde1,1; 1,0,0; 1,0,1; 1,1,0; 1,1,1"},
            {"0,0,0; 0,0,1; 0,1,0; 0,1,1; 1,0,0; 1,0,1; 1,1,0;"}
        };
    }

    @Test(dataProvider = "dataForTestNegativeValidate")
    public void testNegativeValidate(String incorrectCoordinates) {
        boolean actualValue = CoordinateValidator.validate(incorrectCoordinates);
        assertFalse(actualValue);
    }
}