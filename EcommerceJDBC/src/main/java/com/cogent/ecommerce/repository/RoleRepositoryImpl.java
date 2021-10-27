package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Orders;
import com.cogent.ecommerce.model.Role;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class RoleRepositoryImpl implements RoleRepository {
	@Autowired
	DBUtils dbUtils;
	

	public String addRole(Role role) {
		
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into Role(roleId,roleName) values(?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			
			ps.setString(1, role.getRoleId());
			ps.setString(2, role.getRoleName());
			
			
			int result = ps.executeUpdate();
			
			if(result > 0 ) {
				return "success";
			}
				else {
					return "failure";
				}
					
			
			
			
			
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(conn);
		}
		return null;

	}

	public void deleteAll() {
		int count = 0;
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from Role";
		try {
			ps = conn.prepareStatement(query);
			count = ps.executeUpdate();
			
			if(count == 0) {
				System.out.println("no record found to delete");
			} else {
				System.out.println(count + " no of records deleted");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			dbUtils.closeConnection(conn);
		}

	}

	public Role getRole(String roleName) {
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from orders where roleName = " + roleName;
		ResultSet rs = null;
		Role role = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 role = new Role();
					 role.setRoleId(rs.getString("roleId"));
					 role.setRoleName(rs.getString("roleName"));
					
					
				}
				
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(conn);
		}
		
		
		return null;
	}
		
	

	public Optional<String> deleteRoleById(String roleId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from role where roleId = ?";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
				int rs = ps.executeUpdate();
				
			if(rs == 0) {
				System.out.println(" no records to delete found");
				
			} else {
				System.out.println(rs + "count of records deleted");
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
			
		}
		finally {
			dbUtils.closeConnection(conn);
		}
		
	
	
		return Optional.empty();

		
	}

}
