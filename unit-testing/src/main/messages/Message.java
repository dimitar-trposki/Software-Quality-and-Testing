package main.messages;

public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }

    public String salutationMessage() {
        this.message = "Hello!";
        return this.message;
    }

    public String goodbyeMessage() {
        this.message = "Goodbye!";
        return this.message;
    }

    public String setMessage(String message) {
        this.message = message;
        return this.message;
    }
}