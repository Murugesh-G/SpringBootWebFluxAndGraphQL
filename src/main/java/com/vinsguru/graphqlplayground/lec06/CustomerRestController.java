package com.vinsguru.graphqlplayground.lec06;

import com.vinsguru.graphqlplayground.lec06.dto.CustomerOrderDto;
import com.vinsguru.graphqlplayground.lec06.dto.CustomerWithOrder;
import com.vinsguru.graphqlplayground.lec06.service.CustomerService;
import com.vinsguru.graphqlplayground.lec06.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class CustomerRestController {

    @Autowired
    private CustomerService service;

    @Autowired
    private OrderService orderService;

    @GetMapping("customers")
    public Flux<?> customerOrders() {
        return this.service.allCustomers()
                .flatMap(c ->
                        this.orderService.ordersByCustomerName(c.getName())
                                .collectList()
                                .map(l -> CustomerWithOrder.create(c.getId(), c.getName(), c.getAge(), c.getCity(), l))
                );
    }


}
