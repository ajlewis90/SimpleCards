<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.joel.cards.model.Card"%>
<%@page import="org.joel.cards.services.CardService"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <title>View All Card Information</title>
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
					<th>Card Status</th>
				</tr>
			</thead>
			<tbody>
        	<%
            //int id = Integer.parseInt(request.getParameter("updateId"));
            	CardService cs = new CardService();
            	List<Card> cardList = cs.getAllCards();
            	String cardStatusDescription = null;
            	int cardStatusOID = 0;
            	int serialNumber =0;
            	for (Card card : cardList) {
            		cardStatusOID = card.getCard_status_oid();
            		String cardStatusDesc = cs.mapCardStatusOIDToDescription(cardStatusOID);
       		 %>
       		 <tr>
       		 		<td><%=++serialNumber%>
					<td><%=String.valueOf(card.getCard_number())%></td>
					<td><%=card.getCard_owner_name()%></td>
					<td><%=cardStatusDesc%></td>
					<td style="border: none;">
						<div>
							<form method="post" action="updateCardStatus.jsp">
								<input type="hidden" id="cardNumber" name="cardNumber" 
									value="<%=String.valueOf(card.getCard_number())%>" />
								<input type="hidden" id="oldCardStatus" name="oldCardStatus" 
									value="<%=String.valueOf(card.getCard_status_oid())%>" />  
								<input type="submit" value="Update Status" />
							</form>
						</div>
					</td>
			</tr>
			<%
                        }
                    %>
			</tbody>
		</table>
	</div>

</body>
</html>