package com.wallet.service;

import com.wallet.model.Role;
import com.wallet.model.RoleType;
import com.wallet.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /*
     * fetch List of roles by the given type of role
     * @param set<role>
     * @author Ronakt
     * */
    public List<Role> getReferenceByTypeIsIn(Set<RoleType> roleTypes) {
        return roleRepository.getReferenceByTypeIsIn(roleTypes);
    }

    /*
     *
     * returns all the roles
     *
     *
     * */
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

}
