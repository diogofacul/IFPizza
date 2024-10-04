package ifsp.edu.IFPizza.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ifsp.edu.IFPizza.model.Ingredient;
import ifsp.edu.IFPizza.model.Ingredient.Type;
import ifsp.edu.IFPizza.model.Pizza;


@Controller
@RequestMapping("/design")
public class PizzaBuildController {

	@GetMapping
	public String showDesignFormat(Model model) {
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("CTPY", "Catupiry", Type.RIM),
				new Ingredient("BIFE", "Bife", Type.PROTEIN),
				new Ingredient("MUSS", "Mussarela", Type.CHEESE),
				new Ingredient("CARR", "Carrot", Type.VEGETABLES)

				);
		
		for (Type type : Type.values()) {
			List<Ingredient> filters = filtrarPorTipo(ingredients,type);
			model.addAttribute(type.toString().toLowerCase(),filters);
		}
		
		model.addAttribute("pizza",new Pizza());
						
		return "Design";
	}
	
	private List<Ingredient> filtrarPorTipo(List<Ingredient> ingredientes, Type tipo) {
		return ingredientes.stream
				().filter(i -> i.getType().equals(tipo))
				.collect(Collectors.toList());
	}


}
