package lk.ijse.dep.repository;

import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,String> {
    Order getFirstLastOrderIdByOrderByIdDesc();
    @Query(value = "SELECT o.id AS orderId,o.date AS orderDate,c.id AS customerId,c.name AS customerName,SUM(od.unitPrice*od.qty) AS orderTotal FROM Order o INNER JOIN o.orderDetails od INNER JOIN o.customer c GROUP BY o.id")
    List<CustomEntity> getAllOrders();
}
