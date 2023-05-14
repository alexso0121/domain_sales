package org.example.Repository;

import org.example.Model.ProductMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductMapRepository  extends JpaRepository<ProductMap, UUID> {
}
