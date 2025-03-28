package com.vinsguru.graphqlplayground.lec04.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class CustomerOrderDto {
    private UUID id;
    private String description;
}
