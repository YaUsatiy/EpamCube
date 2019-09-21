package by.epam.training.service.coordinate_parser;

import by.epam.training.service.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CoordinateParser {
    private static final Logger log = LogManager.getLogger(CoordinateParser.class);

    public String parse(String pathToFile) throws ServiceException {
        if (pathToFile == null) {
            log.error("NULL PATH TO FILE IN READ METHOD");
            throw new ServiceException("NULL PATH TO FILE IN READ METHOD");
        }
        String content;
        try {
            Path path = Paths.get(getClass().getResource(pathToFile).toURI());
            content = new String(Files.readAllBytes(path));
        } catch (IOException | URISyntaxException e) {
            throw new ServiceException("ERROR WHILE READING FILE: " + pathToFile, e);
        } catch (Exception e) {
            throw new ServiceException("UNEXPECTED ERROR WITH PATH: " + pathToFile, e);
        }
        if (content.equals("")) {
            log.error("Please, check your data!");
        }
        return content;
    }
}
