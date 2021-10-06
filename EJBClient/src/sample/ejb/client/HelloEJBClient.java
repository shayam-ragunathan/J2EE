package sample.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import sample.ejb.stateless.HelloBeanRemote;

public class HelloEJBClient extends Thread{

	public HelloEJBClient() {
		// TODO Auto-generated constructor stub
		
	}
	
	public void run()
	{
		try{
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
			jndiProperties.put(Context.PROVIDER_URL, "t3://localhost:7001");
			
			Context context = new InitialContext(jndiProperties);
			String jndiName="movies#sample.ejb.stateless.MovieEJBBeanRemote";
			Object obj = context.lookup(jndiName);
			System.out.println("Lookup is Successful");
			
			HelloBeanRemote helloBeanRemote =(HelloBeanRemote) obj;
			System.out.println(
	                "Thread " + Thread.currentThread().getId()
	                + " is running");
			if (Thread.currentThread().getId() ==12)
			sleep(5000);
			System.out.println("Message from Remote EJB: " +helloBeanRemote.sayHello("Shyam"));
			System.out.println("Class Name of  helloBeanRemote: " +helloBeanRemote.getClass().getName());
			if (Thread.currentThread().getId() ==12)
				sleep(5000);
			System.out.println("Thread " + Thread.currentThread().getId()+ " is exiting");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}			

		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=0 ;i<1;i++)
		{
		Thread t1 = new HelloEJBClient();
		t1.start();
		}
		//subMain();
		

}
}
