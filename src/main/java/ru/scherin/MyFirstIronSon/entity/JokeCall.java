package ru.scherin.MyFirstIronSon.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "joke_call")
public class JokeCall {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "joke_call_seq")
    @SequenceGenerator(name = "joke_call_seq", sequenceName = "joke_call_sequence", allocationSize = 1)
    private Long id;

    @Column(name = "call_time", nullable = false)
    private LocalDateTime callTime = LocalDateTime.now();

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "joke_id", nullable = false)
    private Joke joke;

    public JokeCall(Long id, LocalDateTime callTime, Long userId, Joke joke) {
        this.id = id;
        this.callTime = callTime;
        this.userId = userId;
        this.joke = joke;
    }

    public JokeCall() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCallTime(LocalDateTime callTime) {
        this.callTime = callTime;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setJoke(Joke joke) {
        this.joke = joke;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCallTime() {
        return callTime;
    }

    public Long getUserId() {
        return userId;
    }

    public Joke getJoke() {
        return joke;
    }
}
