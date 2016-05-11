<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
    	//int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
    	String cardNumber = request.getParameter("ver");
    	System.out.println("cardnumber is: " + cardNumber);
    	int cno = Integer.parseInt(cardNumber);
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");    
        Connection con =(Connection) DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JoinsTutorial", "sa", "Cellfone01");
        Statement st=con.createStatement();
        String query = "select * from card where card_number = " + cno;
        ResultSet rs = st.executeQuery(query);  // this is for ncard number
        System.out.println(query);
        
        		 if(rs.next())
                 {    
                     out.println("<font color=red>");
                     out.println("Card Number unavailable");
                     out.println("</font>");

                 }else {

                     out.println("<font color=green>");
                     out.println("Card Number Available");
                     out.println("</font>");

                 }

	rs.close();
	st.close();
	con.close();
        }catch (Exception e){
            System.out.println(e);  
        }
%>