package mathHelper.Dao;

import mathHelper.model.Examples;
import mathHelper.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class ExampleDaoImpl implements ExampleDao{
    @Override
    public Object save(Examples examples) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        session.save(examples);
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public void delete(Examples examples) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();

        session.delete(examples);

        transaction.commit();
        session.close();
    }

    @Override
    public void update(Examples examples) {

    }

    @Override
    public void getByEquals(Double equals) {
        final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        final Session session = sessionFactory.openSession();
        final Transaction transaction = session.beginTransaction();
        final List<Examples> examples = Collections.singletonList(session.get(Examples.class, equals));
        transaction.commit();
        session.close();
        System.out.println(examples);
    }
}
