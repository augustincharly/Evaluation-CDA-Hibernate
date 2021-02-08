package exam_hibernate.services;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import exam_hibernate.models.Color;
import exam_hibernate.utils.HibernateUtil;

public class ColorService {

	private SessionFactory sessionFactory;

	public ColorService() {
		this.sessionFactory = HibernateUtil.getSessionFactory();
	}

	public List<Color> getAll() {
		Session session = this.sessionFactory.getCurrentSession();

		session.beginTransaction();

		String hql = "FROM Color c";

		Query query = session.createQuery(hql);

		List colors = query.getResultList();

		session.close();

		return colors;
	}

}
