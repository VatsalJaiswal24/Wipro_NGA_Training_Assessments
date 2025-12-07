<!doctype html>
<html>
<head><meta charset="UTF-8"/><title>Add Contact</title></head>
<body style="font-family:Arial; margin:30px;">
<h2>Add Contact</h2>
<form action="contact" method="post">
    <input type="hidden" name="action" value="add"/>
    Name:<br/><input type="text" name="name" required/><br/><br/>
    Phone:<br/><input type="text" name="phone" required/><br/><br/>
    Email:<br/><input type="email" name="email" required/><br/><br/>
    <button type="submit">Save</button>
</form>
<br/>
<a href="contact?action=list">Back</a>
<jsp:include page="footer.jsp"/>
</body>
</html>
