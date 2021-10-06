package sample.jpa.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import sample.jpa.pk.MoviePk;

@Entity
@Table(name="MOVIE_MASTER")
public class Movie {
	@EmbeddedId
    MoviePk moviePk = new MoviePk();
	
	@Column(name="MOVIE_GENRE", length=15)
	private String genre;
	
	@Column(name="MOVIE_YEAR", length=4)
	private int year;

	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(MoviePk moviePk, String genre, int year) {
		super();
		this.moviePk = moviePk;
		this.genre = genre;
		this.year = year;
	}

	public MoviePk getMoviePk() {
		return moviePk;
	}

	public void setMoviePk(MoviePk moviePk) {
		this.moviePk = moviePk;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	



}
