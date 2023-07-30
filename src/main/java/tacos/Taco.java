package tacos;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("tacos")
public class Taco {
	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED) //defines partitioned key
	private UUID id = Uuids.timeBased();

	@NotNull
	@Size(min = 5, message = "Name should be at least 5 characters long")
	private String name;
	@PrimaryKeyColumn(type=PrimaryKeyType.CLUSTERED,
			ordering= Ordering.DESCENDING) // defines clustering key
	private Date createdAt;

	@NotNull
	@Size(min = 1, message = "You must add at least 1 ingredient")
	@Column("ingredients") //maps the list to the ingredients column
	private List<IngredientUDT> ingredients = new ArrayList<>();

	public void addIngredient(Ingredient ingredient){
		this.ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient) );
	}
}
