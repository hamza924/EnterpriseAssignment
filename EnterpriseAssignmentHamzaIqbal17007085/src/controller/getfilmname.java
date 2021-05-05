package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Film;
import model.FilmDAO;

/**
 * Servlet implementation class getfilmname
 */
@WebServlet("/getfilmname")
public class getfilmname extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getfilmname() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
		FilmDAO fd = new FilmDAO();
		// getting film name that is stored inside of filmname 
		String searchfilmname = request.getParameter("Filmname");
		
		ArrayList<Film> film = fd.getFilmName(searchfilmname);
		
			for(int i =0; i <film.size();i++) {
			
			Film onefilm = film.get(i);
			
			System.out.println(onefilm.toString());
		}
			Gson gson = new Gson();
			
			String alljson = gson.toJson(film);
			
			out.println(alljson);
			
			String msg = "Showing search results based off search parameter";
			out.println(msg+ " " + searchfilmname);
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
