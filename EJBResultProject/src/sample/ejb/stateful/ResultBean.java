package sample.ejb.stateful;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 * Session Bean implementation class ResultBean
 */
@Stateful(mappedName = "result")
public class ResultBean implements ResultBeanRemote {

    /**
     * Default constructor. 
     */
	private String name;
	private int mark1,mark2,mark3;
	private int totalMarks;
	private float persentage;

	public ResultBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void setData(String name, int mark1, int mark2, int mark3) {
		this.name = name;
		this.mark1 = mark1;
		this.mark2 = mark2;
		this.mark3 = mark3;
	}

	@Override
	public void calculateTotal() {
		// TODO Auto-generated method stub
		totalMarks = mark1+mark2+mark3;
		
	}

	@Override
	public void calculatePersentage() {
		persentage = totalMarks/3.0f;
		
	}

	@Override
	public String getResult() {
		// TODO Auto-generated method stub
		return "Name: "+name+" Total: "+totalMarks+" Persentage: "+persentage;
	}

	@Override
	@Remove
	public void delete() {
		// TODO Auto-generated method stub
		System.out.println("ResultBean EJB is deleted");
		
	}
	@PostConstruct
	public void start()
	{
		System.out.println("ResultBean EJB is Initialized");
	}
	
	@PreDestroy
	public void drop()
	{
		System.out.println("ResultBean EJB is destroyed");
	}
	
	@PrePassivate
	public void doPassivate()
	{
		System.out.println("ResultBean EJB is Passivated");
	}
    @PostActivate
	public void donePassivate()
	{
    	System.out.println("ResultBean EJB is Activated");
	}
}
