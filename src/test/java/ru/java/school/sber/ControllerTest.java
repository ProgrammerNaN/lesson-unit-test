package ru.java.school.sber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ControllerTest {

    @Mock
    private Service service;

    @Spy
    private CarService carService;

    @Captor
    private ArgumentCaptor<Integer> intCaptor;

    @InjectMocks
    private Controller controller;

    @ParameterizedTest
    @MethodSource("getMoveParams")
    void move_random_bigger_five(int index, String car) {
        when(service.getRandom()).thenReturn(index);
        assertEquals(car, controller.move());
        verify(carService).getCar(intCaptor.capture());
        System.out.println(intCaptor.getValue());
    }


    public static Stream<Arguments> getMoveParams() {
        return Stream.of(
                Arguments.of(6, "Lada"),
                Arguments.of(7, "Mers"),
                Arguments.of(8, "BMW"),
                Arguments.of(9, "Porshe"),
                Arguments.of(10, "Moskvich")
        );
    }

    @Test
    void move_random_smaller_five() {
        when(service.getRandom()).thenReturn(3);
        assertThrows(RuntimeException.class, () -> controller.move());
    }

}