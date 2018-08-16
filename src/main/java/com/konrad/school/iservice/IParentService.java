package com.konrad.school.iservice;

import com.konrad.school.crm.CrmParent;
import com.konrad.school.model.Parent;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IParentService  {
    Parent findByUserName(String ParentName);
    void save(CrmParent crmParent);
}
