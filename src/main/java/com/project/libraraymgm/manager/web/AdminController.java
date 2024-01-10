package com.project.libraraymgm.manager.web;

import com.project.libraraymgm.manager.domain.Admin;
import com.project.libraraymgm.manager.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/admin")
public class AdminController {

    private AdminService adminService;
    private AdminController(AdminService adminService){
        this.adminService=adminService;
    }

    @PostMapping()
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.saveAdmin(admin);
    }
}
