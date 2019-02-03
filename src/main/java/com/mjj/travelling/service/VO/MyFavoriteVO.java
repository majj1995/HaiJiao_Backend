package com.mjj.travelling.service.VO;

import com.mjj.travelling.model.Favorite;
import com.mjj.travelling.model.Post;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class MyFavoriteVO {

    private List<Post> myFavoritePosts;

    private Page<Favorite> favorites;
}
