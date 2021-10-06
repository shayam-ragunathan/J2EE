package sample.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import sample.jpa.entities.Movie;
import sample.jpa.pk.MoviePk;
import sample.ejb.stateless.MovieEJBBeanRemote;

public class MoviesEJBClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Properties jndiProps = new Properties();
			jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			jndiProps.put(Context.PROVIDER_URL, "t3://localhost:7001");
			
			Context ctx = new InitialContext(jndiProps);
			
			String jndiName = "movies#sample.ejb.stateless.MovieEJBBeanRemote";
			Object objRef = ctx.lookup(jndiName);
			
			MovieEJBBeanRemote remote = (MovieEJBBeanRemote)objRef;
			remote.addMovie(new Movie(new MoviePk("M04","Heatd"),"Action",2002));
			System.out.println("Added Movie");
			
			remote.removeMovie(new Movie(new MoviePk("M03","NoteBook"), "Romance", 2003));
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
