package ifsp.edu.IFPizza.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Ingredient {
	private final String id;
	private final String name;
	private final Type type;
	
	public Ingredient(String id, String name, Type type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public enum Type {
		RIM, PROTEIN, VEGETABLES, CHEESE
		}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Type getType() {
		return type;
	}
	
	
}
