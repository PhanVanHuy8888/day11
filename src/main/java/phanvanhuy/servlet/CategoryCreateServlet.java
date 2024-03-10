package phanvanhuy.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phanvanhuy.conn.ConnectionUtils;
import phanvanhuy.dao.CategoryDao;
import phanvanhuy.entity.Category;

import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class CategoryCreateServlet
 */
 @WebServlet("/categoryCreate")
public class CategoryCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher  = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/categoryCreate.jsp");
		dispatcher.forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
		//Lay du lieu tren from
		String categoryName = (String) request.getParameter("categoryName");
		Category category = new Category(categoryName);
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", category);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/categoryCreate.jsp");
			
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			CategoryDao.insertCategory(conn, category);
			response.sendRedirect(request.getContextPath()+"/categoryList");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/categoryCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
