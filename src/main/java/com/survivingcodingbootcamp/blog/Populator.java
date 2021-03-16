package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import com.survivingcodingbootcamp.blog.storage.repository.HashtagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Populator implements CommandLineRunner {

    private TopicStorage topicStorage;
    private PostStorage postStorage;
    private HashtagRepository hashtagRepository;


    public Populator(TopicStorage topicStorage, PostStorage postStorage, HashtagRepository hashtagRepository) {
        this.topicStorage = topicStorage;
        this.postStorage = postStorage;
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Topic topic1 = new Topic("Learning TDD");
        topicStorage.save(topic1);

        Post post1 = new Post("TDD For Fun and Profit", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", "Bishnu Dahal");
        postStorage.save(post1);
        Post post2 = new Post("Test the Fear Away", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", "Anju");
        postStorage.save(post2);
        Post post3 = new Post("Unit Tests and You", topic1, "Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.", "Tom");
        postStorage.save(post3);
        Topic topic2 = new Topic("Battling Imposter Syndrome");
        topicStorage.save(topic2);
        Topic topic3 = new Topic("Introductory Java");
        topicStorage.save(topic3);
        Topic topic4 = new Topic("Object Oriented Programming and You");
        topicStorage.save(topic4);

        Hashtag hashtag1 = new Hashtag("new");
        Hashtag hashtag2 = new Hashtag("brand");
        Hashtag hashtag3 = new Hashtag("Hype");
        hashtagRepository.save(hashtag1);
        hashtagRepository.save(hashtag2);
        hashtagRepository.save(hashtag3);

    }

}
