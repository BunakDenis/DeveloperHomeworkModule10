<!DOCTYPE html>
<html>
  <head>
    <meta
      charset="utf-8"
      name="viewport"
      content="width=device-width, initial-scale=1.0, user-scalable=no"
    />
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600"
      rel="stylesheet"
    />
    <title>Current Time</title>
    <style>
      html {
        font-family: "Open Sans", sans-serif;
        display: block;
        margin: 0px auto;
        text-align: center;
        color: #333333;
      }

      body {
        margin-top: 50px;
      }

      img {
        height: 100px;
        width: 100px;
      }

      h1 {
        margin: 50px auto 30px;
      }
      .data {
        padding: 10px;
      }
    </style>
  </head>
  <body>
    <div class="data">
      <img src="/clock-icon.svg" />
    </div>
    <h1>Current Time</h1>
    <div>
      <h3>
      <%
           out.println(DateTimeService.get());
      %>
      </h3>
    </div>
  </body>
</html>