package com.movieroute.movieservice.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Movie {
    @Id
    String id;
    String url;
    String name;
    String comment;
    Double rating;

   /* public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Movie(String id, String url, String name, String comment, Double rating) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.comment = comment;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", name='" + name + '\'' +
                ", comment='" + comment + '\'' +
                ", rating=" + rating +
                '}';
    }

    public Movie() {

    }

    public Movie(String id, String name, Double rating, String url) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }


    public Movie(String id) {
        this.id = id;
    }

    public Movie(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

*/
}
