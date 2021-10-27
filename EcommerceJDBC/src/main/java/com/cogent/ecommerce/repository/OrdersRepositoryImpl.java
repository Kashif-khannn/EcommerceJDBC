package com.cogent.ecommerce.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cogent.ecommerce.model.Inventory;
import com.cogent.ecommerce.model.Orders;
import com.cogent.ecommerce.utils.DBUtils;
@Repository
public class OrdersRepositoryImpl implements OrdersRepository {
	@Autowired
	DBUtils dbUtils;
	
	

	public String addOrder(Orders order) {
		// TODO Auto-generated method stub
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "insert into Orders(orderId, userId, invId, productId, productQty,totalPrice, grandTotalPrice) values(?,?,?,?,?,?,?) ";
		
		try {
			if(conn!=null)
				ps = conn.prepareStatement(query);
			
			
			ps.setString(1, order.getOrderId());
			ps.setString(2, order.getUserId());
			ps.setString(3, order.getInvId());
			ps.setString(4, order.getProductId());
			ps.setString(5, order.getProductQty());
			ps.setDouble(6, order.getTotalPrice());
			ps.setDouble(7, order.getGrandTotalPrice());
		
			
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
		String query = "Delete from Orders";
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

	public boolean isOrderExists(String orderId) {
	
		Connection conn = null;
		String query = "select * from order where orderId = " + orderId;
		boolean result = false;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			conn = dbUtils.getConnection();
			if(conn!=null)
				conn.prepareStatement(query);
			rs = preparedStatement.executeQuery();
			
			if(rs.next()!=false) {
				System.out.println("Order Exists");
				result = true;
				return result;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public Optional<String> deleteOrderById(String orderId) {
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "Delete from orders where orderId = ?";
		
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

	public Orders getOrderById(String orderId) {
		
	
		Connection conn = dbUtils.getConnection();
		PreparedStatement ps = null;
		String query = "select * from orders where orderId = " + orderId;
		ResultSet rs = null;
		Orders orders = null;
		
		try {
			if(conn!=null) {
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				if(rs.next()) {
					 orders = new Orders();
					 orders.setProductId(rs.getString("productId"));
					 orders.setOrderId(rs.getString("orderId"));
					 orders.setGrandTotalPrice(rs.getDouble("grandTotalPrice"));
					 orders.setTotalPrice(rs.getDouble("totalPrice"));
					orders.setInvId(rs.getString("invId"));
					orders.setUserId(rs.getString("userId"));
					orders.setProductId(rs.getString("productId"));
					orders.setProductQty(rs.getString("productQty"));
					
				
					
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
