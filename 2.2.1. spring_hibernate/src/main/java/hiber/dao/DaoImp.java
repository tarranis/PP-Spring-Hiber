package hiber.dao;

import hiber.model.User;
import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DaoImp implements Dao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }
   @Override
   public void addCar(Car car) {
      sessionFactory.getCurrentSession().save(car);
   }
   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }
   @Override
   public List<User> listUsersByCar(String model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("SELECT u FROM User u WHERE u.car.model = :model AND u.car.series = :series", User.class).setParameter("model", model).setParameter("series", series);
      return query.getResultList();
   }

}
