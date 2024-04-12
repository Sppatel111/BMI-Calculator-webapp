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
                out.println("<meta name=viewport content=width=device-width, initial-scale=1>");
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
                    category="are Under Weight";
                }
                else if(bmi >16 && bmi < 25)
                {
                    category="have Normal Weight";
                }
                else if(bmi >25 && bmi < 30)
                {
                    category="are Over Weight";
                }
                else
                {
                    category="have Obesity";
                }
		response.setContentType("text/html");
		
		out.println("<h2 class = header > Welcome: " + name + "</h2>");
                
                out.println("<div class='container'>");
                out.println("<div class='form-container'>");
                    out.println("<div class = result-container> Your BMI:"+bmi + "</div >");
                    out.println("<div class = result-container> You "+category+ "</div>");
                out.println("</div>");
                out.println("</div>");
                
                out.println("<div class=footer>");
                out.println("&copy; 2023 BMI Calculator");
                out.println("</div>");
                
                out.println("</body>");
                out.println("</html>");
        }
   
    
}