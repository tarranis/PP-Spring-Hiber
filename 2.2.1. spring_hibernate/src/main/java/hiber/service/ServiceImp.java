package hiber.service;

import hiber.dao.Dao;
import hiber.model.User;
import hiber.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImp implements Service {

   @Autowired
   private Dao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public void addCar(Car car) {
      userDao.addCar(car);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsersByCar(String model, int series) {
      return userDao.listUsersByCar(model, series);
   }
}

