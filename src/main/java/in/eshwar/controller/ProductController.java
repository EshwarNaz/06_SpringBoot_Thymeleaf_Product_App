package in.eshwar.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.eshwar.entity.ProductEntity;
import in.eshwar.repo.ProductRepository;

@Controller
public class ProductController {

	@Autowired
	private ProductRepository repo;

	@GetMapping("/edit")
	public String editProduct(@RequestParam("Id") Integer id, Model model) {
		Optional<ProductEntity> product = repo.findById(id);
		if (product.isPresent()) {
			ProductEntity productEntity = product.get();
			model.addAttribute("product", productEntity);
		}

		return "index";
	}

	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("Id") Integer id, Model model) {
		repo.deleteById(id);
		model.addAttribute("msg", "Product Deleted");
		model.addAttribute("listOfProducts", repo.findAll());
		return "data";
	}

	@GetMapping("/products")
	public String viewProducts(Model model) {
		model.addAttribute("listOfProducts", repo.findAll());
		return "data";
	}

	@PostMapping("/product")
	public String saveProduct(@Validated @ModelAttribute("product") ProductEntity p, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "index";
		}
		p = repo.save(p);
		if (p.getId() != null) {
			model.addAttribute("msg", "product Saved");
		}
		return "index";
	}

	@GetMapping("/")
	public String loadPage(Model model) {
		model.addAttribute("product", new ProductEntity());
		return "index";
	}
}
