package me.newsong.web.servlet;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.newsong.domain.Customer;
import me.newsong.domain.PageBean;
import me.newsong.service.CustomerService;
import me.newsong.utils.BaseServlet;

public class CustomerServlet extends BaseServlet {

	public String add(HttpServletRequest request, HttpServletResponse response)  {
		Customer customer = null;
		try {
			customer = encodeCustomer(request);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		CustomerService service = new CustomerService();
		service.add(customer);
		request.setAttribute("msg", "注册成功!");
		return "f:/views/msg.jsp";
	}

	public String update(HttpServletRequest request, HttpServletResponse response)  {
		Customer customer = null;
		try {
			customer = encodeCustomer(request);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		CustomerService service = new CustomerService();
		service.update(customer);
		request.setAttribute("msg", "修改成功!");
		return "f:/views/msg.jsp";
	}

	public String delete(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("cid"));
		CustomerService service = new CustomerService();
		service.delete(id);
		request.setAttribute("msg", "删除成功!");
		return "f:/views/msg.jsp";
	}

	public String findAll(HttpServletRequest request, HttpServletResponse response) {
		CustomerService service = new CustomerService();
		List<Customer> list = service.findAll();
		request.setAttribute("cstmList", list);
		return "f:/views/list.jsp";
	}

	public String findByID(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("cid"));
		CustomerService service = new CustomerService();
		Customer customer = service.findByID(id);
		request.setAttribute("cstm", customer);
		return "f:/views/edit.jsp";
	}

	public String query(HttpServletRequest request, HttpServletResponse response) {
		String cpc = request.getParameter("currPageCode");
		int currPageCode = 1;
		if(cpc != null && !cpc.trim().isEmpty()){
			currPageCode = Integer.parseInt(cpc);
		}
		Customer customer = null;
		try {
			customer = encodeCustomer(request);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		CustomerService service = new CustomerService();
		PageBean<Customer> bean = service.query(customer,currPageCode,3);
		bean.setUrl(getURL(request));
		request.setAttribute("pageBean", bean);
		return "f:/views/list.jsp";
	}
	
	public String findByPage(HttpServletRequest request, HttpServletResponse response){
		String cpc = request.getParameter("currPageCode");
		int currPageCode = 1;
		if(cpc != null && !cpc.trim().isEmpty()){
			currPageCode = Integer.parseInt(cpc);
		}
		CustomerService service = new CustomerService();
		PageBean<Customer> bean = service.findByPage(currPageCode,3);
		bean.setUrl(getURL(request));//这里虽然不需要复杂查询的参数，但是需要方法名
		request.setAttribute("pageBean", bean);
		return "f:/views/list.jsp";
	}
	
	public Customer encodeCustomer(HttpServletRequest request) throws UnsupportedEncodingException, ParseException{
		Customer customer = new Customer();
		String id = request.getParameter("cid");
		if(id != null && !id.trim().isEmpty()){
			customer.setCid(Integer.parseInt(id));
		}
		String name = request.getParameter("cname");
		if(name != null && !name.trim().isEmpty()){
			customer.setCname(name);
		}
		String gender = request.getParameter("gender");
		if(gender != null && !gender.trim().isEmpty()){
			customer.setGender(gender);
		}
		String birthday = request.getParameter("birthday");
		if(birthday != null && !birthday.trim().isEmpty()){
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			customer.setBirthday(dateFormat.parse(birthday));
		}
		String cellphone = request.getParameter("cellphone");
		if(cellphone != null && !cellphone.trim().isEmpty()){
			customer.setCellphone(cellphone);
		}
		String email = request.getParameter("email");
		if(email != null && !email.trim().isEmpty()){
			customer.setEmail(email);
		}
		String description = request.getParameter("description");
		if(description != null && !description.trim().isEmpty()){
			customer.setDescription(description);
		}
		return customer;
	}
	
	
	public String getURL(HttpServletRequest request){
		String queryString = request.getQueryString();
		if(queryString.contains("&currPageCode=")){
			int index = queryString.indexOf("&currPageCode=");
			queryString = queryString.substring(0,index);
		}
		return queryString;
	}
}
