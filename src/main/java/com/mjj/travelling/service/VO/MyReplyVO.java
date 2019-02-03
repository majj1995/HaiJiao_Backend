package com.mjj.travelling.service.VO;

import com.mjj.travelling.model.MyReply;
import com.mjj.travelling.model.Post;
import com.mjj.travelling.model.Reply;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class MyReplyVO {

    private List<MyReply> myReplies;

    private Page<Reply> replies;

}
