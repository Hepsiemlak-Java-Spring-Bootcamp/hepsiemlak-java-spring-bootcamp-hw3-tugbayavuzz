package emlakburada.model.dto;

import emlakburada.model.enums.PropertyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RealEstate {

	private Address adres;
	private PropertyType konutType;
	private String odaSayisi = "3+1";
	private int alan = 145;
	private int bulunduguKat = 3;

}