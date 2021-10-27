package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Catalog;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class CatalogRepositoryImpl implements CatalogRepository {
	@Autowired
	DBUtils dbUtils;
	
	public String addInventory(Catalog catalog) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into catalog(productId,productName,catId,productDescription,productImage) values(?,?,?,?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			int result = ps.executeUpdate();
			ps.setString(1, catalog.getProductId());
			ps.setString(2, catalog.getProductName());
			ps.setString(3, catalog.getCatId());
			ps.setString(4, catalog.getProductDescription());
			ps.setString(5, catalog.getProductImage());
			
		
			
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

		// TODO Auto-generated method stub
		
	
	

	public void deleteAll() {
		int count = 0;
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from catalog";
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

	public String deleteCatalogById(String productId) {
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from catalog where productId = ?";
		
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
		return null;
	}
		
		

	public Optional<Catalog> getCatalogById(String catId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from catalog where catId = " + catId;
		ResultSet rs = null;
		Catalog catalog = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 catalog = new Catalog();
					catalog.setProductId(rs.getString("productId"));
					catalog.setProductName(rs.getString("productName"));
					catalog.setCatId(rs.getString("catId"));
					catalog.setProductId(rs.getString("productDescription"));
					catalog.setProductImage(rs.getString("productImage"));
					
				}
				
				
				
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dbUtils.closeConnection(conn);
		}
		
		return Optional.empty();
	}
		
		
	

}
