
package com.mindtree.MilestoneFive.Service;

import java.util.List;

import com.mindtree.MilestoneFive.Entity.Order;

public interface OrderService {
	Order orderInsert(Order o);

	List<Order> orderDisplay();
}
