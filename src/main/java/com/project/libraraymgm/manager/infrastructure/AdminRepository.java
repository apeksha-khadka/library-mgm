package com.project.libraraymgm.manager.infrastructure;

import com.project.libraraymgm.manager.domain.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
