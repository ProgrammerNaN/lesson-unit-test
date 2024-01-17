package ru.java.school.sber;

import java.util.Random;

public class Service {

    public int getRandom() {
        return new Random().nextInt(10) + 1;
    }

}
