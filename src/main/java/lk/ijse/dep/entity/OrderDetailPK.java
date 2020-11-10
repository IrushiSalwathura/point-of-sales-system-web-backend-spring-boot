package lk.ijse.dep.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailPK implements Serializable {
    private String orderId;
    private String itemCode;
}
