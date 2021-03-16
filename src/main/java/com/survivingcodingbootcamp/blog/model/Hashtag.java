package com.survivingcodingbootcamp.blog.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
@Entity
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @ManyToMany
    private Collection<Post> posts;

    public Hashtag(String name) {
        this.name = name;
        this.posts = new ArrayList<>();

    }

    public Hashtag(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Post> getPosts() {
        return posts;
    }
    public void setPost(Post post) {
        this.posts.add(post);
    }


    @Override
    public String toString() {
        return "Hashtag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", posts=" + posts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        if (id != hashtag.id) return false;
        if (name != null ? !name.equals(hashtag.name) : hashtag.name != null) return false;
        return posts != null ? posts.equals(hashtag.posts) : hashtag.posts == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (posts != null ? posts.hashCode() : 0);
        return result;
    }
}
