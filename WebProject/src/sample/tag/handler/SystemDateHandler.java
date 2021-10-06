package sample.tag.handler;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class SystemDateHandler extends TagSupport {

	private static final long serialVersionUID = 1L;

public int doStartTag()throws JspException
   {
	 
	   return EVAL_BODY_INCLUDE;
   }
public int doEndTag()throws JspException
{
	JspWriter out = pageContext.getOut();
	LocalDate currentDate = LocalDate.now();
	try {
		out.println(currentDate);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return EVAL_PAGE;
}

}
