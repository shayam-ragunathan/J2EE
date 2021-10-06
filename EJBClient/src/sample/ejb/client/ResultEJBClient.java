package sample.ejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import sample.ejb.stateful.ResultBeanRemote;

public class ResultEJBClient {

	public ResultEJBClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws InterruptedException {
		try {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		Context context;

			context = new InitialContext(jndiProperties);
		String jndiName="result#sample.ejb.stateful.ResultBeanRemote";
		Object obj = context.lookup(jndiName);
		System.out.println("Lookup is Successful");
		ResultBeanRemote resultBeanRemote =(ResultBeanRemote) obj;
		resultBeanRemote.setData("Shyam Ragunathan", 57, 97, 100);
		System.out.println("Data Set");
		resultBeanRemote.calculateTotal();
		//Thread.sleep(500000);
		System.out.println("Total calculated Successful");
		resultBeanRemote.calculatePersentage();
		
		System.out.println("Result: "+resultBeanRemote.getResult());
		
		resultBeanRemote.delete();
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
