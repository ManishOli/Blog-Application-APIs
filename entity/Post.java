package com.codewithmanish.blog.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "postTable")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String content;
    @Column(name = "Post_title", nullable = false, length = 100)
    private String PostTitle;
    private Date date;
    private String ImageName;

    public Post(int postId, String content, String PostTitle, String ImageName) {
        super();
        this.postId = postId;
        this.content = content;
        this.PostTitle = PostTitle;
        this.ImageName = ImageName;
    }

    // ... rest of the class remains unchanged



	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPostTitle() {
		return PostTitle;
	}

	public void setPostTitle(String PostTitle) {
		this.PostTitle = PostTitle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getImageName() {
		return ImageName;
	}

	public void setImageName(String ImageName) {
		this.ImageName = ImageName;
	}
	
	
	public Post() {
		
	}

	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnore
	private Category category;
	
	@ManyToOne
	@JoinColumn(name="user_id") 
	@JsonIgnore
	private User user;
	
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
	
	
	
	
	

}
