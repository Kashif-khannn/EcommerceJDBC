 package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Category;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
	@Autowired
	DBUtils dbUtils;
	
	
	
	
	
	public String addCategory(Category category) {
		// TODO Auto-generated method stub
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into category(catId,catName) values(?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			
			ps.setString(1, category.getCatId());
			ps.setString(2, category.getCatName());
		
			
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
		String query = "Delete from cart";
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

	public String deleteCategoryById(String catId) {
		
		
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from category where catId = ?";
		
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

	public Optional<Category> getCategoryById(String catId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from category where catId = " + catId;
		ResultSet rs = null;
		Category category = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 category = new Category();
					category.setCatId(rs.getString("catId"));
					category.setCatName(rs.getString("catName"));
				
					
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
