package lk.ijse.dep.entity;

import java.math.BigDecimal;
import java.sql.Date;

public interface CustomEntity {
    String getOrderId();
    Date getOrderDate();
    String getCustomerId();
    String getCustomerName();
    BigDecimal getTotal();

}
