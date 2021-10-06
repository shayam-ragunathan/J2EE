package sample.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sample.jpa.entities.Movie;
import sample.jpa.pk.MoviePk;

public class UpdateMovie {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String unitName="JPA1";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(unitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		MoviePk moviePk = new MoviePk("M01","Troy");
        Movie movie = entityManager.find(Movie.class, moviePk);
        System.out.println("Movie ID: "+ movie.getMoviePk().getMovieId());
        System.out.println("Movie Name: "+ movie.getMoviePk().getName());
        System.out.println("Movie Year: "+ movie.getYear());
        System.out.println("Movie Genre: "+ movie.getGenre());
        
        System.out.println("Retrived movie");
        
        System.out.println("Updating year to 2009,ID to M04");
        
        //movie.setMovieId("M04");
        movie.setYear(2009);
        
        entityManager.merge(movie);  //used for update if entityManager is closed or something after set
        
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();
        entityTransaction.commit();
        


		entityManager.close();
		entityManagerFactory.close();
		
		
		
		
		

	}

}
