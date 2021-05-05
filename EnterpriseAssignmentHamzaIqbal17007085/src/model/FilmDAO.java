package model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.*;


public class FilmDAO {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
	String user = "MY406VIslO"; 
	String user1 ="hamza";
    String password = "QdA98a6Hpk";
    // Note none default port used, 6306 not 3306
    String url = "jdbc:mysql://remotemysql.com:3306/"+user;

	public FilmDAO() {}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(url, user, password);
		    stmt = conn.createStatement();
		    
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getString("id"),
					rs.getString("title"),
					rs.getString("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	
	
	
   public ArrayList<Film> getAllFilms(){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
   }

   public Film getFilmByID(String id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }
   
   public ArrayList<Film> getFilmName(String film){
	   
		ArrayList<Film> allFilms = new ArrayList<Film>();
		openConnection();
		
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films  where title like '%"+film+"%';";
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
		    
		    System.out.println(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    	allFilms.add(oneFilm);
		   }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return allFilms;
  }
   
 
	public int insertfilm(Film f) {
		
		openConnection();
		try{
		   String insert = "insert into films(id,title,year,director,stars,review)"
				   + "values('"+f.getId()+"','"+
				   				f.getTitle()+"','"+
				   				f.getYear()+"','"+
				   				f.getDirector()+"','"+
				   				f.getStars()+"','"+
				   				f.getReview()+"')";
		int j =     stmt.executeUpdate(insert);
		    System.out.println(insert);
		    
		    if(j!=0) {
		    	System.out.println("SUCCES");
		    }
	    // Retrieve the results
		   

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }
		
		
		return 0;
		
	} 
	   
	public int deletefilm(String f) {
		openConnection();
		try{
			   String delete = "DELETE FROM films where id='"+f+"';";
			int j =     stmt.executeUpdate(delete);
			    System.out.println(delete);
			    
			    if(j!=0) {
			    	System.out.println("SUCCES");
			    }
			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }
		return 0;
		
	}
	
	public int updatefilm(Film f) {
		openConnection();
		try{
			   String update = "UPDATE films SET id = '"+f.getId()+"',"+
					   "title = '"+f.getTitle()+"',"+
					   "year = '"+f.getYear()+"',"+
					   "director = '"+f.getDirector()+"',"+
					   "stars = '"+f.getStars()+"',"+
					   "review = '"+f.getReview()+"'"+
					   "where id='"+f.getId()+"';";
			int j =     stmt.executeUpdate(update);
			    System.out.println(update);
			    
			    if(j!=0) {
			    	System.out.println("SUCCES");
			    }
			    stmt.close();
			    closeConnection();
			} catch(SQLException se) { System.out.println(se); }
		
		
		
		return 0;
		
	}
   
   
}
