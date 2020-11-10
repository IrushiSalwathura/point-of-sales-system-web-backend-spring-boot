package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.custom.ItemBO;
import lk.ijse.dep.dto.ItemDTO;
import lk.ijse.dep.entity.Item;
import lk.ijse.dep.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Transactional
public class ItemBOImpl implements ItemBO {
    @Autowired
    private ItemRepository itemRepository;

    @Transactional(readOnly = true)
    public String getNewItemCode() {
        String lastItemCode = itemRepository.getFirstLastItemCodeByOrderByCodeDesc().getCode();
        if (lastItemCode == null) {
            return "I001";
        } else {
            int maxId = Integer.parseInt(lastItemCode.replace("I", ""));
            maxId = maxId + 1;
            String id = "";
            if (maxId < 10) {
                id = "I00" + maxId;
            } else if (maxId < 100) {
                id = "I0" + maxId;
            } else {
                id = "I" + maxId;
            }
            return id;
        }
    }

    @Transactional(readOnly = true)
    public List<ItemDTO> getAllItems() {
        List<Item> allItems = itemRepository.findAll();
        ArrayList<ItemDTO> items = new ArrayList<>();
        for (Item item : allItems) {
            items.add(new ItemDTO(item.getCode(), item.getDescription(), item.getQtyOnHand(), BigDecimal.valueOf(item.getUnitPrice().doubleValue())));
        }
        return items;
    }

    @Override
    public ItemDTO getItem(String code) {
        Item item = itemRepository.findById(code).get();
        return new ItemDTO(item.getCode(),item.getDescription(),item.getQtyOnHand(),item.getUnitPrice());
    }

    public void saveItem(String code, String description, double unitPrice, int qtyOnHand) {

        itemRepository.save(new Item(code, description, BigDecimal.valueOf(unitPrice), qtyOnHand));
    }

    public void updateItem(String description, double unitPrice, int qtyOnHand, String code) {

        itemRepository.save(new Item(code, description, BigDecimal.valueOf(unitPrice), qtyOnHand));

    }

    public void deleteItem(String itemCode) {

        itemRepository.deleteById(itemCode);

    }

    @Override
    public boolean isExist(String code) {
        return itemRepository.existsById(code);
    }
}
