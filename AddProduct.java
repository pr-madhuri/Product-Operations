package ProductOperations;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/addProductData")


public class AddProduct extends HttpServlet {
	Connection con;
	public void init()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/1eja9","root","madhuri123");
		} catch (ClassNotFoundException e) {
					e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws IOException
	{
		String pname=req.getParameter("pname");
		 String pcategory=req.getParameter("pcategory");
		 double price=Double.parseDouble(req.getParameter("pprice"));
		 int qty=Integer.parseInt(req.getParameter("pqty"));
		 
		 PreparedStatement pstmt;
		 String query="insert into product1 values(?,?,?,?,?)";
		 try {
			pstmt=con.prepareStatement(query);
			pstmt.setInt(1, 0);
			pstmt.setString(2, pname);
			pstmt.setDouble(3,price);
			pstmt.setString(4, pcategory);
			pstmt.setInt(5, qty);
			int count=pstmt.executeUpdate();
			PrintWriter pw=resp.getWriter();
			if(count>0)
			{
				pw.print("<h1 style='color:green'>"+count+" Data Added </h1>");
			}
			else
			{
				pw.print("<h1 style='color:red'> Data not added </h1>");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
  
}
