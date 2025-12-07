document.getElementById("fetchEmployees").addEventListener("click", () => {
  fetch("https://dummy.restapiexample.com/api/v1/employees")
    .then(response => response.json())
    .then(data => {
      console.log("Employee Data:", data);
      alert("Employee data has been logged to the console!");
    })
    .catch(error => console.error("Error fetching employee data:", error));
});
document.getElementById("fetchUser").addEventListener("click", () => {
  fetch("https://randomuser.me/api/")
    .then(response => response.json())
    .then(data => {
      const user = data.results[0];
      const userDiv = document.getElementById("userInfo");
      userDiv.innerHTML = `
        <img src="${user.picture.large}" alt="Profile Picture">
        <h3>${user.name.title} ${user.name.first} ${user.name.last}</h3>
        <p><strong>Email:</strong> ${user.email}</p>
      `;
    })
    .catch(error => console.error("Error fetching user:", error));
});
