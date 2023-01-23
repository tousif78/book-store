<%@page import="com.js.dto.Book"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1 align="center">List Of Books</h1>
  <table align="center" border="2px solid black">
  <tr>
  <th>Book_ID</th>
  <th>Book_Name</th>
  <th>Author_Name</th>
  <th>No_Of_Pages</th>
  <th>Price</th>
  <th>DELETE</th>	
  </tr>
  <% ArrayList<Book> books= (ArrayList)request.getAttribute("data"); 
  for(Book b : books){
  %>
  <tr>
  <td><%=b.getBook_ID() %></td>
  <td><%=b.getBook_Name() %></td>
  <td><%=b.getAuthor_Name() %></td>
  <td><%=b.getNumberOfPages() %></td>
  <td><%=b.getPrice() %></td>
  <td><a href="delete?id=<%=b.getBook_ID()%>">delete</a></td>
  
  </tr>
  <%} %>
  </table>
  <a text align="center" href="welcome.html">Click here to homepage</a>

</body>
</html>