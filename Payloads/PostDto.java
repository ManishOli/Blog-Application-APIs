package com.codewithmanish.blog.Payloads;

import java.util.Date;

import com.codewithmanish.blog.entity.Category;
import com.codewithmanish.blog.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private int postId;
    private String content;
    private String PostTitle;
    private String ImageName;
    private Date date;

    public PostDto(int postId, String content, String PostTitle, String ImageName) {
        super();
        this.postId = postId;
        this.content = content;
        this.PostTitle = PostTitle;
        this.ImageName = ImageName;
    }

    private CategoryDto category;
    private UserDto user;

    // ... rest of the class remains unchanged
}
