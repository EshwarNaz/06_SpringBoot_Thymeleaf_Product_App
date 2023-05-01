package in.eshwar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ProductEntity {

	@Id
	@GeneratedValue
	private Integer Id;
	private String Name;
	private Double Price;
	private Integer Quantity;
}
