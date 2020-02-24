<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link rel="stylesheet" href="/style.css"/>
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<nav>
    <div class="nav-wrapper">
        <a href="#" class="brand-logo">Main</a>
        <ul class="right hide-on-and-down">
            <li><a href="/add/post">Send Post</a></li>
            <li><a href="#">All Posts</a></li>
        </ul>
    </div>
</nav>
<nav>
    <div class="nav-wrapper">
        <div class="input-field">
        <form method="get" action="/search">
            <div class="input-field">
                <input name="name" id="search" type="search" required>
                <label class="label-icon" for="search"><i class="material-icons">search</i></label>
                <i class="material-icons">close</i>
            </div>
        </form>
        </div>
    </div>
</nav>

<#list notes as note>
    <div class="col s12 m7 size-card">
        <div class="card horizontal">

            <div class="card-stacked">
                <div class="card-content">

                    <ul>
                        <li>User:${note.user}
                            <br>
                            Text:${note.text}
                        </li>
                    </ul>

                </div>
            </div>
        </div>
    </div>

</#list>


<#if pages?? && pages != 0>
    <nav >
        <ul class="pagination">
            <#list 1..pages as page>
                <li>
                    <a class="active" href="/posts?page=${page}">${page}</a>
                </li>
            </#list>
        </ul>
    </nav>
</#if>

</body>
</html>