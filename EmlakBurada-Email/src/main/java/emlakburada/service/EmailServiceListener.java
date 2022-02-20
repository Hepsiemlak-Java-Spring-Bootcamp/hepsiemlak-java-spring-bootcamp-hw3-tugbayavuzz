package emlakburada.service;

import emlakburada.dto.EmailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import javax.jms.MessageConsumer;

public class EmailServiceListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "emlakburada.queue")
    public void messageListener(EmailService emailService) {
        LOGGER.info("Message received! {}", emailService);
    }
}
