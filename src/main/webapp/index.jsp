<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>


<h1> Her kan du logge ind som eksisterende bruger</h1>


<form action="ServletLogin">
    <label >Skriv navn:</label><br>
    <input type="text"  name="navn" value="Valborg"><br>
    <label>angiv kode:</label><br>
    <input type="text"  name="kode" value="1234"><br><br>
    <input type="submit" value="Opret">
</form>




<h1> her kan du oprettet dig</h1>


<form action="ServletOpret">
    <label >Skriv navn:</label><br>
    <input type="text"  name="navn" value="Valborg"><br>
    <label>angiv kode:</label><br>
    <input type="text"  name="kode" value="1234"><br><br>
    <input type="submit" value="Opret">
</form>


</body>
</html>