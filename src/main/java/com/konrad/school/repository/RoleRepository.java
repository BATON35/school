package com.konrad.school.repository;

import com.konrad.school.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository <Role, Integer> {
    Role findRoleByName(String roleName);
}
