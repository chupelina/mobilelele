package com.example.demo.repository;

import com.example.demo.model.entities.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends JpaRepository<UserRoleEntity, Long> {


}
