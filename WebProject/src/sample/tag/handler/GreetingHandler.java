package sample.tag.handler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class GreetingHandler extends TagSupport {
	

	private static final long serialVersionUID = 1L;
	private String name,message;
	
	public int doStartTag()throws JspException
	   {
		 
		   return EVAL_BODY_INCLUDE;
	   }
	public int doEndTag()throws JspException
	{
		JspWriter out = pageContext.getOut();

		try {
			out.println(message +" "+ name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



}
