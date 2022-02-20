package emlakburada.service.impl;

import emlakburada.model.dto.Message;
import emlakburada.model.dto.User;
import emlakburada.repository.MessageRepository;
import emlakburada.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> findAllMessage() {
        return messageRepository.findAllMessages();
    }


    @Override
    public void createMessage(Message message) {
        messageRepository.createMessage(message);
    }

    @Override
    public Message findById(Long id) throws Exception {
        Message message = messageRepository.findById(id);
        if (message.equals(0)) {
            throw new Exception("Data not found!");
        }
        return message;
    }
}
