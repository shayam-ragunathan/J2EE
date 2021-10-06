package sample.ejb.stateless;

import javax.ejb.Remote;

@Remote
public interface HelloBeanRemote {
	
	String sayHello(String name);

}
