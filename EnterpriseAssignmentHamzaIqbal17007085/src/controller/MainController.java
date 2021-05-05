package controller;

import java.util.ArrayList;

import com.google.gson.Gson;

import model.Film;
import model.FilmDAO;

public class MainController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FilmDAO fd = new FilmDAO();
		
		ArrayList<Film> film = fd.getAllFilms();
		
		for(int i =0; i <film.size();i++) {
			
			Film onefilm = film.get(i);
			
			System.out.println(onefilm.toString());
		}
		
		Gson gson = new Gson();
		
		String alljson = gson.toJson(film);
		
		System.out.println(alljson);
	}

}
