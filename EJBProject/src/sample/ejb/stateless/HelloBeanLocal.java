package sample.ejb.stateless;

import javax.ejb.Local;

@Local
public interface HelloBeanLocal {
	String sayWelcome(String name);

}
