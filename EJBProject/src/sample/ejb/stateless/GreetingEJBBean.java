package sample.ejb.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class GreetingEJBBean
 */
@Stateless(mappedName = "greeting")
@LocalBean
public class GreetingEJBBean {

    /**
     * Default constructor. 
     */
    public GreetingEJBBean() {
        // TODO Auto-generated constructor stub
    	
    }
    public String sayGreeting(String name)
    {
    	return "Greetings "+name+" by local bean";
    }
    
	@PostConstruct
	public void start()
	{
		System.out.println("GreetingEJBBean got Created");
	}
	
	@PreDestroy
	public void end()
	{
		System.out.println("GreetingEJBBean got Destroyed");
	}

}
