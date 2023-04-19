package service;

import entity.Customer;
import repository.CustomerRepo;
import repository.ProductRepo;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class MenuService {

    CustomerRepo customerRepo = new CustomerRepo();
    ProductRepo productRepo = new ProductRepo();

    public void start() {
        String userChoice = JOptionPane.showInputDialog(this.getMenuItems());
        this.handleUserChoice(userChoice);
        // can be here as well this.start() - recursion
    }

    private String getMenuItems() {
        return """
                Welcome to SUPERMARKET
                1. Add Customer\s
                2. Display all customers\s
                3. Add Product\s
                4. Remove Todo Item\s
                5. Update Todo Item\s
                6. Exit""";
    }

    private void handleUserChoice(String userChoice) {
        switch (userChoice) {
            case "1":
                customerRepo.addCustomer();
                break;
            case "2":
                List<Customer> all = customerRepo.findAll();
                String customersString = this.printList(all);
                JOptionPane.showMessageDialog(null, customersString);
                break;
            case "3":
                // todoController.viewTodo();
                break;
            case "4":
                //todoController.removeTodo();
                break;
            case "5":
                // todoController.updateTodo();
                break;
            case "6":
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Please choose an option from a list.");
                break;
        }
        this.start();
    }

    private String printList(List<Customer> customers){
        String customerDetails = "";
        int i = 0;
        for (Customer customer : customers) {
            customerDetails += customer.getName() + ", " + customer.getBalance() + "\n";
        }
        return customerDetails;
    }
}


