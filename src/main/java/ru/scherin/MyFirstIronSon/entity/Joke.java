package ru.scherin.MyFirstIronSon.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joke_seq")
    @SequenceGenerator(name = "joke_seq", sequenceName = "joke_sequence", allocationSize = 1)
    private Long id;
    @Column(name="text")
    private String text;
    @Column(name="date_of_create")
    private LocalDateTime dateOfCreate;
    @Column(name="date_of_modify")
    private LocalDateTime dateOfModify;
    @Column(name="author")
    private String author;

    public Joke(Long id, String text, LocalDateTime dateOfCreate, LocalDateTime dateOfModify, String author) {
        this.id = id;
        this.text = text;
        this.dateOfCreate = dateOfCreate;
        this.dateOfModify = dateOfModify;
        this.author = author;
    }

    public Joke() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateOfCreate() {
        return dateOfCreate;
    }

    public LocalDateTime getDateOfModify() {
        return dateOfModify;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateOfCreate(LocalDateTime dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public void setDateOfModify(LocalDateTime dateOfModify) {
        this.dateOfModify = dateOfModify;
    }

    @Override
    public String toString() {
        return  "{" + id + "} " + "\"" + text + "\"" + " \n AUTHOR: " + author;
    }
}
