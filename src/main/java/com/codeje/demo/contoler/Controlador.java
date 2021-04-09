package com.codeje.demo.contoler;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.codeje.demo.interfaceService.IProductoService;
import com.codeje.demo.modelo.Producto;

@Controller
@RequestMapping
public class Controlador {
	
	@Autowired
	private IProductoService service ;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Producto>producto =service.listar();
		model.addAttribute("producto", producto);
		return "index";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("producto" , new Producto());
		return "nuevoProducto";
		
	}
	
	@GetMapping("/save")
	public String save(@Valid Producto producto, Model model) {
		service.save(producto);
		return "redirect:/listar";
	}
	
	@GetMapping("/update/{id}")
	public String update (@PathVariable int id, Model model) {
		Optional<Producto>producto = service.listarId(id);
		model.addAttribute("producto", producto);
		return "nuevoProducto";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, Model model) {
		service.delete(id);
		return "redirect:/listar";
		
	}
}
