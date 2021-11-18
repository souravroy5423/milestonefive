package com.mindtree.MilestoneFive.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.MilestoneFive.Entity.Order;
import com.mindtree.MilestoneFive.Service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping(path="/create", produces = "application/json")
	public ResponseEntity<Order> placeOrder(@RequestBody Order req){
		Order order = orderService.orderInsert(req);
		return new ResponseEntity<Order>(order,HttpStatus.OK);
	}
	
	@GetMapping(path="/display", produces = "application/json")
	public ResponseEntity <List<Order>> displayOrder(){
		List<Order> order = orderService.orderDisplay();
		return new ResponseEntity<List<Order>>(order,HttpStatus.OK);
	}

}