package lk.ijse.dep.api;

import lk.ijse.dep.business.custom.ItemBO;
import lk.ijse.dep.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    @Autowired
    private ItemBO itemBO;

    @GetMapping
    public List<ItemDTO> getAllItems(){
        return itemBO.getAllItems();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void saveItem(@ModelAttribute @Valid ItemDTO item){
        if(itemBO.isExist(item.getCode())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        itemBO.saveItem(item.getCode(),item.getDescription(),item.getUnitPrice().doubleValue(),item.getQtyOnHand());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping(value = "/{code}", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void updateItem(@PathVariable @Valid @Pattern(regexp = "I\\d{3}") String code,@RequestBody MultiValueMap<String,String> params){
        if(!itemBO.isExist(code) || params.get("description").size() == 0 || params.get("quantityOnHand").size() == 0 || params.get("unitPrice").size() == 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        itemBO.updateItem(params.get("description").get(0),Double.parseDouble(params.get("unitPrice").get(0)), Integer.parseInt(params.get("quantityOnHand").get(0)),code);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{code}")
    public void deleteItem(@PathVariable @Valid @Pattern(regexp = "I\\d{3}") String code){
        if(!itemBO.isExist(code)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        itemBO.deleteItem(code);
    }
}
