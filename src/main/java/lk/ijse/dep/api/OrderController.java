package lk.ijse.dep.api;


import lk.ijse.dep.business.custom.OrderBO;
import lk.ijse.dep.dto.OrderDTO;
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
@RequestMapping("/api/v1/orders")
public class OrderController {
    @Autowired
    private OrderBO orderBO;

    /*@GetMapping
    public List<OrderDTO> getAllOrders(){
        return orderBO.get();
    }*/

   /* @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public void saveOrder(@ModelAttribute @Valid OrderDTO order){
        if(orderBO.isExist(order.getId())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        orderBO.placeOrder();
    }*/


}
