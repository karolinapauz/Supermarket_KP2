package service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Customer;
import entity.Purchase;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class GetDataFromJson {
    public List<Customer> getDataFromJsonToList() throws IOException {
        String file = "src/main/resources/customers.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));

        ObjectMapper mapper = new ObjectMapper();

        List<Customer> customers = mapper.readValue(json, new TypeReference<>() {
        });

        for (Customer customer : customers) {
            customer.setPurchases(customer.getPurchases());
            for (Purchase purchase : customer.getPurchases()) {
                purchase.getPurchaseItem().setPurchase(purchase);
                purchase.setCustomer(purchase.getCustomer());
                purchase.getPurchaseItem().getProduct().setPurchaseItem(purchase.getPurchaseItem());
            }
        }

//        for (Flight flight : flights) {
//            flight.getAircraft().setFlight(flight);
//            for (Pilot pilot : flight.getAircraft().getPilots()) {
//                pilot.setAircraft(flight.getAircraft());
//            }
//            flight.getDestination().setFlight(flight);
//        }


        return customers;
    }
}
