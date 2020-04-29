package com.ssm.maven.core.service;

import com.ssm.maven.core.entity.Role;

import java.io.Serializable;
import java.util.List;

/**
 * @author Administrator
 */
public interface RoleService extends Serializable {
    /**
     *  get role list
     * @return role list
     */
    List<Role> roleList();

    /**
     *  find role by id
     * @param id role id
     * @return Role object
     */
    Role findRoleById(String id );
    /**
     *  add role
     * @param role role object
     */
    void addRole(Role role);

    /**
     * update role
     * @param role role object
     */
    void  updateRole(Role role);

    /**
     * delete role
     * @param id String
     */
    void  deleteRole(String id);
}
