package by.epam.training.service.coordinate_parser;

import by.epam.training.service.ServiceException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CoordinateParser {
    private static final Logger log = LogManager.getLogger(CoordinateParser.class);

    public List<String> parse1(String pathToFile) throws Exception {
        if (pathToFile == null) {
            log.error("NULL PATH TO FILE IN READ METHOD");
            throw new ServiceException("NULL PATH TO FILE IN READ METHOD");
        }
        List<String> pointsList;
        Path path = Paths.get(getClass().getResource(pathToFile).toURI());
        try (Stream<String> lineStream = Files.newBufferedReader(path).lines()) {
            pointsList = lineStream.collect(Collectors.toList());
            if (pointsList.isEmpty()) {
                log.error("Please, check your data!");
            }
            return pointsList;
        } catch (IOException e) {
            throw new ServiceException("ERROR WHILE READING FILE: " + pathToFile, e);
        }
    }

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
        }
        if (content.equals("")) {
            log.error("Please, check your data!");
        }
        return content;
    }
}
