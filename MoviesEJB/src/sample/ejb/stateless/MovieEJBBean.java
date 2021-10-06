package sample.ejb.stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sample.jpa.entities.Movie;

/**
 * Session Bean implementation class MovieEJBBean
 */
@Stateless(mappedName = "movies")
public class MovieEJBBean implements MovieEJBBeanRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="JPA1")//for implementation
	EntityManager entityManager;
    public MovieEJBBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addMovie(Movie movie) {
		// TODO Auto-generated method stub
		entityManager.persist(movie);
		
	}

	@Override
	public void removeMovie(Movie movie) {
		// TODO Auto-generated method stub
		entityManager.remove(movie);
		
	}
    

}
