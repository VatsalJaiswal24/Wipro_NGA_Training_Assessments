<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Add Contact</title>
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
    <a href="contacts?action=add" class="active">Add Contact</a>
    <a href="contacts?action=list">View Contacts</a>
  </nav>
</header>

<main class="container">
  <h2>Add Contact</h2>
  <form action="contacts?action=add" method="post" class="form-card">
    <label>Name*</label>
    <input type="text" name="name" required>
    <label>Phone</label>
    <input type="text" name="phone">
    <label>Email</label>
    <input type="email" name="email">
    <button type="submit" class="btn">Add Contact</button>
  </form>
</main>

<footer><p>Created by Vatsal Jaiswal</p></footer>
</body>
</html>
