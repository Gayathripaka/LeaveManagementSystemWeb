package com.virtusa.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.DAO.EmployeeDao;

import com.virtusa.converter.DateConverter;
import com.virtusa.helper.FactoryHr;
import com.virtusa.model.RetriveEmployeeDesignationModel;
import com.virtusa.service.HrService;




/**
 * Servlet implementation class HrServlet
 */
@WebServlet("/HrServlet")
public class HrServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HrService hrservice=null;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HrServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.hrservice=FactoryHr.createHrService();
        
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		if(action.contentEquals("loadform"))
		{
			List<RetriveEmployeeDesignationModel> retriveDesignationModelList=new ArrayList<>();
			request.setAttribute("retriveDesignationModelList",retriveDesignationModelList);

			RequestDispatcher dispatcher=
					request.getRequestDispatcher("employeeform.jsp");
			dispatcher.forward(request, response);	
		}		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String action=request.getParameter("action");
		 if(action.contentEquals("newEmployee")) 
		 {
			 int employeeId=Integer.parseInt(request.getParameter("employeeId"));
			    String firstName=request.getParameter("firstName");
	        	String lastName=request.getParameter("lastName");
	        	String email=request.getParameter("email");
	        	String phoneNumber=request.getParameter("phoneNumber");
	        	String hire_Date=request.getParameter("hireDate");
	        	LocalDate hireDate=DateConverter.convertLocaleDate(hire_Date, "-");
	        	String dateOfBirth=request.getParameter("hireDate");
	        	LocalDate dateOfBirth=DateConverter.convertLocaleDate(hire_Date, "-");
			 
		 }
		
		//doGet(request, response);
	}

}
