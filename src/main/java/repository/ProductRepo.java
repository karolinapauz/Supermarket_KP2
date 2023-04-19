package repository;

import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class ProductRepo {

    public void addProduct(Product product) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
    }
}
