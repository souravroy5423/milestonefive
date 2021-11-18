package com.mindtree.MilestoneFive.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.MilestoneFive.Entity.Order;
import com.mindtree.MilestoneFive.Repository.OrderRepo;
import com.mindtree.MilestoneFive.Service.OrderService;

@Service
public class OrderServiceImple implements OrderService {
	
	@Autowired
	private OrderRepo ord;
	
	public Order orderInsert(Order req){
		Order o = ord.save(req);
		return o;
	}

	@Override
	public List<Order> orderDisplay() {
		List<Order> ob=ord.findAll();
		return ob;
	}

}
