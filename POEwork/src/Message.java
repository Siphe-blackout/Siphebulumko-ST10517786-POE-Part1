import java.util.*;
import org.json.simple.JSONObject;

public class Message {
    private static int totalMessages=0;
    private final String messageID;
    private final String recipient;
    private final String message;
    private final String messageHash;
    private String status;

    //Constructor
    public Message(String recipient, String message) {
        this.messageID = generateMessageID();
        this.recipient = recipient;
        this.message = message;
        this.messageHash = createMessageHash();
    }

    public static int returnTotalMessages() {
        return totalMessages;
    }

    //Generating 10 digit ID
    private String generateMessageID(){
        Random rand= new Random();
        StringBuilder id= new StringBuilder();
        for( int i = 0; i< 10; i++){
            id.append(rand.nextInt(10));
        }
        return id.toString();
    }
    //Validate recipient number( must be 10 characters and must start with "+27" international code
    public String checkRecipientno(){
        if(recipient.length()==10 && recipient.startsWith("+27")){
            return "Cellphone number successfully captured";
        } else{
            return "Cellphone number not formated correctly. Must be 10 characters and begin with +27 international code";
        }
    }

    // Validate message length. Must be less than 250 characters.
    public String checkMessageLength(){
        if(message.length()<=250){
            return "Message ready to send.";
        } else{
            int excess= message.length()-250;
            return "Message exceeds 250 characters by "+ excess + ", please reduce";
        }
    }

    // Create Message Hash: first 2 digits of ID: message number: first + last word
    private String createMessageHash(){
        String[]words= message.split(" ");
        String firstword= words[0].toUpperCase();
        String lastword= words[words.length-1].toUpperCase();
        return messageID.substring(0,2) + ":0:" + firstword + lastword;
    }

    //Handle sending, storing or disregarding messages
    public String sendMessage(String option){
        switch (option.toLowerCase()){
            case"send":
                status="Sent";
                totalMessages++;
                return "Message successfully sent";
            case "store":
                status= "Stored";
                return "Message successfully stored";
            case "discard":
                status= "Discarded";
                return "Press 0 to delete the message";
            default:
                return "Invalid Option";
        }
    }

    //Return total messages sent
    public static int returnTotalMessages(int totalMessages){
        return totalMessages;
    }

    // Print Message details
    public String printMessage(){
        return "Message ID:" + messageID + "\n" + "Message Hash:" +messageHash+ "\n" + "Recipient:" + recipient+ "\n" + "Message:" + message + "\n" + "Status:" + status;
    }

    //Store message in JSON format
    public JSONObject storeMessageJSON(){
        JSONObject obj= new JSONObject();
        obj.put("MessageID",messageID);
        obj.put("MessageHash",messageHash);
        obj.put("Recipient",recipient);
        obj.put("Message",message);
        obj.put("Status",status);
        return obj;
    }


}

