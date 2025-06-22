package ru.scherin.MyFirstIronSon.DTO;

import java.time.LocalDateTime;

public class JokeDto {
    private Long id;
    private String text;
    private String author;
    private LocalDateTime dateOfCreate;
    private LocalDateTime dateOfModify;

    public JokeDto( ) {}

    public JokeDto(Long id, String text, String author,
                   LocalDateTime dateOfCreate, LocalDateTime dateOfModify) {
        this.id = id;
        this.text = text;
        this.author = author;
        this.dateOfCreate = dateOfCreate;
        this.dateOfModify = dateOfModify;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getText() { return text; }
    public void setText(String text) { this.text = text; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public LocalDateTime getDateOfCreate() { return dateOfCreate; }
    public void setDateOfCreate(LocalDateTime dateOfCreate) { this.dateOfCreate = dateOfCreate; }

    public LocalDateTime getDateOfModify() { return dateOfModify; }
    public void setDateOfModify(LocalDateTime dateOfModify) { this.dateOfModify = dateOfModify; }
}
