<!DOCTYPE html>
<!--
Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Html.html to edit this template
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="/ProjectCuoiKy/table" method="get" >
            <div class="form-group">
                <label class="control-label" for="ID">Id: </label>
                <input id="ID" class="form-control" name="id" value="${id}" autofocus="autofocus" />
            </div>

            <div class="form-group">
                <label class="control-label" for="name">Name: </label>
                <input id="name" class="form-control" name="name" value="${name}" autofocus="autofocus" />
            </div>

            <div class="form-group">
                <label class="control-label" for="dob">dob </label>
                <input id="dob" class="form-control" name="dob" value="${dob}" autofocus="autofocus" />
            </div>

            <div class="form-group">
                <label class="control-label" for="department">Description </label>
                <input id="department" class="form-control" name="department" value="${department}" autofocus="autofocus" />
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-success">Search</button>
            </div>
        </form>
    </body>
</html>
