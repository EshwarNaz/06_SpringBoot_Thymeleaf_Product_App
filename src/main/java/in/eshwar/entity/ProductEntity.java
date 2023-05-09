package in.eshwar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class ProductEntity {

	@Id
	@GeneratedValue
	private Integer Id;
	
	@NotBlank(message="Name is Mandatory")
	@Size(min=3 , max=15 , message="Name should have only 3 to 15 characters")
	private String Name;
	
	@NotNull(message="Price is Mandatory")
	@Positive(message="price should be positive")
	private Double Price;
	
	@NotNull(message="Quantity is Mandatory")
	@Positive(message="Quantity should be positive")
	private Integer Quantity;
}
