package test.messages;

import main.messages.Message;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MessageTest {

    public Message message;

    @BeforeEach
    public void setUp() {
        message = new Message("Test message");
    }

    @Test
    void salutationMessage() {
        Assertions.assertEquals("Hello!", message.salutationMessage());
    }

    @Test
    void goodbyeMessage() {
        Assertions.assertEquals("Goodbye!", message.goodbyeMessage());
    }

    @Test
    void setMessage() {
        String messageText = "New test message";
        Assertions.assertEquals(messageText, message.setMessage(messageText));
    }
}
