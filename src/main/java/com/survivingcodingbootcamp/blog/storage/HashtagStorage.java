package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HashtagStorage {
    @Autowired
    private HashtagRepository hashtagRepository;


    public HashtagStorage(HashtagRepository hashtagRepository) {
        this.hashtagRepository = hashtagRepository;
    }

    public void saveHashtag(Hashtag hashtag) {
        hashtagRepository.save(hashtag);
    }

    public Iterable<Hashtag> getAllHashtags() {
        return hashtagRepository.findAll();
    }

    public Hashtag retrieveHashtagById(long id) {
        return hashtagRepository.findById(id).get();
    }

    public Hashtag retrieveByName(String name) {
       return  hashtagRepository.findByName(name);
    }
}

