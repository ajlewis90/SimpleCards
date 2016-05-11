<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="org.joel.cards.model.CardStatusDescription"%>
<%@page import="org.joel.cards.services.CardService"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="style.css" rel="stylesheet" type="text/css" />
<title>New Card</title>
<script type="text/javascript" src="js/jquery-1.12.0.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript">
	function loadXMLDoc() {
		var xmlhttp;
		var k = document.getElementById("cardNumber").value;
		var urls = "exists.jsp?ver=" + k;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange = function() {
			if (xmlhttp.readyState == 4) {
				//document.getElementById("err").style.color="red";
				document.getElementById("err").innerHTML = xmlhttp.responseText;

			}
		}
		xmlhttp.open("GET", urls, true);
		xmlhttp.send();
	}

	function onValidate() {

		var cOwnerName = document.getElementById("cardOwnerName").value;
		var cardNumber = document.getElementById("cardNumber").value;
		var cardOwnerTrimmed = cOwnerName.trim();
		var result = true;

		if (cardOwnerTrimmed.length == 0 || !(isNaN(cardOwnerTrimmed))) {
			result = false;
			alert("Please ensure card owner's name is properly filled");
		}

		else if (isNaN(intFloat(cardNumber))) {
			result = false;
			alert("Please ensure card number contains decimal digits");
		}

		else {
			result = true;
		}

		return result;
	}
</script>
</head>
<body>

	
</script>
</head>
<body>

	<%@include file="home.jsp"%>
	<%
            //int id = Integer.parseInt(request.getParameter("updateId"));
            CardService cs = new CardService();
            List<CardStatusDescription> csdList = cs.getCardStatusDescription();
            System.out.println("size of csd list: " + csdList.size());
        %>

		<form method="post" action="AddNewCard" onSubmit="return onValidate()">
		<div id="mystyle" class="myform">

			<h1>Add a new Card</h1>
			<p>To add new Card enter following information</p>
					<label>Card Number<span class="small" id="err">Enter Card Number</span></label><input type="text" name="cardNumber" id="cardNumber" onkeyup="loadXMLDoc()">
					<label>Card Owner Name<span class="small">Enter Card Owner's Name</span></label>
                    <input type="text" name="cardOwnerName" id="cardOwnerName" />
                    <label>Card Status <span class="small">Enter Card Status</span></label>
                    <select name="cardStatus" id="cardStatus" size="1">
        				<%for (CardStatusDescription csd : csdList) {
        					System.out.println(csd.getCard_status_description());
        				%> 
        				<option><%=String.valueOf(csd.getCard_status_description())%></option>
        				<%
        				
                        }
                    	%>
       	 			</select>
       	 			                            
                    <button type="submit">Add New Card</button>
                    <div class="spacer"></div>

		</div>
		</form>
</body>
</html>