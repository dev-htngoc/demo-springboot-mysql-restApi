package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name="content", columnDefinition = "TEXT")
    private String content;

    @Column(name="created_at")
    private Date createdAt;

    // mỗi khi tạo bài viết mới thì field createdAt
    // sẽ tự động cập nhật thời gian hiện tại
    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }
}
