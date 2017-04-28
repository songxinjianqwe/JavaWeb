package me.newsong.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.newsong.domain.User;
import me.newsong.utils.JDBCUtils;

public class UserDAO {
	
	public User findByUsername(String username){
		Connection conn = null;
		PreparedStatement  pstmt = null;
		ResultSet rs = null;
		User user = null;
		String sql = "select user_id,user_username,user_password from user where user_username = ?";
		try{
			conn = JDBCUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			if(rs.next()){
				user =  new User();
				user.setId(rs.getInt("user_id"));
				user.setUsername(rs.getString("user_username"));
				user.setPassword(rs.getString("user_password"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCUtils.free(rs, pstmt, conn);
		}
		return user;
	}
	
	public void addUser(User user){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "insert into user(user_username,user_password) values(?,?) ";
		try{
			conn = JDBCUtils.getConn();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			JDBCUtils.free(rs, pstmt, conn);
		}
	}
}
