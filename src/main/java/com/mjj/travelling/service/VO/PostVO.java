package com.mjj.travelling.service.VO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.Reply;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;


@Data
@NoArgsConstructor
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class PostVO {

    private Post post;

    private Page<Reply> replies;
}
