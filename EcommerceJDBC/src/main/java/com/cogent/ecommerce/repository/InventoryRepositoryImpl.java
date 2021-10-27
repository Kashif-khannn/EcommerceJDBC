package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Inventory;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class InventoryRepositoryImpl implements InventoryRepository {
	
	@Autowired
	DBUtils dbUtils;
	
	
	
	public String addInventory(Inventory inventory) {
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into inventory(catId,catName) values(?,?,?,?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			
			ps.setString(1, inventory.getInvId());
			ps.setString(2, inventory.getUserId());
			ps.setString(3, inventory.getProductId());
			ps.setString(4, inventory.getProductQty());
			ps.setDouble(5, inventory.getProductPrice());
		
			
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
		String query = "Delete from Inventory";
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
	

	public Optional<String> deleteProductById(String productId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from category where productId = ?";
		
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

	public Inventory getInventoryById(String invId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from inventory where invId = " + invId;
		ResultSet rs = null;
		Inventory inventory = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 inventory = new Inventory();
					inventory.setInvId(rs.getString("invId"));
					inventory.setUserId(rs.getString("userId"));
					inventory.setProductId(rs.getString("productId"));
					inventory.setProductQty(rs.getString("productQty"));
					inventory.setProductPrice(rs.getDouble("productPrice"));
				
					
				}
				
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(conn);
		}
		
		
		return null;
	}

}
