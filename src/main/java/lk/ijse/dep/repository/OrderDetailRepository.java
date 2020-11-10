package lk.ijse.dep.repository;

import lk.ijse.dep.entity.OrderDetail;
import lk.ijse.dep.entity.OrderDetailPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
