package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.OrderDTO;
import lk.ijse.dep.dto.OrderDetailDTO;


import java.util.List;

public interface OrderBO extends SuperBO {
    void placeOrder(OrderDTO order, List<OrderDetailDTO> orderDetails);
    String getNewOrderId();
    OrderDTO getOrder(String id);
    //List<OrderDTO> searchOrder();
    boolean isExist(String id);
}
