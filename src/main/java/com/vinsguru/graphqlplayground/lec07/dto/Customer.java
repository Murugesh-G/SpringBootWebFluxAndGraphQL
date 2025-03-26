package com.vinsguru.graphqlplayground.lec07.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor(staticName = "create")
@Data
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private Integer age;
    private String city;
}
