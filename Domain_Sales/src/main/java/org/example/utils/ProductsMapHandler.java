package org.example.utils;

import org.example.Exception.utilsException.ProductMapInternalException;
import org.example.Model.Product;
import org.example.Model.ProductMap;
import org.example.dto.ProductMapDto;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductsMapHandler {

    public  Map<Product,String> DtoToMap(ProductMapDto dto){
        List<String> value_list= List.of(dto.values().split(","));
        if(dto.keys().size()!=value_list.size()) {
            throw new ProductMapInternalException("can not generate map due to the difference in size of keys and values");
        }
        Map<Product,String> map=new HashMap<>();

        for(int i=0;i< dto.keys().size();i++){
            map.put(dto.keys().get(i),value_list.get(i));
        }

        return map;
    }

    public  ProductMapDto MapToDto(Map<Product,String> map){


        List<Product> keys=new ArrayList<>(map.keySet());
        StringBuilder str= new StringBuilder();
        for (String value:map.values()){
            str.append(value).append(",");
        };
        str.deleteCharAt(str.length() - 1);

        return new ProductMapDto(keys,str.toString());
    }

    public Map<Product,Integer> ListToMap(List<ProductMap> productMaps){
        Map<Product,Integer> map=new HashMap<>();
       for(ProductMap productMap:productMaps){
           map.put(productMap.getProduct(),productMap.getQuantity());
       }
         return map;

    }

    //MaptoList
    public List<ProductMap> MapToList(Map<Product,Integer> map, UUID orderId){
        List<ProductMap> productMaps=new ArrayList<>();
        for(Product product:map.keySet()){
            productMaps.add(new ProductMap(null,orderId,product,map.get(product)));
        }
        return productMaps;
    }





}


