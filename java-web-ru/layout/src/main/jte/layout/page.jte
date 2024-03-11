@import gg.jte.Content

@param Content content

<!doctype html>

<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Main page</title>
        <a href="/">Main page</a>
        <a href="/users">Users</a>
    </head>
    <body>
        <div class="content">
            ${content}
        </div>
        <div class="footer">
            <p>Thanks for visiting, come again soon!</p>
        </div>
    </body>
</html>