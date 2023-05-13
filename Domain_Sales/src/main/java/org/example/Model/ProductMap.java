package org.example.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private UUID ProductId;

    private int quantity;
}
