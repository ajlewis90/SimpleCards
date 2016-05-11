<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Date"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <div id="mystyle" style="border: none;">
            <h1>Cards Application</h1>
            <p><b>Home</b><br/>
                <%=new Date()%></br>  </br>
                <a href="addNewCard.jsp">Add New Card</a> &NegativeThickSpace; |
                <a href="viewAllCards.jsp">View All Cards</a> &NegativeThickSpace; 
                <a href="viewCardStatusHistory.jsp">View All Card Status History</a>
                <a href="viewCardStatusHistory.jsp">View Active Cards</a>
                <a href="viewCardStatusHistory.jsp">View Inactive Cards</a>
                <a href="viewCardStatusHistory.jsp">View Suspended Cards</a>
                <a href="viewCardStatusHistory.jsp">View Expired Cards</a>
            </p>
        </div>
    </center>
</body>
</html>