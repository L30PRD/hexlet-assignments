@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Users</h1>
            <table class = "table">
                <div>
                    <tr>
                        <td>Id</td>
                        <td>User</td>
                    </tr>
                    @for(var user : page.getUsers())
                        <tr>
                            <td>${user.getId()}</td>
                            <td><a href="/users/${user.getId()}">${user.getFirstName()} ${user.getLastName()}</a></td>
                        </tr>
                    @endfor
                </div>
            </table>
        </main>
`
)