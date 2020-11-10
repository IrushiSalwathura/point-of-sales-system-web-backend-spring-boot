package lk.ijse.dep.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDetailDTO {
    private String code;
    private int qty;
    private BigDecimal unitPrice;
}
