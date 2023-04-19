package repository;

import entity.Customer;
import entity.Purchase;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepo {

    public void addCustomerFromJson(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void addCustomer() {
        Customer customer = this.getCustomerInfo();
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public List<Customer> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Customer", Customer.class).list();
    }

    private Customer getCustomerInfo() {
        Customer customer = new Customer();
        customer.setName(this.getCustomerInput("Name: "));
        customer.setPassword(this.getCustomerInput("Password: "));
        customer.setBalance(this.getCustomerBalance("What is your current balance?"));
        customer.setPurchases(this.getCustomerPurchases("What are your purchases?"));
        return customer;
    }

    private String getCustomerInput(String info) {
        return JOptionPane.showInputDialog(info);
    }

    private double getCustomerBalance(String info) {
        return Double.parseDouble(JOptionPane.showInputDialog(info));
    }

    private List<Purchase> getCustomerPurchases(String info) {
        List<Purchase> purchases = new ArrayList<>();
        purchases.add(new Purchase());
        JOptionPane.showInputDialog(info);
        return purchases;
    }
}
