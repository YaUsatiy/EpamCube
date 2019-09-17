package test.epam.training.service.coordinate_validator;

import by.epam.training.service.ServiceException;
import by.epam.training.service.coordinate_parser.CoordinateParser;
import by.epam.training.service.coordinate_validator.CoordinateValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CoordinateValidatorTest {
    CoordinateParser coordinateParser;

    @Before
    public void setUp() {
        coordinateParser = new CoordinateParser();
    }

    @Test
    public void testValidate() throws ServiceException {
        String coordinatesFromFile = coordinateParser.parse("/testData/testData.txt");
        boolean actualValue = CoordinateValidator.validate(coordinatesFromFile);
        assertTrue(actualValue);
    }
}