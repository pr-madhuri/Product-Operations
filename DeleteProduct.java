package ProductOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/deleteProductData")
public class DeleteProduct extends HttpServlet{
 
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
	 
	 protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	 {
		 PreparedStatement pstmt;
		 String pId=req.getParameter("pid");
		 int id=Integer.parseInt(pId);
		 String query="delete from product1 where product_id=?";
		 try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, id);
			int count=pstmt.executeUpdate();
			
			PrintWriter pw=resp.getWriter();
			if(count>0)
			{
				
				pw.print("<h1 style='color:green'>"+count+" DATA DELETED SUCCESSFULLY</h1>");
			}
			else
			{
				pw.print("<h1 style='color:red'>DATA NOT DELETED</h1>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 
	 }
	
}
