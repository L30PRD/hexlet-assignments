package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

import java.util.Collections;

public class SessionsController {

    // BEGIN
    public static void index (Context ctx) {
        String username = ctx.sessionAttribute("name");
        MainPage page = new MainPage(username);

        ctx.render("index.jte", Collections.singletonMap("page", page));
    }

    public static void build (Context ctx) {
        LoginPage page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create (Context ctx) {
        String name = ctx.formParam("name");
        String password = ctx.formParam("password");

        if (!UsersRepository.existsByName(name) ||
                !UsersRepository.findByName(name).getPassword().equals(encrypt(password))) {
            LoginPage page = new LoginPage(name, "Wrong username or password.");
            ctx.render("build.jte", Collections.singletonMap("page", page));
        } else {
            ctx.sessionAttribute("name", name);
            ctx.redirect(NamedRoutes.rootPath());
        }
    }

    public static void delete (Context ctx) {
        ctx.sessionAttribute("name", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
