package org.example.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
public class ProductMap {
    @Id
    @GeneratedValue
    private UUID ProductMapId;

    private UUID OrderId;

    @OneToOne
    @MapsId
    private Product product;

    private int quantity;
}
