package com.ajcode.OrderService;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order_service,Integer> {

    List<Order_service> findByCategory(String category);


}
