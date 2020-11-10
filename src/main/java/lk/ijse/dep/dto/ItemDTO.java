package lk.ijse.dep.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {
    @Pattern(regexp = "I\\d{3}")
    private String code;
    @NotBlank
    private String description;
    @NotBlank
    private int qtyOnHand;
    @NotBlank
    private BigDecimal unitPrice;
}
