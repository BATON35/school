package com.konrad.school.servis;

import com.konrad.school.crm.CrmParent;
import com.konrad.school.iservice.IParentService;
import com.konrad.school.model.Parent;
import com.konrad.school.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService implements IParentService {
    private ParentRepository parentRepository;

    @Autowired
    ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public Parent findByUserName(String ParentName) {
        return parentRepository.;
    }

    @Override
    public void save(CrmParent crmParent) {

    }
}
