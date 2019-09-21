package by.epam.training.repository;

import by.epam.training.entity.Cube;
import by.epam.training.entity.Point;
import by.epam.training.specification.search_specification.SearchById;
import by.epam.training.specification.search_specification.SearchByRangeOfArea;
import by.epam.training.specification.search_specification.SearchByRangeOfVolume;
import by.epam.training.specification.sort_specification.SortById;
import by.epam.training.specification.sort_specification.SortByVolume;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class CubeRepositoryImplTest {
    private static Cube FIRST_CUBE = new Cube(Arrays.asList(                     //a = 2, V = 8, S = 24, P = 24
            new Point(2, 0, 0), new Point(0, 0, 0),
            new Point(0, 2, 0), new Point(2, 2, 0),
            new Point(2, 0, 2), new Point(0, 0, 2),
            new Point(0, 2, 2), new Point(2, 2, 2)
    ));

    private static Cube SECOND_CUBE = new Cube(Arrays.asList(                    //a = 3, V = 27, S = 54, P = 36
            new Point(3, 0, 3), new Point(0, 0, 3),
            new Point(0, 3, 3), new Point(3, 3, 3),
            new Point(3, 0, 6), new Point(0, 0, 6),
            new Point(0, 3, 6), new Point(3, 3, 6)
    ));

    private static Cube THIRD_CUBE = new Cube(Arrays.asList(                      //a = 4, V = 64, S = 96, P = 48
            new Point(4, 2, 0), new Point(0, 2, 0),
            new Point(0, 6, 0), new Point(4, 6, 0),
            new Point(4, 2, 4), new Point(0, 2, 4),
            new Point(0, 6, 4), new Point(4, 6, 4)
    ));

    private static Cube FOURTH_CUBE = new Cube(Arrays.asList(                     //a = 3, V = 27, S = 54, P = 36
            new Point(8, 0, 0), new Point(5, 0, 0),
            new Point(5, 3, 0), new Point(8, 3, 0),
            new Point(8, 0, 3), new Point(5, 0, 3),
            new Point(5, 3, 3), new Point(8, 3, 3)
    ));

    private static Cube FIFTH_CUBE = new Cube(Arrays.asList(                      //a = 10, V = 1000, S = 600, P = 120
            new Point(10, 0, 10), new Point(0, 0, 10),
            new Point(0, 10, 10), new Point(10, 10, 10),
            new Point(10, 0, 20), new Point(0, 0, 20),
            new Point(0, 10, 20), new Point(10, 10, 20)
    ));

    private static CubeRepository<Cube> cubeRepository;

    @BeforeClass
    public static void setUp() {
        cubeRepository = CubeRepositoryImpl.getInstance();
        cubeRepository.addCube(FIRST_CUBE);
        cubeRepository.addCube(SECOND_CUBE);
        cubeRepository.addCube(THIRD_CUBE);
        cubeRepository.addCube(FOURTH_CUBE);
        cubeRepository.addCube(FIFTH_CUBE);
    }

    @Test
    public void findByIdPositiveTest() {
        List<Cube> resultList = cubeRepository.query(new SearchById(18));
        List<Cube> expectedResult = Arrays.asList(SECOND_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test
    public void findByRangeOfAreaPositiveTest() {
        List<Cube> resultList = cubeRepository.query(new SearchByRangeOfArea(55, 700));
        List<Cube> expectedResult = Arrays.asList(THIRD_CUBE, FIFTH_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test
    public void findByRangeOfAreaPositiveTest2() {
        List<Cube> resultList = cubeRepository.query(new SearchByRangeOfArea(50, 55));
        List<Cube> expectedResult = Arrays.asList(SECOND_CUBE, FOURTH_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test
    public void findByRangeOfVolumePositiveTest() {
        List<Cube> resultList = cubeRepository.query(new SearchByRangeOfVolume(6, 15));
        List<Cube> expectedResult = Arrays.asList(FIRST_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test
    public void findByRangeOfVolumePositiveTest2() {
        List<Cube> resultList = cubeRepository.query(new SearchByRangeOfVolume(20, 60));
        List<Cube> expectedResult = Arrays.asList(SECOND_CUBE, FOURTH_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test
    public void sortByVolumeTest() {
        List<Cube> resultList = cubeRepository.sortCube(new SortByVolume());
        List<Cube> expectedResult = Arrays.asList(FIRST_CUBE, SECOND_CUBE, FOURTH_CUBE, THIRD_CUBE, FIFTH_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test
    public void sortByIdTest() {
        List<Cube> resultList = cubeRepository.sortCube(new SortById());
        List<Cube> expectedResult = Arrays.asList(FIRST_CUBE, SECOND_CUBE, THIRD_CUBE, FOURTH_CUBE, FIFTH_CUBE);
        assertEquals(expectedResult, resultList);
    }

    @Test( priority = 1)                                    //should be invoked at the very end, default priority = 0
    public void removeCubeTest() {
      CubeRepositoryImpl cubeRepository1 = CubeRepositoryImpl.getInstance();
      cubeRepository1.removeCube(FIRST_CUBE);
      int actualSize = cubeRepository1.getCubeRepositoryList().size();
      int expectedSize = 4;
      assertEquals(expectedSize, actualSize);
    }
}