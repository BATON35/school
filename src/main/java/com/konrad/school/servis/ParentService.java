package com.konrad.school.servis;

import com.konrad.school.crm.CrmParent;
import com.konrad.school.iservice.IParentService;
import com.konrad.school.model.Parent;
import com.konrad.school.model.Role;
import com.konrad.school.repository.ParentRepository;
import com.konrad.school.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class ParentService implements IParentService {
    @Autowired
    private ParentRepository parentRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

//    @Autowired
//    ParentService(ParentRepository parentRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
//        this.roleRepository = roleRepository;
//        this.parentRepository = parentRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Override
    @Transactional
    public Parent findByUserName(String userName) {
        return parentRepository.findByUserName(userName);
    }

    @Override
    @Transactional
    public void save(CrmParent crmParent) {
        Parent parent = new Parent();
        parent.setUserName(crmParent.getUserName());
        parent.setPassword(passwordEncoder.encode(crmParent.getPassword()));
        parent.setFirstName(crmParent.getFirstName());
        parent.setLastName(crmParent.getLastName());
        parent.setLastName(crmParent.getMail());
        parent.setRoles(Arrays.asList((roleRepository.findRoleByName("ROLE_EMPLOYEE"))));
        parentRepository.save(parent);
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Parent parent = parentRepository.findByUserName(userName);
        if (parent == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(parent.getUserName(), parent.getPassword(),
                mapRolesToAuthorities(parent.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
