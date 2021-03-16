package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/posts")
public class PostController {
    private PostStorage postStorage;
    private TopicStorage topicStorage;

    public PostController(PostStorage postStorage, TopicStorage topicStorage) {
        this.postStorage = postStorage;
        this.topicStorage = topicStorage;;
    }


    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        return "single-post-template";
    }

    @GetMapping("/single-topic-template")
    public String getOwner() {
        return "single-topic-template";
    }

    @PostMapping("/add")
    public String addNewPosts(String title, long topic, String content, String author) {
        Post post1 = new Post(title, topicStorage.retrieveSingleTopic(topic), content, author);
        postStorage.save(post1);
        return "redirect:/topics/" + topic;

    }

}
