package emlakburada.service;

import emlakburada.model.dto.Message;
import emlakburada.model.dto.User;

import java.util.List;

public interface MessageService {

    List<Message> findAll();

    void createMessage(Message message);

    Message findById(Long id) throws Exception;


}
