package by.epam.training.warehouse;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CubeWarehouseTest {

    @Test(expected = NullPointerException.class)
    public void putTest() {
        List<Integer> parameters= new ArrayList<>();
        parameters.add(1);
        parameters.add(2);
        List<Integer> actualResult = CubeWarehouse.getInstance().put(2L, parameters);
        Assert.assertTrue(actualResult.isEmpty());
    }
}