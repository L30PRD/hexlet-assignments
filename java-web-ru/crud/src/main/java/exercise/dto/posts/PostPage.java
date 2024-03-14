package exercise.dto.posts;

import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@AllArgsConstructor
@Getter
public class PostPage {
    private Post post;
}
