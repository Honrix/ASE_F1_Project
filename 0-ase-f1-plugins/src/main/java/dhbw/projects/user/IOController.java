package dhbw.projects.user;

import dhbw.projects.data.inputOutput.Message;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class IOController {

    private List<Message> messageHistory = new ArrayList<>();
    private final UUID ioControllerID;

    public IOController(UUID uuid){
        this.ioControllerID = uuid;

    }

    public void newInput(){
        Scanner sc = new Scanner(System.in);
        Message message = new Message(sc.next(), UUID.randomUUID());
        insert(message);
        sc.close();
    }

    public void createNewMessage(Message message){
        insert(message);
        System.out.println(message.getMessageText() + "     (" + message.getMessageId() + ")");
    }

    public void insert(Message input){
        messageHistory.add(input);
    }

    public void removeInput(int index){
        messageHistory.remove(index);
    }

    public Message getInput(int index){
        return this.messageHistory.get(index);
    }

    public List<Message> messageHistory(){
        return this.messageHistory;
    }

    public Message getLastMessage() {
        return messageHistory.get(messageHistory.size()-1);
    }
}
