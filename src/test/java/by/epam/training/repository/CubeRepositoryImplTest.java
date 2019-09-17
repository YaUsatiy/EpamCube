package by.epam.training.repository;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import by.epam.training.specification.searchSpecification.SearchById;
import by.epam.training.specification.searchSpecification.SearchByRangeOfArea;
import by.epam.training.specification.searchSpecification.SearchByRangeOfVolume;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CubeRepositoryImplTest {
    private final Cube FIRST_CUBE = new Cube(Arrays.asList(                     //a = 2
            new Point(2, 0, 0), new Point(0, 0, 0),
            new Point(0, 2, 0), new Point(2, 2, 0),
            new Point(2, 0, 2), new Point(0, 0, 2),
            new Point(0, 2, 2), new Point(2, 2, 2)
    ));

    private final Cube SECOND_CUBE = new Cube(Arrays.asList(                    //a = 3
            new Point(3, 0, 3), new Point(0, 0, 3),
            new Point(0, 3, 3), new Point(3, 3, 3),
            new Point(3, 0, 6), new Point(0, 0, 6),
            new Point(0, 3, 6), new Point(3, 3, 6)
    ));

    private final Cube THIRD_CUBE = new Cube(Arrays.asList(                      //a = 4
            new Point(4, 2, 0), new Point(0, 2, 0),
            new Point(0, 6, 0), new Point(4, 6, 0),
            new Point(4, 2, 4), new Point(0, 2, 4),
            new Point(0, 6, 4), new Point(4, 6, 4)
    ));

    private final Cube FOURTH_CUBE = new Cube(Arrays.asList(                     //a = 3
            new Point(8, 0, 0), new Point(5, 0, 0),
            new Point(5, 3, 0), new Point(8, 3, 0),
            new Point(8, 0, 3), new Point(5, 0, 3),
            new Point(5, 3, 3), new Point(8, 3, 3)
    ));

    private final Cube FIFTH_CUBE = new Cube(Arrays.asList(                      //a = 10
            new Point(10, 0, 10), new Point(0, 0, 10),
            new Point(0, 10, 10), new Point(10, 10, 10),
            new Point(10, 0, 20), new Point(0, 0, 20),
            new Point(0, 10, 20), new Point(10, 10, 20)
    ));

    private CubeRepository cubeRepository;

    @Before
    public void setUp() {
        cubeRepository = CubeRepositoryImpl.getInstance();
        cubeRepository.addCube(FIRST_CUBE);
        cubeRepository.addCube(FOURTH_CUBE);
        cubeRepository.addCube(FIFTH_CUBE);
        cubeRepository.addCube(SECOND_CUBE);
        cubeRepository.addCube(THIRD_CUBE);
    }

    @Test
    public void findByIdPositiveTest() {
        List<Cube> resultList = cubeRepository.query(new SearchById(45));
        List<Cube> expectedResult = Arrays.asList(FIFTH_CUBE);
        assertEquals(resultList, expectedResult);
    }

    @Ignore
    public void findByRangeOfAreaPositiveTest() {
        List<Cube> resultList = cubeRepository.query(new SearchByRangeOfArea(20, 100));
        List<Cube> expectedResult = Arrays.asList(FIRST_CUBE, SECOND_CUBE,
                THIRD_CUBE, FOURTH_CUBE);
        assertEquals(resultList, expectedResult);
    }

    @Ignore
    public void findByRangeOfVolumePositiveTest() {
        List<Cube> resultList = cubeRepository.query(new SearchByRangeOfVolume(6, 15));
        List<Cube> expectedResult = Arrays.asList(FIRST_CUBE);
        assertEquals(resultList, expectedResult);
    }

}