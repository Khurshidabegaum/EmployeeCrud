<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <h1 style="color:deeppink;">Search Employee ByID.....!!!!</h1>
    <form action="EmpById">
        <legend> Employee ID  </legend>
        <input type=number name="eid"><br>
        <button type="submit">Find</button>

    </form>
    <br><br>
    <h1>${info}</h1> <br><br>
    <form action="Welcome.jsp">
        <button type="submit">Go Back To Main</button>
    </form>

</body>
</html>