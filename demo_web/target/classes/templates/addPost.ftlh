<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!--Import Google Icon Font-->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <title>Document</title>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="/hello" class="brand-logo">Main</a>
        <ul class="right hide-on-and-down">
            <li><a href="#">Send Post</a></li>
            <li><a href="/notes">All Posts</a></li>
        </ul>
    </div>
</nav>

<div class="col s12 m7 size-card">
    <div class="card horizontal">

        <div class="card-stacked">
            <div class="card-content">
<form action="/note" method="post">
    <h4 style="color: black">Title</h4><input name="title" style="color: black" placeholder="Title"><br>
    <h4 style="color: black">Text</h4><input name="body" style="color: black" placeholder="Text"><br>
    <button class="btn waves-effect waves-light" type="submit" name="action">Send
        <i class="material-icons right">send</i>
    </button>
</form>
            </div>
        </div>
    </div>
</div>
</body>
</html>