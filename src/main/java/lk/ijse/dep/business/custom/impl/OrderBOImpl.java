package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.OrderBO;
import lk.ijse.dep.dto.ItemDTO;
import lk.ijse.dep.dto.OrderDTO;
import lk.ijse.dep.dto.OrderDetailDTO;
import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.entity.Item;
import lk.ijse.dep.entity.Order;
import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.repository.CustomerRepository;
import lk.ijse.dep.repository.ItemRepository;
import lk.ijse.dep.repository.OrderDetailRepository;
import lk.ijse.dep.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class OrderBOImpl implements OrderBO {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public void placeOrder(OrderDTO order, List<OrderDetailDTO> orderDetails) {

        orderRepository.save(new Order(order.getId(), Date.valueOf(order.getDate()), customerRepository.findById(order.getCustomerId()).get()));
        for (OrderDetailDTO orderDetail : orderDetails) {
            orderDetailRepository.save(new OrderDetail(order.getId(), orderDetail.getCode(), orderDetail.getQty(), BigDecimal.valueOf(orderDetail.getUnitPrice().doubleValue())));

            Item item = itemRepository.findById(orderDetail.getCode()).get();
            item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
            //itemRepository.save(item);
        }

    }

    @Transactional(readOnly = true)
    public String getNewOrderId() {
        String lastOrderId = orderRepository.getFirstLastOrderIdByOrderByIdDesc().getId();

        if (lastOrderId == null) {
            return "OD001";
        } else {
            int maxId = Integer.parseInt(lastOrderId.replace("OD", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "OD00" + maxId;
            } else if (maxId < 100) {
                id = "OD0" + maxId;
            } else {
                id = "OD" + maxId;
            }
            return id;
        }
    }

    @Override
    public OrderDTO getOrder(String id) {
        Order order = orderRepository.findById(id).get();
        return new OrderDTO(order.getId(),order.getDate().toString(),order.getCustomer().toString());
    }

    /*public List<OrderDTO> searchOrder() {

        List<CustomEntity> searchOrders = orderRepository.getAllOrders();
        List<OrderDTO> allOrders = new ArrayList<>();
        for (CustomEntity searchOrder : searchOrders) {
            allOrders.add(new OrderDTO(searchOrder.getOrderId(), searchOrder.getOrderDate(),
                    searchOrder.getCustomerName()
                    , searchOrder.getCustomerId(), searchOrder.getTotal()));
        }
        return allOrders;

    }*/

    @Override
    public boolean isExist(String id) {
        return orderRepository.existsById(id);
    }
}
