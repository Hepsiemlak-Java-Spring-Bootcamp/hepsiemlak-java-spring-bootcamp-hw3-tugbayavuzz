package emlakburada.controller;

import emlakburada.model.dto.Message;
import emlakburada.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2")
public class MessageController {

    private final MessageService messageService;


    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public void createMessage(@RequestBody Message message) {
        messageService.createMessage(message);
    }

    @GetMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    public List<Message> findAll() {
        return messageService.findAll();
    }

    @GetMapping("/{id}")//one find message with id
    @ResponseStatus(HttpStatus.OK)
    public Message findById(@PathVariable Long id) throws Exception {
        return messageService.findById(id);
    }

}
