package emlakburada.model.request;

import emlakburada.model.dto.User;
import lombok.Data;

import java.util.Date;

@Data
public class MessageRequest {
    private Long id;
    private String baslik;
    private String icerigi;
    private Date gonderilenTarih;
    private Date okunduguTarihi;
    private boolean gorulduMu;
    private User gonderici;
    private User alici;
    private String email;
}
