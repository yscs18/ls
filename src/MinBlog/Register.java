package MinBlog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String USERS="c:/workspace/Gossip/users";
	private static final String SUCCESS_VIEW="success.view";
	private static final String ERROR_VIEW="erro.view";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String confirmedPasswd=request.getParameter("confiredPasswd");
		List<String>errors=new ArrayList<String>();
		if(isInvalidEmail(email)){
			errors.add("未填写邮件或邮件格式不正确");
			
		}
		if(isInvalidUsername(username)){
			errors.add("用户名称称为空或已存在");
		}
		if(isInvalidPassword(password,confirmedPasswd)){
			errors.add("请确认密码是否符合格式并再次确认密码");
		}
		String resultPage=ERROR_VIEW;
		if(!errors.isEmpty()){
			request.setAttribute("errors", errors);
		}else{
			resultPage=SUCCESS_VIEW;
			createUserDate(email,username,password);
			
		}
		request.getRequestDispatcher(resultPage).forward(request,response);
		
		
		
	}
	private boolean isInvalidEmail(String email){
		return email==null||!email.matches("^[_a-z0-9-]+([.]"+"[_a-z0-9-]+)*a[a-z0-9-]+([.][a-z0-9-]+)*$");
	}
	private boolean isInvalidUsername(String username){
		for(String file:new File(USERS).list()){
			if(file.equals(username)){
				return true;
			}
		}
		return false;
		
	}
	private boolean isInvalidPassword(String password,String confirmedPasswd){
		return password==null||password.length()<6||password.length()>16||!password.equals(confirmedPasswd);
	}
	private void createUserDate(String email,String username,String password)throws IOException{
		File userhome=new File(USERS+"/"+username);
		userhome.mkdir();
		BufferedWriter writer=new BufferedWriter(new FileWriter(userhome+"/porfile"));
		writer.write(email+"\t"+password);
		writer.close();
	}

}
