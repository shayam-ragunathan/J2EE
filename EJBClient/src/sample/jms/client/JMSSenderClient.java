package sample.jms.client;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueReceiver;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;




public class JMSSenderClient {

	public JMSSenderClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws NamingException, JMSException {
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "t3://localhost:7001");
		
		Context context = new InitialContext(jndiProperties);
		String jndiName1 = "jms/ConnectionFactory";
		
		
		Object obj = context.lookup(jndiName1);
		QueueConnectionFactory factory = (QueueConnectionFactory) obj;
		QueueConnection queueConnection = factory.createQueueConnection();
		
		String jndiName2="jms/Queue";
		Object obj2 = context.lookup(jndiName2);
		Queue queue = (Queue) obj2;		
		QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);//using Qconnection
		
		
		
		TextMessage textMessage= queueSession.createTextMessage(); //creating text message
		textMessage.setText("Happy Birthday");
		
		QueueSender queueSender = queueSession.createSender(queue);//Creating Sender
		queueSender.send(textMessage);
		System.out.println("Message Sent");
		
		//QueueReceiver queueReceiver = queueSession.createReceiver(queue);
		//MessageConsumer messageConsumer = (MessageConsumer) queueReceiver.receive();
		//System.out.println("Message Received "+messageConsumer.toString());
		queueConnection.close();
		
		

	}

}
