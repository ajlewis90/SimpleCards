<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.joel.cards.model.Card"%>
<%@page import="org.joel.cards.services.CardService"%>
<%@page import="org.joel.cards.model.CardStatusHistory"%>
<%@page import="org.joel.cards.model.CardStatusDescription"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>View All Card Status History Information</title>
    </head>
    <body>
    	
        <%@include file="home.jsp"%>
        <div>
		<table align="center">
			<thead>
				<tr>
					<th>Serial Number</th>
					<th>Card Number</th>
					<th>Card Owner Name</th>
					<th>Old Card Status</th>
					<th>New Card Status</th>
					<th>Date Updated</th>
				</tr>
			</thead>
			<tbody>
        	<%
            //int id = Integer.parseInt(request.getParameter("updateId"));
            	CardService cs = new CardService();
            	int serialNumber = 0;
            	List<CardStatusHistory> cshList = cs.getAllCardStatusHistory();
            	String cardOwnerName, oldCardStatusDescription, newCardStatusDescription = null;
            	int cshOID, cardOID, oldCardStatusOID, newCardStatusOID, cardNumber = 0;
            	Date dateUpdated = null;
            	for (CardStatusHistory csh : cshList) {
            		cshOID = csh.getCsh_oid();
            		cardOID = csh.getCard_oid();
            		cardNumber = cs.mapCardOIDToNumber(cardOID);
            		cardOwnerName = cs.mapCardOIDToOwner(cardOID);
            		oldCardStatusOID = csh.getOld_card_status_oid();
            		newCardStatusOID = csh.getNew_card_status_oid();
            		oldCardStatusDescription = cs.mapCardStatusOIDToDescription(oldCardStatusOID);
            		newCardStatusDescription = cs.mapCardStatusOIDToDescription(newCardStatusOID);
            		dateUpdated = csh.getDate_changed();
       		 %>
       		 <tr>
       		 		<td><%=++serialNumber%></td>
					<td><%=cardNumber%></td>
					<td><%=cardOwnerName%></td>
					<td><%=oldCardStatusDescription%></td>
					<td><%=newCardStatusDescription%></td>
					<td><%=dateUpdated%></td>
			
			</tr>
			<%
                        }
                    %>
			</tbody>
		</table>
	</div>

</body>
</html>