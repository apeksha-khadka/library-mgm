package com.project.libraraymgm.manager.service;

import com.project.libraraymgm.manager.domain.Admin;
    import com.project.libraraymgm.manager.infrastructure.AdminRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    //create, edit, delete book
    public Admin saveAdmin(Admin admin) {
        try {

            Admin savedAdmin = adminRepository.save(admin);
            return savedAdmin;
        } catch (Exception ex) {

            throw ex;
        }

    }


    }


