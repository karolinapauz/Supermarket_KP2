package util;

import entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUtil {

    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                properties.put(Environment.URL, "jdbc:mysql://localhost:3306/supermarket_hometask?serverTimezone=UTC");
                properties.put(Environment.USER, "root");
                properties.put(Environment.PASS, "");
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                properties.put(Environment.SHOW_SQL, "true");
                properties.put(Environment.HBM2DDL_AUTO, "create"); // "update" kas kart leidziant neperkurs duombazes, o papildys

                configuration.setProperties(properties);

                //We need to specify classes we will map to database tables here
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(PurchaseItem.class);
                configuration.addAnnotatedClass(Purchase.class);
                configuration.addAnnotatedClass(Product.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}