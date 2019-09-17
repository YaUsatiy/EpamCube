package by.epam.training.service.coordinate_validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CoordinateValidator {
    private static final Pattern LINE_PATTERN = Pattern.compile("(-?[\\d],-?[\\d],-?[\\d]; ){7}-?[\\d],-?[\\d],-?[\\d]");

    public static boolean validate(String coordinates) {
        Matcher matcher = LINE_PATTERN.matcher(coordinates);
        return matcher.matches();
    }
}
