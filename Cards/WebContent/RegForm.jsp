<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript">
function checkExist(){
    var xmlhttp = new XMLHttpRequest();
    var username = document.forms["regF"]["username"].value;
    var url = "exists.jsp?card_owner_name=" + username;
    xmlhttp.onreadystatechange = function(){
        if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
            if(xmlhttp.responseText == "\n\n\n\n\nUser already exists")
                document.getElementById("isE").style.color = "red";
            else
                document.getElementById("isE").style.color = "green";
            document.getElementById("isE").innerHTML = xmlhttp.responseText;
        }
        
    };
    try{
    xmlhttp.open("GET",url,true);
    xmlhttp.send();
}catch(e){alert("unable to connect to server");
}
</script>
<title>Register</title>
</head>
<body>
	<form action="RegForm.jsp" onsubmit="return validateForm()" method="post"  name="regF">
                Enter your username:<input type="text" name="username" onblur="checkExist()"/><span id="isE"></span><br><br>
                Enter your email:<input type="email" name="email"/><br><br>
                Enter your password:<input type="password" name="password"/><br><br>
                Confirm your password:<input type="password" name="cpassword"/><br><br>
                <input type="submit" value="Register" /><br>
            </form>
</body>
</html>