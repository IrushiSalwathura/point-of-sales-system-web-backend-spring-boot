package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.CustomerDTO;

import java.util.List;

public interface CustomerBO extends SuperBO {
    String getNewCustomerId();
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomer(String id);
    void saveCustomer(String id, String name, String address);
    void updateCustomer(String name, String address, String id);
    void deleteCustomer(String customerId);
    boolean isExist(String id);

}
