package dhbw.projects.data.inputOutput;

import java.util.Scanner;
import java.util.UUID;

public class Message {

    private final String messageText;
    private final UUID messageId;

    public Message(String input, UUID uuid){
        this.messageText = input;
        this.messageId = uuid;
    }

    public String getMessageText() {
        return messageText;
    }

    public UUID getMessageId() {
        return messageId;
    }

    public String getUserInput(){
        Scanner sc = new Scanner(System.in);

        return sc.next();
    }

}
