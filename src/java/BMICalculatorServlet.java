import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;


@WebServlet("/BMICalculatorServlet")
public class BMICalculatorServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
            
		PrintWriter out = response.getWriter();
                
                out.println("<html>");
                out.println("<head>");
                out.println("<title> BMI Calculator </title>");
                out.println(" <link rel=stylesheet href=newcss.css> ");
                out.println("</head>");   
                out.println("<body>");
                
		String name = request.getParameter("name");
                float height = Float.parseFloat(request.getParameter("height"));
                int age = Integer.parseInt(request.getParameter("age"));
                float weight= Float.parseFloat(request.getParameter("weight"));
                 height/=100;
                float  bmi= weight/(height*height);
                String category;
                
                
                if(bmi<16)
                {
                    category="underweight";
                }
                else if(bmi >16 && bmi < 25)
                {
                    category="normalweight";
                }
                else if(bmi >25 && bmi < 30)
                {
                    category="overweight";
                }
                else
                {
                    category="obesity";
                }
		response.setContentType("text/html");
		
		out.println("<h2 class = header > Your name is: " + name + "</h2>");
                out.println(" < link rel="stylesheet" href="newcss.css" >");
                
                out.println("user bmi:"+bmi);
                out.println("<p>category:"+category+"</p>");
                out.println("</body>");
                out.println("</html>");
        }
   
    
}