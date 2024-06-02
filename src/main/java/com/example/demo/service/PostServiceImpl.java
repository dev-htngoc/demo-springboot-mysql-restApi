package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        //kiểm tra xem có bài viết trùng hay không
        //nếu không có sẽ trả về lỗi không tìm thấy
        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Post not found with id " + id));
        return post;
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Long id, Post postDetails) {
        //kiểm tra xem có bài viết trùng hay không
        //nếu không có sẽ trả về lỗi không tìm thấy
        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Post not found with id " + id));

        //Cập nhật lại thông tin bài viết
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }

    @Override
    public void deletePost(Long id) {
        //kiểm tra xem có bài viết trùng hay không
        //nếu không có sẽ trả về lỗi không tìm thấy
        Post post = postRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Post not found with id " + id));
        //thực hiện xoá bài viết
        postRepository.delete(post);
    }
}
