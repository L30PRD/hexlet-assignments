@import exercise.dto.users.UsersPage;
@param UsersPage page

@template.layout.page(
content = @`
    <div class="input-group mb-3">
        <form action="/users" method="get">
            <input type="search" name="term" placeholder="Enter first name" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
    </div>

    <table class = "table">
        <tr>
            <td>ID</td>
            <td>User</td>
        </tr>
        @for(var user : page.getUsers())
            <tr>
                <td>${user.getId()}</td>
                <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
            </tr>
        @endfor
    </table>
`
)