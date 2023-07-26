package tacos;

import java.util.Date;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Taco {
	@Id
	private Long id;
	private Date createdAt;
	@NotNull
	@Size(min = 5, message = "Name should be at least 5 characters long")
	private String name;
	
	@NotNull
	@Size(min = 1, message = "You must add at least 1 ingredient")
	private List<Ingredient> ingredients;
}
