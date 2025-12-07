<%@ page import="java.util.*, com.vatsal.model.Contact" %>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Contact Manager</title>
    <style>
      body { font-family: Arial, sans-serif; margin: 30px; }
      table { border-collapse: collapse; width: 100%; max-width:900px; }
      th, td { border:1px solid #ddd; padding:8px; text-align:left; }
      th { background:#f4f4f4; }
      a.button { background:#1976d2; color:white; padding:6px 10px; text-decoration:none; border-radius:4px; }
    </style>
</head>
<body>
<h2>Contact List</h2>
<a class="button" href="add.jsp">+ Add New Contact</a>
<br/><br/>
<table>
    <tr><th>ID</th><th>Name</th><th>Phone</th><th>Email</th><th>Actions</th></tr>
    <%
        List<Contact> list = (List<Contact>) request.getAttribute("contacts");
        if (list != null) {
            for (Contact c : list) {
    %>
    <tr>
        <td><%= c.getId() %></td>
        <td><%= c.getName() %></td>
        <td><%= c.getPhone() %></td>
        <td><%= c.getEmail() %></td>
        <td>
            <a href="contact?action=edit&id=<%=c.getId()%>">Edit</a> |
            <a href="contact?action=delete&id=<%=c.getId()%>" onclick="return confirm('Delete this contact?');">Delete</a>
        </td>
    </tr>
    <%      }
        } else { %>
    <tr><td colspan="5">No contacts found.</td></tr>
    <% } %>
</table>

<br/>
<jsp:include page="footer.jsp"/>
</body>
</html>
