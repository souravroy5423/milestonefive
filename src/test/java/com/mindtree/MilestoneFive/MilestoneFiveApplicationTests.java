package com.mindtree.MilestoneFive;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
//import org.junit.platform.runner.JUnitPlatform;

import com.mindtree.MilestoneFive.Controller.OrderController;
import com.mindtree.MilestoneFive.Entity.Order;
import com.mindtree.MilestoneFive.Service.OrderService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class MilestoneFiveApplicationTests {

	@InjectMocks
    OrderController orderController;
     
    @Mock
    OrderService orderRepo;
     
    @Test
    public void testAddOrder() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Order Order = new Order(1, "Lokesh", 101, "morning");
        when(orderRepo.orderInsert(any(Order.class))).thenReturn(Order);
         
        
        ResponseEntity<Order> responseEntity = orderController.placeOrder(Order);
         
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
        
    }
     
    
    @Test
    public void testFindAll() 
    {
        // given
        Order Order1 = new Order(1, "Hanumanth", 900009, "Just now escaped");
        Order Order2 = new Order(2, "Kaushal", 500, "future");
        Order Order = new Order();
        
 
        ResponseEntity<List<Order>> responseEntity = orderController.displayOrder();
        
        when(orderRepo.orderDisplay()).thenReturn((List<Order>) responseEntity);
 
        // when
        ResponseEntity<List<com.mindtree.MilestoneFive.Entity.Order>> result = orderController.displayOrder();
 
        // then
        assertThat(result.toString()).isEqualTo(2);
         
      
    }
}
