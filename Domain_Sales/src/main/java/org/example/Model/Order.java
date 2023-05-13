package org.example.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Order_table")
public class Order {
    @Id
    @GeneratedValue
    private UUID OrderId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "op_fk")
    private List<ProductMap> productsMap_key;



    private double amount;

    private LocalDate date;

    private LocalDate dueDate;

    @OneToOne @MapsId
    private Invoice invoice;

    @ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "oi_fk",referencedColumnName = "CustomerId")
    private Customer customer;


}
