<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*,com.contact.Contact" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Contact List</title>
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
<header class="topbar">
  <div class="brand">
    <img src="https://cdn-icons-png.flaticon.com/512/3096/3096673.png" alt="Logo">
    <h1>Contact Manager</h1>
  </div>
  <nav>
    <a href="index.jsp">Home</a>
    <a href="contacts?action=add">Add Contact</a>
    <a href="contacts?action=list" class="active">View Contacts</a>
  </nav>
</header>

<main class="container">
  <h2>All Contacts</h2>
  <%
    @SuppressWarnings("unchecked")
    List<Contact> contacts = (List<Contact>) application.getAttribute("contacts");
    if (contacts == null || contacts.isEmpty()) {
  %>
    <p>No contacts yet.</p>
  <%
    } else {
  %>
    <table class="contacts-table">
      <tr><th>#</th><th>Name</th><th>Phone</th><th>Email</th></tr>
      <%
        int i=1;
        synchronized(contacts){
          for(Contact c:contacts){
      %>
      <tr>
        <td><%=i++%></td>
        <td><%=c.getName()%></td>
        <td><%=c.getPhone()%></td>
        <td><%=c.getEmail()%></td>
      </tr>
      <% } } %>
    </table>
  <% } %>
</main>

<footer><p>Created by Vatsal Jaiswal</p></footer>
</body>
</html>
