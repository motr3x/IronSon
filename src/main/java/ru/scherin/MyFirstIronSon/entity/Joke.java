package ru.scherin.MyFirstIronSon.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="text")
    private String text;
    @Column(name="date_of_create")
    private Date dateOfCreate;
    @Column(name="date_of_modify")
    private Date dateOfModify;

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getDateOfCreate() {
        return dateOfCreate;
    }

    public Date getDateOfModify() {
        return dateOfModify;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDateOfCreate(Date dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public void setDateOfModify(Date dateOfModify) {
        this.dateOfModify = dateOfModify;
    }

    @Override
    public String toString() {
        return text + "\n";
    }
}
