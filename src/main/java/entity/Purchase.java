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
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;
    private double totalPrice;
    private int totalAmount;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(name = "purchaseItem_id")
    private PurchaseItem purchaseItem;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

}
