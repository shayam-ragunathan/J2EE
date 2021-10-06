package sample.listeners;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import sample.beans.DataStore;

/**
 * Application Lifecycle Listener implementation class ApplicationListener
 *
 */
public class ApplicationListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ApplicationListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
    	System.out.println("WebProject Stopped by Shyam");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	System.out.println("WebProject Started by Shyam");
    	DataStore dataStore = new DataStore();
    	List<String> electronics=Arrays.asList("Mobile","PlayStation","TV","Sound System");
    	dataStore.setContents(electronics);
    	ServletContext scx=arg0.getServletContext();
    	scx.setAttribute("electronics", dataStore);
    }
	
}
