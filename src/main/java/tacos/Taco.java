package tacos;

import java.sql.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	private Long id;
	private Date createdAt;
	@NotNull
	@Size(min = 5, message = "Name should be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min = 1, message = "You must add at least 1 ingredient")
	private List<Ingredient> ingredients;
}
