package ru.java.school.sber;

import java.util.HashMap;
import java.util.Map;

public class CarService {

    private Map<Integer, String> cars = new HashMap<>();

    public CarService() {
        cars.put(6, "Lada");
        cars.put(7, "Mers");
        cars.put(8, "BMW");
        cars.put(9, "Porshe");
        cars.put(10, "Moskvich");
    }

    public String getCar(int index) {
        return cars.get(index);
    }

}
