package tacos;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders") //maps to the orders table
public class TacoOrder implements Serializable{
	private static final Long serialVersionUID = 1L;

	@PrimaryKey //designates the id property as being the primary key
	private UUID id = Uuids.timeBased();
	
	private Date placedAt;

	@NotBlank(message = "Delivery Name is required")
	private String deliveryName;
	
	@NotBlank(message = "Delivery Street is required")
	private String deliveryStreet;
	
	@NotBlank(message = "Delivery City is required")
	private String deliveryCity;
	
	@NotBlank(message = "Delivery State is required")
	private String deliveryState;
	
	@NotBlank(message = "Delivery Zip is required")
	private String deliveryZip;
	
	@CreditCardNumber(message = "Invalid credit card number")
	private String ccNumber;
	
	@Pattern(regexp = "^(0[1-9]|1[0-2])([\\\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
	private String ccExpiration;
	
	@Digits(integer = 3, fraction = 0, message="Invalid CVV")
	private String ccCVV;

	@Column("tacos")
	private List<TacoUDT> tacos = new ArrayList<>();

	public void addTaco(TacoUDT taco) {
		this.tacos.add(taco);
	}
}
