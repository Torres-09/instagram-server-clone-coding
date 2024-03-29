package com.example.demo.src.auth;


import com.example.demo.src.auth.model.PostLoginReq;
import com.example.demo.src.auth.model.User;
import com.example.demo.src.post.model.GetPostImgRes;
import com.example.demo.src.post.model.GetPostsRes;
import com.example.demo.src.post.model.PostImgsUrlReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class AuthDao {

    private JdbcTemplate jdbcTemplate;
    private List<GetPostImgRes> getPostImgRes;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getPwd(PostLoginReq postLoginReq) {
        String getPwdQuery = "select userIdx, name, nickname, email, pwd from User where email = ?";
        String getPwdParams = postLoginReq.getEmail();

        return this.jdbcTemplate.queryForObject(getPwdQuery,
                (rs, rowNum) -> new User(
                        rs.getInt("userIdx"),
                        rs.getString("name"),
                        rs.getString("nickname"),
                        rs.getString("email"),
                        rs.getString("pwd")
                ),
                getPwdParams
        );
    }

}
