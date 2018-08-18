package com.konrad.school.iservice;

import com.konrad.school.model.Role;

public interface IRole {
    Role findRoleByName(String roleName);
}
