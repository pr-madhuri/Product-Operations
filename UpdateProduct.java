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
@WebServlet("/updateProductData")
public class UpdateProduct extends HttpServlet {
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
	   String pName="",pCategory="",pPrice="",pQty="",pId="";
	   pId=req.getParameter("pid");
	   pName=req.getParameter("pname");
	   pCategory=req.getParameter("pcategory");
	   pPrice=req.getParameter("pprice");
	   pQty=req.getParameter("pqty");
	   PreparedStatement pstmt=null;
	   int pid=Integer.parseInt(pId);
	   PrintWriter pw=resp.getWriter();
	   if(!pName.isEmpty())
	   {
		   String query="update product1 set product_name=? where product_id=?";
		   try {
			pstmt=con.prepareStatement(query);
			 pstmt.setString(1, pName);
			  pstmt.setInt(2,pid );
			 int count= pstmt.executeUpdate();
			
			 if(count>0)
			 {
				 
				 pw.print("<h1>"+count+ " Data Updated</h1>");
			 }
			 else
			 {
				 pw.print("<h1> Data not updated</h1>");
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		  
	   }
	   else if(!pCategory.isEmpty())
	   {
		   String query="update product1 set product_category=? where product_id=?";
		   try {
			pstmt=con.prepareStatement(query);
			 pstmt.setString(1, pCategory);
			  pstmt.setInt(2,pid );
			 int count= pstmt.executeUpdate();
			
			 if(count>0)
			 {
				 
				 pw.print("<h1>"+count+ " Data Updated</h1>");
			 }
			 else
			 {
				 pw.print("<h1> Data not updated</h1>");
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   }
	   else if(!pPrice.isEmpty())
	   {
		   String query="update product1 set product_price=? where product_id=?";
		   try {
			pstmt=con.prepareStatement(query);
			double price=Double.parseDouble(pPrice);
			 pstmt.setDouble(1, price);
			  pstmt.setInt(2,pid );
			 int count= pstmt.executeUpdate();
			
			 if(count>0)
			 {
				 
				 pw.print("<h1 style='color:red'>"+count+ " Data Updated</h1>");
			 }
			 else
			 {
				 pw.print("<h1> Data not updated</h1>");
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   }
	   else if(!pQty.isEmpty())
	   {
		   String query="update product1 set product_qty=? where product_id=?";
		   try {
			pstmt=con.prepareStatement(query);
			int qty=Integer.parseInt(pQty);
			 pstmt.setDouble(1, qty);
			  pstmt.setInt(2,pid );
			 int count= pstmt.executeUpdate();
			 if(count>0)
			 {
				 
				 pw.print("<h1 style='color:green'>"+count+ " Data Updated</h1>");
			 }
			 else
			 {
				 pw.print("<h1 style='color:red'> Data not updated</h1>");
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	   }
	   
   }
}
