package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class updatefilm
 */
@WebServlet("/updatefilm")
public class updatefilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatefilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	
		FilmDAO fd = new FilmDAO();
		Film f = new Film();
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		// getting parameters and storing inside variables
		String title = request.getParameter("title");
		String year = request.getParameter("year");
		String director = request.getParameter("director");
		String stars = request.getParameter("stars");
		String review = request.getParameter("reviews");
		
		f.setId(id);
		f.setTitle(title);
		f.setYear(year);
		f.setDirector(director);
		f.setStars(stars);
		f.setReview(review);
		// updateing film using update method inside of dao
		fd.updatefilm(f);
		
		out.println("FILM HAS BEEN UPDATED ID IS "+id+", TITLE IS "+ title+", YEAR IS: "+year+", DIRECTOR IS: "+director+", STARS ARE: "+stars+", REVIEW: "+review);
		
		//response.sendRedirect("Filmeditjsp.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
