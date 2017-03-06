package com.geekhub.comments;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class Comment {

    private LocalDateTime date;
    private String text;

    public Comment() {
    }

    public Comment(LocalDateTime date, String text) {
        this.date = date;
        this.text = text;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @JsonFormat(pattern="yyyy-MM-dd")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "date=" + date +
                ", text='" + text + '\'' +
                '}';
    }
}
