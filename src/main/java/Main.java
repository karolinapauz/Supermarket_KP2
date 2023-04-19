import entity.Customer;
import entity.Purchase;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.Transaction;
import repository.CustomerRepo;
import service.GetDataFromJson;
import service.MenuService;
import service.WelcomeUser;
import util.HibernateUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

         CustomerRepo customerRepo = new CustomerRepo();

//        Customer customer = new Customer();
//        customer.setName("Tomas");
//        customer.setPassword("pupa");
//        Purchase purchase1  = new Purchase();
//
//        customerRepo.addCustomer(customer);

//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();

        GetDataFromJson getDataFromJson = new GetDataFromJson();
        List<Customer> customerFromJson = getDataFromJson.getDataFromJsonToList();
//
//        for (Customer customer : customerFromJson) {
//            customerRepo.addCustomerFromJson(customer);
//        }

//        customerFromJson.forEach(System.out::println);
//        customerFromJson.get(0).getPurchases().forEach(System.out::println);
//        System.out.println(customerFromJson.get(0).getPurchases().get(0).getPurchaseItem());

        MenuService menu = new MenuService();
        menu.start();

      //  WelcomeUser welcomeUser = new WelcomeUser();

    }
}
