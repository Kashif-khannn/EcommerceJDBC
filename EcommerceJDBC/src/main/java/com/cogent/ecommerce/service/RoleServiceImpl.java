package com.cogent.ecommerce.service;

import com.cogent.ecommerce.model.Role;

public class RoleServiceImpl implements RoleService {
	
	private static RoleServiceImpl roleService;
	
	private RoleServiceImpl() {
			
		}
	public static RoleService getInstance() {
		if(roleService == null) {
			synchronized(RoleServiceImpl.class) {
				if(roleService == null) {
					roleService = new RoleServiceImpl();
					return roleService;
				}
			}
			
		}
		return roleService;
	}

	@Override
	public String addRole(Role role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getRole(String roleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteRoleById(String roleId) {
		// TODO Auto-generated method stub
		return null;
	}

}
