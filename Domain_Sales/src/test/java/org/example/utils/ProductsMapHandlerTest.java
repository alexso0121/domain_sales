package org.example.utils;

import org.example.Model.Product;
import org.example.Model.ProductMap;
import org.example.dto.ProductMapDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class ProductsMapHandlerTest {

    @InjectMocks
    private ProductsMapHandler ProductsMapHandler;

    @Test
    void dtoToMap() {
        Map<Product, String> expect = new HashMap<>();
        Product product1=Product.builder().ProductName("Product1").build();
        expect.put(product1, "value1");

        Product product2=Product.builder().ProductName("Product2").build();
        expect.put(product2, "value2");

        // Create a mock ProductMapDto object.
        ProductMapDto dto=new ProductMapDto(List.of(product2,product1),"value2,value1");

        Assertions.assertEquals(ProductsMapHandler.DtoToMap(dto),expect);
    }

    @Test
    public void testMapToDto() {
        // Create a sample Map.
        Map<Product, String> map = new HashMap<>();
        Product product1=Product.builder().ProductName("Product1").build();
        map.put(product1, "value1");

        Product product2=Product.builder().ProductName("Product2").build();
        map.put(product2, "value2");

        // Create a mock ProductMapDto object.
        ProductMapDto expect=new ProductMapDto(List.of(product2,product1),"value2,value1");

        Assertions.assertEquals(ProductsMapHandler.MapToDto(map),expect);
    }

    @Test
    void listToMap() {
        //unit test for listToMap
        List<ProductMap> productMaps=List.of(new ProductMap(null,null,null,1),new ProductMap(null,null,null,2));

        Map<Product,Integer> expect=new HashMap<>();
        expect.put(null,1);
        expect.put(null,2);

        Assertions.assertEquals(ProductsMapHandler.ListToMap(productMaps),expect);

    }

    @Test
    void mapToList() {
    }
}