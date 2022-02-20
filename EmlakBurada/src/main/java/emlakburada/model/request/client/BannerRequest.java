package emlakburada.model.request.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BannerRequest {
	
	private int advertNo;
	private String phone;
	private int total;
	private AddressRequest address;

}
