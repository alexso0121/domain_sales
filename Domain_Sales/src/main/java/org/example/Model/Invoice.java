package org.example.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Set;
import java.util.UUID;

//spring.jpa.properties.hibernate.globally_quoted_identifiers=true
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "Invoice")
public class Invoice {
    @Id
    @GeneratedValue
    private UUID OrderId;

    private String OrderName;

    private double price;

    private PaymentType payment;

    @OneToOne(mappedBy = "invoice")
    private Order order;

    private String paymentNote;

    @Value("${company.banking.selfNote}")
    private String SelfNote;

    enum PaymentType{
        Visa,
        Cash,
        Payme,
        Transition

    }
}


