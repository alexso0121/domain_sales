package org.example.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Customer")
@Builder
public class Customer {

    @Id
    @GeneratedValue
    private UUID CustomerId;


    private String Name;

    private String ContactEmail;

    private String ContactNumber;

    private String Company;

    private String CompanyAddress;

    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;

}
