@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
        <p>
        <table class = "table">
            <tr>
                <td>ID</td>
                <td>Full name</td>
                <td>Email</td>
            </tr>
            <tr>
                <td>${page.getUser().getId()}</td>
                <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
                <td>${page.getUser().getEmail()}</td>
            </tr>
        </table>
        </p>
`
)