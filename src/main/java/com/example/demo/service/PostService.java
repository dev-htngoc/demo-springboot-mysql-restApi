package com.example.demo.service;

import com.example.demo.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();
    Post getPostById(Long id);
    Post savePost(Post post);
    Post updatePost(Long id, Post postDetails);
    void deletePost(Long id);
}
