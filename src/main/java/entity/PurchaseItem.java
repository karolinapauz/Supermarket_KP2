package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private int id;
   // private int purchase_id;
   // private int product_id;
    private int quantity;
    private double price;

    @ToString.Exclude
    @OneToOne (mappedBy = "purchaseItem", cascade = CascadeType.ALL)
    private Product product;


    @ToString.Exclude
    @OneToOne (mappedBy = "purchaseItem", cascade = CascadeType.ALL)
    private Purchase purchase;



}
