package hiber.service;

import hiber.model.User;
import hiber.model.Car;

import java.util.List;

public interface Service {
    void add(User user);

    void addCar(Car car);

    List<User> listUsers();

    List<User> listUsersByCar(String model, int series);
}
