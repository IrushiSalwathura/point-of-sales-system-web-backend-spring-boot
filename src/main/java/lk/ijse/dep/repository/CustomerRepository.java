package lk.ijse.dep.repository;

import lk.ijse.dep.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;

public interface CustomerRepository extends JpaRepository<Customer,String> {
    Customer getFirstLastCustomerIdByOrderByIdDesc();

}
