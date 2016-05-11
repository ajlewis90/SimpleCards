<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.joel.cards.model.CardStatusDescription"%>
<%@page import="org.joel.cards.services.CardService"%>
<%@page import="org.joel.cards.model.Card"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="style.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
        	function checkIfCardStatusChanged()
        	{
        		var oldCardStatus = document.getElementById("oldCardStatus").value;
                var newCardStatus = document.getElementById("newCardStatus").value;
                var changed = true;	
                
                if(oldCardStatus == newCardStatus){
        			changed = false;
        			alert("Please ensure that the new card status is different from old card status!");        			
        		}
        		
        		else{
        			changed = true;
        		}
                return changed;
        	}
        </script>
        <title>Update Card Status</title>
    </head>
    <body>
    	
        <%@include file="home.jsp"%>
        <%
        	int cardNumber = Integer.parseInt(request.getParameter("cardNumber"));
        	
        	CardService cs = new CardService();
       		Card card = cs.getCardNumber(cardNumber);
       		int oldCardStatusOID = card.getCard_status_oid();
       		String oldCardStatusDescription = cs.mapCardStatusOIDToDescription(oldCardStatusOID);
       		List<CardStatusDescription> csdList = cs.getCardStatusDescription();
        %>
    	
        <form method="post" action="UpdateCardStatus" onsubmit="return checkIfCardStatusChanged();">
            <div id="mystyle" class="myform">
               
                    <h1>Card Number number <%=card.getCard_number()%></h1>
                    <p>
						Update the card status information for card number:<%=card.getCard_number()%></p>
                    <label>Card Number<span class="small">Card Number</span></label>
                    <input type="text" name="cardNumber" id="cardNumber" readonly="readonly" value="<%=card.getCard_number()%>"/>
                    <label>Card Owner Name<span class="small">Card Owner's Name</span></label>
                    <input type="text" name="cardOwnerName" id="cardOwnerName" readonly="readonly" value="<%=card.getCard_owner_name()%>"/>
                    <input type ="hidden" name="oldCardStatus" id="oldCardStatus" value="<%=oldCardStatusDescription%>"/>
                    <label>Card Status <span class="small">Update Card Status</span></label>
                    <select name="newCardStatus" id="newCardStatus" size="1">
        				<%for (CardStatusDescription csd : csdList) {
        					System.out.println(csd.getCard_status_description());
        				%> 
        				<option><%=String.valueOf(csd.getCard_status_description())%></option>
        				<%
                        	}
                    	%>
       	 			</select>
       	 			                          
                    <button type="submit">Update Card Status</button>
                    <div class="spacer"></div>
              
            </div>
        </form>    
    </body>
</html>