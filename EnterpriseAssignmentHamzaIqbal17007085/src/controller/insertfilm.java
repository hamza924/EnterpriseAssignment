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

import com.google.gson.*;

/**
 * Servlet implementation class insertfilm
 */
@WebServlet("/insertfilm")
public class insertfilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertfilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Gson gson = new Gson();
		FilmDAO fd = new FilmDAO();
		PrintWriter out = response.getWriter();
		// creating variables to access the parameters being sent from browser
		String title = request.getParameter("Filmname");
		String id = request.getParameter("ID");
		String year = request.getParameter("Year");
		String director = request.getParameter("Director");
		String stars = request.getParameter("Stars");
		String reviews = request.getParameter("Reviews");
		
		Film f = new Film();
		
		f.setId(id);
		f.setTitle(title);
		f.setDirector(director);
		f.setYear(year);
		f.setReview(reviews);
		f.setStars(stars);
		System.out.println(title);
		System.out.println(id);
		// adding the film to the database
		fd.insertfilm(f);
		out.println("FILM HAS BEEN INSERTED ID IS:"+ id +",TITLE IS: " +title+",YEAR IS: "+year+",DIRECTOR: "+ director+",STARS ARE:  " +stars+",REVIEW: "+reviews);
		//response.sendRedirect("Filmeditjsp.jsp");
		//out.println(id+title+year+director+stars+reviews+" WAS INSERTED ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
