package emlakburada.service.queue;

import emlakburada.model.dto.EmailMessage;

public interface QueueService {
	
	void sendMessage(EmailMessage email);

}
