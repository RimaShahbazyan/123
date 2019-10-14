<%--
  Created by IntelliJ IDEA.
  User: srima_000
  Date: 10/11/2019
  Time: 6:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
<script>
    (function auth() {
      let xhr = new XMLHttpRequest();
      xhr.onreadystatechange= function () {
        if(this.readyState === 4) {
          if (this.status === 200)
            window.location = "/welcome";
          else
            window.location = "/LogInPage.html";
        }
      }
      xhr.open("POST", "http://localhost:8010/auth");
      xhr.send()
    })();

  </script>
</html>
