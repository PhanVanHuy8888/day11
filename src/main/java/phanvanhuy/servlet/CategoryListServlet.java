package phanvanhuy.servlet;

import jakarta.servlet.RequestDispatcher;
import phanvanhuy.entity.Category;
import phanvanhuy.dao.CategoryDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phanvanhuy.conn.ConnectionUtils;

import java.io.IOException;
import java.sql.*;
import java.util.List;

/**
 * Servlet implementation class CategoryListServlet
 */
@WebServlet("/categoryList")
public class CategoryListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Connection conn = null;
		String errorString = null;
		List<Category> list = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();

			try {
				list = CategoryDao.queryCategory(conn);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
			// Store info in request attribute, before forward to views
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", list);
//	          request.setAttribute("deptName", deptName);

			// Forward to /WEB-INF/views/productListView.jsp
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/categoryList.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			errorString = e1.getMessage();
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/categoryList.jsp");
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String cateName = (String) request.getParameter("categoryName");
//	        response.sendRedirect(request.getContextPath() + "/DepartmentListServlet");
		String sql = "Select * from Category a where a.CategoryName like '%" + cateName + "%'";
		request.setAttribute("categoryName", cateName);
		List<Category> list = null;
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			if (cateName != null) {
				list = CategoryDao.findCategoryByName(conn, cateName);
			} else {
				list = CategoryDao.queryCategory(conn);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("category", list);
		request.setAttribute("cateName", cateName);
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/categoryList.jsp");
		dispatcher.forward(request, response);
	}

}
