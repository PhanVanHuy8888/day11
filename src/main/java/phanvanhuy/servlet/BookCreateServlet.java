package phanvanhuy.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import phanvanhuy.conn.ConnectionUtils;
import phanvanhuy.entity.Book;
import phanvanhuy.dao.BookDao;
import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class BookCreateServlet
 */
@WebServlet("/bookCreate")
public class BookCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher  = request.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/bookCreate.jsp");
		dispatcher.forward(request, response);}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		
		String bookId = (String) request.getParameter("BookId");
		String title = (String) request.getParameter("Title");
		String author = (String) request.getParameter("Author");
		String release = (String) request.getParameter("Release");
		String price = (String)  request.getParameter("Price");
		String picture = (String) request.getParameter("Picture");
		int Rel = 0;
		try {
			Rel = Integer.parseInt(release);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		float donGia = 0;
		try {
			donGia = Float.parseFloat(price);
		} catch (Exception e) {
			errorString = e.getMessage();
		}
		Book book = new Book(bookId,title,author,Rel,donGia,picture);
		String regex = ".*"; 
		if(bookId == null || !bookId.matches(regex)) {
		    errorString = "Book code invalid!";
		}
		
		if(errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("book", book);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/bookCreate.jsp");
			
			dispatcher.forward(request, response);
			return;
		}
		Connection conn = null;
		try {
			conn = ConnectionUtils.getMSSQLConnection();
			BookDao.insertBook(conn, book);
			response.sendRedirect(request.getContextPath()+"/bookList");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/WEB-INF/views/bookCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
