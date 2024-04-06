package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.dto.posts.BuildPostPage;
import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;
import io.javalin.http.NotFoundResponse;

import java.util.Collections;
import java.util.List;

public class PostsController {

    public static void build(Context ctx) {
        var page = new BuildPostPage();
        ctx.render("posts/build.jte", model("page", page));
    }

    // BEGIN
    public static void create(Context ctx) {
        var name = ctx.formParamAsClass("name", String.class)
                .check(v -> v.length() >= 2, "Название должно быть не короче двух символов")
                .get();
        var discription = ctx.formParam("body");

        Post post = new Post(name, discription);
        PostRepository.save(post);
        ctx.sessionAttribute("flash", "Пост был успешно создан!");
        ctx.redirect(NamedRoutes.postsPath());
    }
    // END

    public static void index(Context ctx) {
        List<Post> posts = PostRepository.getEntities();
        String messenge = ctx.consumeSessionAttribute("flash");
        PostsPage page = new PostsPage(posts);
        page.setFlash(messenge);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
}
