<html>
<head>
    <title>
        Welcome!
    </title>
</head>
<body>

<form action="/fruits" method="post">
    <p>Choose your fruit:</p>

    <#list fruits as fruit>
        <p>
            <label>
                <input type="radio" name="fruit" value="${fruit}">
            ${fruit}
            </label>
        </p>
    </#list>

    <input type="submit" value="Submit">
</form>

</body>
</html>