package lk.ijse.dep.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
    @Pattern(regexp = "C\\d{3}")
    private String id;
    @NotBlank
    private String name;
    @NotBlank
    private String address;
}
