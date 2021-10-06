package sample.ejb.stateless;

import javax.ejb.Remote;

import sample.jpa.entities.Movie;

@Remote
public interface MovieEJBBeanRemote {
	void addMovie(Movie movie);
	void removeMovie(Movie movie);
	

}
