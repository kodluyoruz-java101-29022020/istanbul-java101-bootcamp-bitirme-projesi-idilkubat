<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kodluyoruz Java Bootcamp</title>
</head>
<body>
 <div align="center">
  <h1>Book Form</h1>
  <form action="<%= request.getContextPath() %>/register" method="post">
   <table style="with: 80%">
    <tr>
     <td>Book Name</td>
     <td><input type="text" name="bookName" /></td>
    </tr>
    <tr>
     <td>Author Name</td>
     <td><input type="text" name="authorName" /></td>
    </tr>
    <tr>
     <td>Publication Year</td>
     <td><input type="date" name="publicationYear" /></td>
    </tr>
     <tr>
     <td>Book Explanation</td>
     <td><input type="text" name="bookExplanation" /></td>
    </tr>
    <tr>
     <td>Book Notes</td>
     <td><input type="text" name="bookNote" /></td>
    </tr>
    
   </table>
   <input type="submit" value="Save" />
  </form>
 </div>
</body>
</html>