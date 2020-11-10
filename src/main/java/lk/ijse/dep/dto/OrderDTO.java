package lk.ijse.dep.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderDTO {
    private String id;
    private String date;
    private String customerId;
    private List<OrderDetailDTO> orderDetails;

    public OrderDTO(String id, String date, String customerId) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
    }

}
