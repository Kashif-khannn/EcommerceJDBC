package com.cogent.ecommerce.repository;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Cart;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class CartRepositoryImpl implements CartRepository {
	@Autowired
	DBUtils dbUtils;

	public String addCart(Cart cart) {
		// TODO Auto-generated method stub
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into cart(cartId, userId, invId, productId, productQty, totalPrice) values(?,?,?,?,?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			
			ps.setString(1, cart.getCartId());
			ps.setString(2, cart.getUserId());
			ps.setString(3, cart.getInvId());
			ps.setString(4, cart.getProductId());
			ps.setString(5, cart.getProductQty());
			ps.setDouble(6, cart.getTotalPrice());
			
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
		// TODO Auto-generated method stub
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

	public String deleteCartById(String cartId) {
		// TODO Auto-generated method stub
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from cart where cartId = ?";
		
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

	public Optional<Cart> getCartById(String cartId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from cart where cartId = " + cartId;
		ResultSet rs = null;
		Cart cart = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 cart = new Cart();
					cart.setCartId(rs.getString("cartId"));
					cart.setUserId(rs.getString("userId"));
					cart.setInvId(rs.getString("invId"));
					cart.setProductId(rs.getString("productId"));
					cart.setProductQty(rs.getString("productQty"));
					cart.setTotalPrice(rs.getDouble("totalPrice"));
					
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
