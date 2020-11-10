package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.ItemDTO;

import java.util.List;

public interface ItemBO extends SuperBO {
    String getNewItemCode();
    List<ItemDTO> getAllItems();
    ItemDTO getItem(String code);
    void saveItem(String code, String description, double unitPrice, int qtyOnHand);
    void updateItem(String description, double unitPrice, int qtyOnHand, String code);
    void deleteItem(String itemCode);
    boolean isExist(String code);
}
