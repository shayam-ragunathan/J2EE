package sample.ejb.stateless;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless(mappedName = "hello")
public class HelloBean implements HelloBeanRemote, HelloBeanLocal {

    /**
     * Default constructor. 
     */
	@EJB//Instantiation is happening by container
	private GreetingEJBBean greetingEJBBean;
    public HelloBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		//return "Hello "+ name +" By Remote EJB";
		return greetingEJBBean.sayGreeting(name);
	}

	@Override
	public String sayWelcome(String name) {
		// TODO Auto-generated method stub
		return "Welcome "+ name+" By Local EJB";
	}
	
	@PostConstruct
	public void start()
	{
		System.out.println("HelloBean got Created");
	}
	
	@PreDestroy
	public void end()
	{
		System.out.println("HelloBean got Destroyed");
	}
	
    

}
