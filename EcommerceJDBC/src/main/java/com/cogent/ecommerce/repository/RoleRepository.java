package com.cogent.ecommerce.repository;

import java.util.Optional;

import com.cogent.ecommerce.model.Role;

public interface RoleRepository {
	public String addRole(Role role);
	public void deleteAll();
	public Role getRole(String roleName);
	
	public Optional<String> deleteRoleById(String roleId);

}
