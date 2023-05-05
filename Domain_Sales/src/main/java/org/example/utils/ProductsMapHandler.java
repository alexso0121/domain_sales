package org.example.utils;

import org.example.Exception.utilsException.ProductMapInternalException;
import org.example.Model.Product;
import org.example.dto.ProductMapDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductsMapHandler {

    public static Map<Product,String> DtoToMap(ProductMapDto dto){
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

    public static ProductMapDto MapToDto(Map<Product,String> map){


        List<Product> keys=new ArrayList<>(map.keySet());
        StringBuilder str= new StringBuilder();
        for (String value:map.values()){
            str.append(value).append(",");
        };
        str.deleteCharAt(str.length() - 1);

        return new ProductMapDto(keys,str.toString());
    }





}


