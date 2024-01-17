package ru.java.school.sber;

public class Controller {

    private Service service;
    private CarService carService;

    public Controller(Service service, CarService carService) {
        this.service = service;
        this.carService = carService;
    }

    public String move() {
        int random = service.getRandom();
        if (random > 5 && random < 11) {
            return carService.getCar(random);
        } else {
            throw new RuntimeException("Неопознанное число");
        }
    }

}
