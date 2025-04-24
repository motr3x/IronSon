package ru.scherin.MyFirstIronSon.exception;

public class JokeNotFoundException extends RuntimeException {
    public JokeNotFoundException(String message){
        super(message);
    }
}
