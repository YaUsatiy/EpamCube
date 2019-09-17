package by.epam.training.warehouse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CubeWarehouse {
    private static CubeWarehouse cubeWarehouseInstance;
    private Map<Long, List<Integer>> listMapWarehouse = new HashMap<>(); //по Id хранится список параметров

    private CubeWarehouse(){}

    public static CubeWarehouse getInstance() {
        if (cubeWarehouseInstance == null) {
            cubeWarehouseInstance = new CubeWarehouse();
        }
        return cubeWarehouseInstance;
    }

    public List<Integer> put(Long key, List<Integer> value) {
        return listMapWarehouse.put(key, value);
    }
    public List<Integer> get (long key){
        return listMapWarehouse.get(key);
    }
}
