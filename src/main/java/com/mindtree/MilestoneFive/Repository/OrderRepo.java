
package com.mindtree.MilestoneFive.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.MilestoneFive.Entity.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
