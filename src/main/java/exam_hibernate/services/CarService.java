package exam_hibernate.services;

import java.util.Collections;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import exam_hibernate.models.Car;
import exam_hibernate.utils.HibernateUtil;

public class CarService {

	private SessionFactory sessionFactory;

	public CarService() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public List<Car> getAll() {
		Session s = this.sessionFactory.getCurrentSession();

		s.beginTransaction();

		String hql = "FROM Car c";

		Query query = s.createQuery(hql);

		List<Car> cars = query.getResultList();

		s.close();

		return cars;
	}

	public List<String> getInfoMarques() {
		Session s = this.sessionFactory.getCurrentSession();
		s.beginTransaction();
		String hql = "SELECT DISTINCT C.marque, COUNT(*) FROM Car C GROUP BY C.marque";
		Query query = s.createQuery(hql);
		List<String> result = query.getResultList();
		s.close();
		return result;
	}

	public Long getCountCar() {
		Session s = this.sessionFactory.getCurrentSession();
		s.beginTransaction();
		String hql = "SELECT COUNT(*) FROM Car C";
		Query query = s.createQuery(hql);
		Long result = (Long) query.getResultList().get(0);
		s.close();
		return result;
	}

	public List<Car> get10LastAdded() {
		Session s = this.sessionFactory.getCurrentSession();
		s.beginTransaction();
		String hql = "FROM Car C ORDER BY C.dateAjout DESC";
		Query query = s.createQuery(hql);
		query.setMaxResults(10);

		List<Car> cars = query.getResultList();

		s.close();

		return cars;

	}

}
