package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.Service;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      Service service = context.getBean(Service.class);

      Car car1 = new Car("bmw", 550);
      service.addCar(car1);
      User user1 = new User("User1", "Lastname1", "user1@mail.ru", car1);
      service.add(user1);

      Car car2 = new Car("bmw", 340);
      service.addCar(car2);
      User user2 = new User("User2", "Lastname2", "user2@mail.ru", car2);
      service.add(user1);

      Car car3 = new Car("bmw", 335);
      service.addCar(car3);
      User user3 = new User("User3", "Lastname3", "user3@mail.ru", car3);
      service.add(user3);

      Car car4 = new Car("bmw", 118);
      service.addCar(car4);
      User user4 = new User("User4", "Lastname4", "user4@mail.ru", car4);
      service.add(user4);

      List<User> users = service.listUsers();
      for (User user : users) {
         System.out.println(user);
      }

      List<User> users1 = service.listUsersByCar(car3.getModel(), car3.getSeries());
      for (User user : users1) {
         System.out.println(user);
      }

      context.close();
   }
}
