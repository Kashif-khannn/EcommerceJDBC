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
import com.cogent.ecommerce.model.User;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	DBUtils dbUtils;

	public String addUser(User user) {
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into Role(roleId,roleName) values(?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			
			ps.setString(1, user.getUserId());
			ps.setString(2, user.getUserName());
			ps.setString(3,user.getPassword());
			ps.setString(4, user.getEmailId());
			ps.setString(5, user.getRoleId());
			
			
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

	public User getUserName(String userName) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from user where userName = " + userName;
		ResultSet rs = null;
		User user = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 user = new User();
					 user.setUserId(rs.getString("userId"));
					 user.setUserName(rs.getString("userName"));
					 user.setPassword(rs.getString("password"));
					 user.setEmailId(rs.getString("emailId"));
					 user.setRoleId(rs.getString("roleId"));
					
					
				}
				
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(conn);
		}
		
		return null;
	}

	public String getUserById(String userId) {

		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from user where userId = " + userId;
		ResultSet rs = null;
		User user = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 user = new User();
					 user.setUserId(rs.getString("userId"));
					 user.setUserName(rs.getString("userName"));
					 user.setPassword(rs.getString("password"));
					 user.setEmailId(rs.getString("emailId"));
					user.setRoleId(rs.getString("roleId"));
					
					
				
					
				}
				
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(conn);
		}
		
		return null;
	}

	public void deleteAll() {
		int count = 0;
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from User";
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

	public Optional<String> deleteUserById(String userId) {
		// TODO Auto-generated method stub
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from user where userId = ?";
		
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
