package sample.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import sample.jpa.entities.Movie;
import sample.jpa.pk.MoviePk;

public class LoadMovie {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String unitName="JPA1";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(unitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Loading single movie
		MoviePk moviePk = new MoviePk("M01","Troy");
        Movie movie = entityManager.find(Movie.class, moviePk);
        System.out.println("Movie ID: "+ movie.getMoviePk().getMovieId());
        System.out.println("Movie Name: "+ movie.getMoviePk().getName());
        System.out.println("Movie Year: "+ movie.getYear());
        System.out.println("Movie Genre: "+ movie.getGenre());
        System.out.println("Retrived movie");
        
        System.out.println("Priniting all movie");
        
        //Loading all movies
        Query query1 = entityManager.createQuery("select u from Movie u");
        List<Movie> movieList = query1.getResultList();
		for(Movie movies : movieList) {
			System.out.println(movies.getMoviePk().getMovieId() + ", " + movies.getMoviePk().getName()+ ", " + movies.getYear()+ ", " + movies.getGenre());
		}
        
		System.out.println("Priniting 2003 movies dirctky from table using Native query");
        Query query = entityManager.createNativeQuery("Select * from MOVIE_MASTER e where e.Movie_year = :movieYear");
        query.setParameter("movieYear", "2003");
        List<Object []> movieList1 = query.getResultList();
		for(Object movies[] : movieList1) {
			System.out.println(movies[0] + ", " + movies[1]+ ", " + movies[2]+ ", " + movies[3]);
		}
		System.out.println("Done!!");


		entityManager.close();
		entityManagerFactory.close();
		System.out.println("Retrived movie");
		
		
		
		

	}

}
