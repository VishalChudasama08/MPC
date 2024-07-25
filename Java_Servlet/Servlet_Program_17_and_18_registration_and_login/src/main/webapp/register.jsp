<html>
<body>
    <form action="regForm" method="post">
        Name : <input type="text" name="name" /><br><br>
        Email : <input type="email" name="email" /><br><br>
        Password : <input type="password" name="password" /><br><br>
        Gender : <input type="radio" name="gender" value="Male"/> Male
                 <input type="radio" name="gender" value="female" /> Female <br><br>
        City : <select name="city">
                    <option> Select City </option>
                    <option> Delhi </option>
                    <option> Mumbai </option>
                    <option> Gujarat </option>
                    <option> Rajasthan </option>
               </select><br><br>
        <input type="Submit" value="Register"/>
    </form>
    <br><a href="login.jsp">Login</a>
</body>
</html>
