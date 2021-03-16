package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.HashtagStorage;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;

    public HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage) {
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;
    }

    @PostMapping("/post/{id}/addHashtags")
    public String addHashtag(String hashtags, @PathVariable Long id, Model model) {
        Hashtag hashtag = hashtagStorage.retrieveByName(hashtags);
        if(hashtag==null) {
            hashtag = new Hashtag(hashtags);
        }
        Post post = postStorage.retrievePostById(id);
        hashtag.setPost(post);
        hashtagStorage.saveHashtag(hashtag);
        return "redirect:/posts/" + id;
    }

    @GetMapping("/hashtags/{id}")
    public String seeHashtags(@PathVariable long id, Model model) {
        model.addAttribute("hashtags", hashtagStorage.retrieveHashtagById(id));
        return "single-hashtag-template";
    }
    @GetMapping("/hashtags")
    public String seeAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.getAllHashtags());
        return "All-hashtag-template";
    }
}