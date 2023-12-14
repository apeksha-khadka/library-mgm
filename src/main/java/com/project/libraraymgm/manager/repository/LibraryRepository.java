package com.project.libraraymgm.manager.repository;

import com.project.libraraymgm.manager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepository extends JpaRepository<User,Long> {
}
