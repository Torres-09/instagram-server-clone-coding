package com.example.demo.src.auth.model;


import com.example.demo.src.post.model.PostImgsUrlReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PostLoginReq {

    public PostLoginReq() {
    }

    private String email;
    private String pwd;
}
