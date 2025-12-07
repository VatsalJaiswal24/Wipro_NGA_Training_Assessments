<%@ page import="com.vatsal.model.Contact" %>
<%
    Contact c = (Contact) request.getAttribute("contact");
    if (c == null) {
        response.sendRedirect("contact?action=list");
        return;
    }
%>
<!doctype html>
<html>
<head><meta charset="UTF-8"/><title>Edit Contact</title></head>
<body style="font-family:Arial; margin:30px;">
<h2>Edit Contact</h2>
<form action="contact" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="<%=c.getId()%>"/>
    Name:<br/><input type="text" name="name" value="<%=c.getName()%>" required/><br/><br/>
    Phone:<br/><input type="text" name="phone" value="<%=c.getPhone()%>" required/><br/><br/>
    Email:<br/><input type="email" name="email" value="<%=c.getEmail()%>" required/><br/><br/>
    <button type="submit">Update</button>
</form>
<br/>
<a href="contact?action=list">Back</a>
<jsp:include page="footer.jsp"/>
</body>
</html>
