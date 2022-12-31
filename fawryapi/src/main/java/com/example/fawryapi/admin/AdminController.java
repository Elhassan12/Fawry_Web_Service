package com.example.fawryapi.admin;

import com.example.fawryapi.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAdmins(){
        return adminService.getAdmins();
    }

    @GetMapping(path = "{id}")
    public Admin getAdminById(@PathVariable("id") Long id){
        return adminService.getAdminById(id);
    }

    @GetMapping(path = "name/{userName}")
    public Admin getAdminByName(@PathVariable("userName")String userName){
        return adminService.getAdminByUserName(userName);
    }

    @PostMapping
    public APIResponse<Admin> addNewAdmin(@RequestBody Admin admin){
        return adminService.addNewAdmin(admin);
    }

    @DeleteMapping(path = "{id}")
    public APIResponse<Long> deleteAdmin(@PathVariable("id")Long id){
        return adminService.deleteAdmin(id);
    }

    @PutMapping(path = "{id}")
    public APIResponse<Object> updateAdmin(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String password
    ){
        return adminService.updateAdmin(id,userName,password);
    }
}
