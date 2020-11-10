package lk.ijse.dep.entity;

import lombok.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OrderDetail implements SuperEntity{
    @EmbeddedId
    private OrderDetailPK orderDetailPK;
    private int qty;
    private BigDecimal unitPrice;
    @ManyToOne
    @JoinColumn(name = "orderId", referencedColumnName = "id", insertable = false, updatable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code",insertable = false, updatable = false)
    private Item item;

    public OrderDetail(OrderDetailPK orderDetailPK, int qty, BigDecimal unitPrice) {
        this.setOrderDetailPK(orderDetailPK);
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
    }

    public OrderDetail(String orderId, String itemCode, int qty, BigDecimal unitPrice) {
        this.setOrderDetailPK(new OrderDetailPK(orderId,itemCode));
        this.setQty(qty);
        this.setUnitPrice(unitPrice);
    }
}
