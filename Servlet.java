package abcd;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
/**
 * Servlet implementation class Servlet3
 */
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int a=Integer.parseInt(request.getParameter("t1"));
		Connection con;
		PreparedStatement ps;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/p","root","Pratik@2207");
		    ps=con.prepareStatement("select * from regi where id=?");
		    ps.setInt(1, a);
		    pw.println("<table width=75% border=1>");
		    
		    ResultSet rs=ps.executeQuery();
		    
		    while(rs.next())
		    {
		      String b,c,d,e;
		      b=rs.getString("first");
		      c=rs.getString("Last");
		      d=rs.getString("age");
		      e=rs.getString("addr");
		      pw.print("<caption> Information :</caption>");
		      pw.println("id First Last  age  addr \n");
		      pw.println("<br>"+a+" "+b+" "+c+" "+d+" "+e);
		    }
		    
		}
		catch(Exception e) {
		pw.println("Connection not Successful");
		e.printStackTrace();
		}
	}

}
