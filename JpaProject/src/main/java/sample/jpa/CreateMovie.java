package sample.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sample.jpa.entities.Movie;
import sample.jpa.pk.MoviePk;

public class CreateMovie {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String unitName="JPA1";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(unitName);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		MoviePk moviePk = new MoviePk("M03","NoteBook");
		Movie movie = new Movie(moviePk,"Romance",2003);

		EntityTransaction entityTransaction= entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(movie);//insert into entityManager cache
		
		
		entityTransaction.commit();//inserts into DB --Commit will happen as par of flush autometically
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("Created movie");
		
		
		
		

	}

}
