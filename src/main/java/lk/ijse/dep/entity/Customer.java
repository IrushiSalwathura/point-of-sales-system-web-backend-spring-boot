package lk.ijse.dep.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Customer implements SuperEntity{
    @Id
    private String id;
    private String name;
    private String address;
}
