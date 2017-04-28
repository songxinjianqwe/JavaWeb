import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DerivedServlet extends BaseServlet {
	public String addUser(HttpServletRequest request,HttpServletResponse response){
		//...
		return "f:/views/a.jsp";
	}
	public String updateUser(HttpServletRequest request,HttpServletResponse response){
		//..
		return "r:/views/b.jsp";
	}
	public String deleteUser(){
		//...
		return null;
	}
}
