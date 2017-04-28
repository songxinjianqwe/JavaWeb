package me.newsong.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import me.newsong.domain.Customer;
import me.newsong.utils.JDBCUtils;

public class CustomerDao {

	public void add(Customer customer) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into t_customer(cname,gender,birthday,cellphone,email,description) values(?,?,?,?,?,?)";
		Object[] params = { customer.getCname(),customer.getGender(),customer.getBirthday(),customer.getCellphone(),customer.getEmail(),customer.getDescription()};
		runner.update(sql, params);
	}

	public void update(Customer customer) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_customer set cname = ? , gender = ? , birthday = ? , cellphone = ? , email = ? , description = ? where cid = ?";
		Object[] params = { customer.getCname(),customer.getGender(),customer.getBirthday(),customer.getCellphone(),customer.getEmail(),customer.getDescription(),customer.getCid()};
		runner.update(sql, params);
	}

	public void delete(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from t_customer where cid = ?";
		Object[] params = { id };
		runner.update(sql, params);
	}

	public List<Customer> findAll() throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_customer ";
		List<Customer> list = runner.query(sql, new BeanListHandler<Customer>(Customer.class));
		return list;
	}

	public Customer findByID(int id) throws SQLException {
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_customer where cid = ?";
		Object[] params = { id };
		Customer customer = runner.query(sql, new BeanHandler<Customer>(Customer.class), params);
		return customer;
	}
	
	public List<Customer> query(Customer customer,int beginIndex,int length) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		StringBuilder sql = new StringBuilder("select * from  t_customer where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		if(customer.getCname() != null && !customer.getCname().isEmpty()){
			sql.append("and cname = ? ");
			params.add(customer.getCname());
		}
		if(customer.getGender() != null && !customer.getGender().isEmpty()){
			sql.append("and gender = ? ");
			params.add(customer.getGender());
		}
		if(customer.getEmail() != null && !customer.getEmail().isEmpty()){
			sql.append("and email = ? ");
			params.add(customer.getEmail());
		}
		if(customer.getCellphone() != null && !customer.getCellphone().isEmpty()){
			sql.append("and cellphone = ? ");
			params.add(customer.getCellphone());
		}
		sql.append("limit ?,?");
		params.add(beginIndex);
		params.add(length);
		List<Customer> list = runner.query(sql.toString(), new BeanListHandler<Customer>(Customer.class),params.toArray());
		return list;
	}
	
	public List<Customer> findByPage(int beginIndex,int length) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select * from t_customer limit ?,?";
		Object[] params = {beginIndex,length};
		List<Customer> list = runner.query(sql, new BeanListHandler<Customer>(Customer.class),params);
		return list;
	}
	
	public int totalRecordNumWithCondition(Customer customer) throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		StringBuilder sql = new StringBuilder("select count(*) from  t_customer where 1 = 1 ");
		List<Object> params = new ArrayList<>();
		if(customer.getCname() != null && !customer.getCname().isEmpty()){
			sql.append("and cname = ? ");
			params.add(customer.getCname());
		}
		if(customer.getGender() != null && !customer.getGender().isEmpty()){
			sql.append("and gender = ? ");
			params.add(customer.getGender());
		}
		if(customer.getEmail() != null && !customer.getEmail().isEmpty()){
			sql.append("and email = ? ");
			params.add(customer.getEmail());
		}
		if(customer.getCellphone() != null && !customer.getCellphone().isEmpty()){
			sql.append("and cellphone = ? ");
			params.add(customer.getCellphone());
		}
		long i = runner.query(sql.toString(), new ScalarHandler<Long>(),params.toArray());
		return (int) i;
	}
	
	public int totalRecordNum() throws SQLException{
		QueryRunner runner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select count(*) from t_customer";
		long i = runner.query(sql, new ScalarHandler<Long>());
		return (int) i;
	}
}
