package com.example.fawryapi.refund.admin;

import com.example.fawryapi.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/adminrefund")
public class AdminRefundController {
    private final AdminRefundService adminRefundService;

    @Autowired
    public AdminRefundController(AdminRefundService adminRefundService) {
        this.adminRefundService = adminRefundService;
    }

    // 1. get all waiting refund requests
    @GetMapping
    public APIResponse<Object> getAllRefunds(){
        return adminRefundService.getAllRefunds();
    }
    // 2. get specific refund by id
    @GetMapping(path = "{refundId}")
    public APIResponse<Object> getRefundById(@PathVariable("refundId") Long refundId){
        return adminRefundService.getRefundById(refundId);
    }
    // 4. get accepted refunds
    @GetMapping(path = "accepted")
    public APIResponse<Object> getAcceptedRefunds(){
        return adminRefundService.getAcceptedRefunds();
    }
    // 5. get rejected refunds
    @GetMapping(path = "rejected")
    public APIResponse<Object> getRejectedRefunds(){
        return adminRefundService.getRejectedRefunds();
    }
    // 3. update refund status
    @PutMapping(path = "{refundId}")
    public APIResponse<Object> updateRefundStatus(
            @PathVariable Long refundId,
            @RequestParam String status
    ){
        return adminRefundService.updateRefundStatus(refundId,status);
    }

}
