package me.newsong.service;

import java.sql.SQLException;
import java.util.List;

import me.newsong.dao.CustomerDao;
import me.newsong.domain.Customer;
import me.newsong.domain.PageBean;

public class CustomerService {
	private CustomerDao dao;

	public CustomerService() {
		dao = new CustomerDao();
	}

	public void add(Customer customer) {
		try {
			dao.add(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Customer customer) {
		try {
			dao.update(customer);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int id) {
		try {
			dao.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Customer findByID(int id) {
		Customer customer = null;
		try {
			customer = dao.findByID(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;
	}

	public List<Customer> findAll() {
		List<Customer> list = null;
		try {
			list = dao.findAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public PageBean<Customer> query(Customer customer,int currPageCode,int pageSize) {
		PageBean<Customer> pageBean = null;
		try {
			pageBean = new PageBean<Customer>(currPageCode, dao.totalRecordNumWithCondition(customer), pageSize,"findByPage");
			pageBean.setDatas(dao.query(customer,pageBean.getCurrPageBeginIndex(), pageSize));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageBean;
	}

	
	public PageBean<Customer> findByPage(int currPageCode,int pageSize) {
		PageBean<Customer> pageBean = null;
		try {
			pageBean = new PageBean<Customer>(currPageCode, dao.totalRecordNum(), pageSize,"findByPage");
			pageBean.setDatas(dao.findByPage(pageBean.getCurrPageBeginIndex(), pageSize));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageBean;
	}
}
