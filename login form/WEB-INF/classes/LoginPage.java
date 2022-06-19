package com.first.mypro;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.*;


public class LoginPage extends HttpServlet
{


public void doPost(HttpServletRequest req , HttpServletResponse res)throws IOException ,ServletException
{

res.setContentType("text/html");
PrintWriter pw = res.getWriter();

 Connection con=null;
 Statement stmt=null;

                String user = req.getParameter("username");
		String pass= req.getParameter("pasword");
		
		pw.print("<h1> Your name is: "+user+"</h1>");
		pw.print("<h1> Your password is: "+pass+"</h1>");
	
   try{

   Class.forName("oracle.jdbc.driver.OracleDriver");
   }
   catch(ClassNotFoundException notfound)

		{
			pw.print("<h2>Sorry, some class issue problem </h2>");
		}
		try
		{
      con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","sara");
        }
		catch(SQLException exp)
		{
			pw.print("<h2>Sorry, some internal problem </h2>");
		}
  if(con != null)
{
	 try{

				String query = "insert into login1 values ('"+user+"','"+pass+"')";
				stmt = con.createStatement();
				int result = stmt.executeUpdate(query);

                if(result != 0)
				{
					pw.print("<h2>Data inserted successfully.... </h2>");
					
				}
				else
				{
				pw.print("<h2>Sorry,data not inserted....... </h2>");

				}
        }

catch(SQLException sqlexp)
{
	pw.print("<h2>Sorry, some statement internal problem </h2>");
	
}
}
else
	{
		    pw.print("<h2>Sorry, some problem in connection  </h2>");
		
	}

			}
			
		}
		
		


