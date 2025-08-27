package com.example.javaapr2025springcontroller.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class EmployeeReviews {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer rating;
    private String reviewDesc;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    @Override
    public String toString() {
        return "EmployeeReviews{" +
                "id=" + id +
                ", rating=" + rating +
                ", reviewDesc='" + reviewDesc + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeReviews that = (EmployeeReviews) o;
        return Objects.equals(id, that.id) && Objects.equals(rating, that.rating) && Objects.equals(reviewDesc, that.reviewDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating, reviewDesc);
    }
}
