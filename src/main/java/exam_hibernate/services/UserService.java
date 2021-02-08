package exam_hibernate.services;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import exam_hibernate.models.User;
import exam_hibernate.utils.HibernateUtil;

import javax.persistence.Query;
import java.util.List;

public class UserService{

    private SessionFactory sessionFactory;

    public UserService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List getAll() {
        Session session = this.sessionFactory.getCurrentSession();

        session.beginTransaction();

        String hql = "FROM User u";

        Query query = session.createQuery(hql);

        List users = query.getResultList();

        session.close();

        return users;
    }

    public User create(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(user);
        session.flush();
        session.close();
        return user;
    }


}
