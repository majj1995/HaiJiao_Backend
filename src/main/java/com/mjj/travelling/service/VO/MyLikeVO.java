package com.mjj.travelling.service.VO;

import com.mjj.travelling.model.PostLike;
import com.mjj.travelling.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class MyLikeVO {

    private List<Post> likePosts;

    private Page<PostLike> likes;

}
