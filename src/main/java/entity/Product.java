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
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private String name;
    private double price;
    private ProductCategory category;
    private int numberOfItemsInStock;

    @ToString.Exclude
    @OneToOne
    @JoinColumn (name = "purchaseItem_id" )
    private PurchaseItem purchaseItem;

}
