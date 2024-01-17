package ru.java.school.sber;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private final double EPS = 0.00001;

    private Main main;

    @BeforeEach
    void init() {
        System.out.println("init");
        main = new Main();
    }

    @BeforeEach
    void setUp() {
        System.out.println("SetUp");
    }

    @AfterEach
    void tearDown() {
        System.out.println("End");
    }

    @Test
    void sum_two_positive_digits() {
        double sum = main.sum(2.0, 3.0);
        assertAll(
                () -> assertEquals(5.0, sum, EPS, "Что-то сложилось не так"),
                () -> assertEquals(5.0, sum, EPS, "Что-то сложилось не так"),
                () -> assertEquals(5.0, sum, EPS, "Что-то сложилось не так")
        );
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.0000000001, 3.0, 4.0, 5.0})
    void sum_two_identical_digits(double digit) {
        double sum = main.sum(digit, digit);
        assertEquals(digit + digit, sum, EPS, "Что-то сложилось не так");
    }

    @Test
    void division_by_zero() {
        assertThrows(
                ArithmeticException.class,
                () -> main.division(2, 0)
        );
    }

    @Test
    void division_two_digits_first_bigger() {
        assertEquals(2, main.division(4, 2));
    }

    @Test
    void division_two_digits_second_bigger() {
        assertEquals(2, main.division(2, 4));
    }

}