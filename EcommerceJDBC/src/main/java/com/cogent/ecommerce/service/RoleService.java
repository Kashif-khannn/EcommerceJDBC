package com.cogent.ecommerce.service;

import com.cogent.ecommerce.model.Role;

public interface RoleService {
	public String addRole(Role role);
	public void deleteAll();
	public Role getRole(String roleName);
	
	public String deleteRoleById(String roleId);
}
