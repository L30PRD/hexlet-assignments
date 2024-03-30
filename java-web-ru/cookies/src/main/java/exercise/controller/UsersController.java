package exercise.controller;

import exercise.model.User;
import exercise.repository.UserRepository;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;

import java.util.Collections;
import java.util.Optional;


public class UsersController {

    public static void build(Context ctx) throws Exception {
        ctx.render("users/build.jte");
    }

    // BEGIN
    public static void create(Context ctx) {
        var firstName = ctx.formParam("firstName");
        var lastName = ctx.formParam("lastName");
        var email = ctx.formParam("email");
        var password = ctx.formParam("password");
        var token = Security.generateToken();

        var user = new User(firstName, lastName, email, password, token);
        UserRepository.save(user);
        ctx.cookie("token", token);
        ctx.redirect(NamedRoutes.userPath(user.getId()));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var token = ctx.cookie("token");

        Optional<User> optionalUser = UserRepository.find(id);

        if (optionalUser.isEmpty() || token == null || !optionalUser.get().getToken().equals(token)) {
            ctx.redirect(NamedRoutes.buildUserPath());
        } else {
            var user = optionalUser.get();
            ctx.render("users/show.jte", Collections.singletonMap("user", user)).status(422);
        }
    }
    // END
}
