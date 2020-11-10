package lk.ijse.dep.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Item implements SuperEntity{
    @Id
    private String code;
    private String description;
    private BigDecimal unitPrice;
    private int qtyOnHand;
}
