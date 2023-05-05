package org.example.dto;

import org.example.Model.Product;

import java.util.List;

public record ProductMapDto(List<Product> keys,String values) {
}
