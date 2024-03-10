package phanvanhuy.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phanvanhuy.conn.ConnectionUtils;
import phanvanhuy.entity.Book;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import phanvanhuy.dao.BookDao;

/**
 * Servlet implementation class BookEdit
 */
@WebServlet("/bookEdit")
public class BookEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSach = (String) request.getParameter("BookId");
		Connection conn = null;
		String errorString = null;
		Book book = null;

		try {
			conn = ConnectionUtils.getMSSQLConnection();
			book = BookDao.findBook(conn, maSach);

			if (book == null) {
				errorString = "Book not found with code: " + maSach;
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/bookEdit.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/bookEdit.jsp");
			dispatcher.forward(request, response);
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
