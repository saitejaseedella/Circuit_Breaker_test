package com.code.OrderService;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
@RestController
@RequestMapping("/orders")
public class OrderServiceApplication {
	@Autowired
    private OrderRepository orderRepository;
	
	public OrderServiceApplication() {
		
	}

    @GetMapping("/insert")
    public void initOrdersTable() {
        orderRepository.saveAll(Stream.of(
                        new Order_service("mobile", "electronics", "white", 20000),
                        new Order_service("T-Shirt", "clothes", "black", 999),
                        new Order_service("Jeans", "clothes", "blue", 1999),
                        new Order_service("Laptop", "electronics", "gray", 50000),
                        new Order_service("digital watch", "electronics", "black", 2500),
                        new Order_service("Fan", "electronics", "black", 50000)
                ).
                collect(Collectors.toList()));
    }

	@GetMapping
	public List<Order_service> getOrders(){
		return orderRepository.findAll();
	}
	@GetMapping("/{category}")
	public List<Order_service> getOrdersByCategory(@PathVariable String category){
		return orderRepository.findByCategory(category);
	}


	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
