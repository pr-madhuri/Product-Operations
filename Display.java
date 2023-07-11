package ProductOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/displayData")
public class Display extends HttpServlet{
     
	  
		   Connection con;
		   
		   public void init()
		   {
			   try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","madhuri123");
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		   }
		   
		   protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
		   {
			   Statement stmt=null;
			   ResultSet rs=null;
			   
			   String query="select * from product1";
			   try {
				stmt=con.createStatement();
				rs=stmt.executeQuery(query);
				PrintWriter pw=resp.getWriter();
				pw.print("<table border='1'><tr><th>product_id</th> <th>product_name</th>  <th>product_price</th> <th>product_category</th> <th>product_qty</th></tr>");
				while(rs.next())
				{
					pw.print("<tr align='center'>");
					pw.print("<td>" +rs.getInt(1)+"</td>");
					pw.print("<td>"+rs.getString(2)+"</td>");
					pw.print("<td>"+rs.getDouble(3)+"</td>");
					pw.print("<td>"+rs.getString(4)+"</td>");
					pw.print("<td>"+rs.getInt(5)+"</td>");
					pw.print("</tr>");
				}
				pw.print("</table>");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			   
		   }
}
