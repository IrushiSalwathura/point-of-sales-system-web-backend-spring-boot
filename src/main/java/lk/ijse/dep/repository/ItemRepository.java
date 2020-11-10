package lk.ijse.dep.repository;

import lk.ijse.dep.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item,String> {
    Item getFirstLastItemCodeByOrderByCodeDesc();
}
