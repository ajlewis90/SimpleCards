<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    try{
    	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    	String dbURL = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=JoinsTutorial";
    	String dbUserName = "sa";
    	String dbPassword = "Cellfone01";
        Class.forName(driver);
        Connection con =(Connection) DriverManager.getConnection(dbURL, dbUserName, dbPassword);
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Card WHERE " 
                    + "card_Number = ?");
            ps.setString(1,request.getParameter("cardNumber"));
            ResultSet res = ps.executeQuery();
            if(res.first()){
                out.print("This card number already exists");
            }else{
                out.print("This card number is valid");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
%>