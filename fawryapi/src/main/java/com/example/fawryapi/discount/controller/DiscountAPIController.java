package com.example.fawryapi.discount.controller;

import com.example.fawryapi.util.APIResponse;
import com.example.fawryapi.discount.service.DiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/discount")
public class DiscountAPIController {
    private final DiscountService discountService;

    @Autowired
    public DiscountAPIController(DiscountService discountService) {
        this.discountService = discountService;
    }

    // applyOverAllDiscount
    @PostMapping("overall")
    APIResponse<Object> applyOverAllDiscount(
            @RequestParam("discount") double discount
    ){
        return discountService.applyOverAllDiscount(discount);
    }
    // applySpecificDiscount
    @PostMapping(path = "specific")
    APIResponse<Object> applySpecificDiscount(
            @RequestParam("discount") double discount,
            @RequestParam("serviceName") String serviceName
    ){
        return discountService.applySpecificDiscount(discount,serviceName);
    }

    @GetMapping
    APIResponse<Object> getAllDiscounts(){
        return discountService.getAllDiscounts();
    }
}
