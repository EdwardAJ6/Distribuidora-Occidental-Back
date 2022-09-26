package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sena.disocc.modelo.CategoriasProductos;
import com.sena.disocc.service.CategoriaProductoService;

@Controller
@RequestMapping("/Dashboard/admin")
public class CategoriaProductoController {

	@Autowired
	CategoriaProductoService categoriaProductoService;

	@GetMapping("/categoriaProducto/listar")
	public String list(Model modelo) {
		modelo.addAttribute("categorias", categoriaProductoService.listAllCategoriasProductos());
		return "Dashboard/categoriaProducto/categoriaProductoListar";
	}

	@GetMapping("/categoriaProducto/crear")
	public String formularioGuardar(Model modelo) {
		CategoriasProductos categoriaProducto = new CategoriasProductos();
		modelo.addAttribute("categoriaProducto", categoriaProducto);
		return "Dashboard/categoriaProducto/categoriaProductoCrear";
	}

	@PostMapping("/categoriaProducto")
	public String guardar(@ModelAttribute("categoriaProducto") CategoriasProductos categoriasProductos) {
		categoriaProductoService.saveCategoriasProductos(categoriasProductos);
		return "redirect:/Dashboard/categoriaProducto/categoriaProductoListar";
	}
	
	@GetMapping("/categoriaProducto/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("categoriaProducto", categoriaProductoService.findById(id));
		return "Dashboard/categoriaProducto/categoriaProductoEditar";
	}
	
	@PostMapping("/categoriaProducto/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("categoriaProducto") CategoriasProductos categoriasProducto) {
		CategoriasProductos categoriaProductoExistente = categoriaProductoService.findById(id);
		categoriaProductoExistente.setIdCategoria(id);
		categoriaProductoExistente.setIdNombreCategoria(categoriasProducto.getIdNombreCategoria());
		categoriaProductoService.saveCategoriasProductos(categoriaProductoExistente);
		return "redirect:/Dashboard/categoriaPorducto/categoriaPorductoListar";
	}
	
	@GetMapping("/categoriaProducto/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		categoriaProductoService.deleteCategoriasProductos(id);
		return "redirect:/Dashboard/categoriaProducto/categoriaProductoListar";
	}
}
