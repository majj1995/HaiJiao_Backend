package com.mjj.travelling.service.VO;

import com.mjj.travelling.model.TeamPost;
import com.mjj.travelling.model.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
@NoArgsConstructor
public class TeamPostVO {

    //TODO 添加评论

    private TeamPost teamPost;

    private List<User> members;

}
