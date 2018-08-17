package com.konrad.school.servis;

import com.konrad.school.iservice.IRole;
import com.konrad.school.model.Role;
import com.konrad.school.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService implements IRole {
    private RoleRepository roleRepository;

    @Autowired
    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role findRoleByName(String roleName) {
        return roleRepository.findRoleByName(roleName);
    }
}
