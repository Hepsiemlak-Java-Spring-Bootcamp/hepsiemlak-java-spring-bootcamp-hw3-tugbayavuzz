package emlakburada.repository;

import emlakburada.model.dto.Message;
import emlakburada.model.dto.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MessageRepository {

    private static List<Message> messageList = new ArrayList<>();

    public void createMessage(Message message) {
        messageList.add(message);
        System.out.println(messageList);
    }

    public List<Message> findAllMessages() {
        return messageList;
    }

    public Message findById(Long id) {
        for (Message message : messageList) {
            if (message.getId().equals(id)) {
                return message;
            }
        }
        return null;
    }
}
