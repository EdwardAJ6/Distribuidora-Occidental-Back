package com.sena.disocc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sena.disocc.modelo.Productos;
import com.sena.disocc.service.ProductoService;

@Controller
@RequestMapping("/Dashboard/admin")
public class ProductoController {

	@Autowired
	ProductoService productoService;

	@GetMapping("/producto")
	public String list(Model modelo) {
		modelo.addAttribute("prducto", productoService.listAllProductos());
		return "Dashboard/productos/productoListar";
	}

	@GetMapping("/producto/nuevo")
	public String formularioGuardar(Model modelo) {
		Productos producto = new Productos();
		modelo.addAttribute("producto", producto);
		return "Dashboard/productos/productoCrear";
	}

	@PostMapping("/producto")
	public String guardar(@ModelAttribute("producto") Productos productos) {
		productoService.saveProductos(productos);
		return "redirect:/Dashboard/productos/productoListar";
	}
	
	@GetMapping("/producto/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("producto", productoService.findById(id));
		return "Dashboard/productos/productoEditar";
	}
	
	@PostMapping("/producto/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("producto") Productos productos) {
		Productos productoExistente = productoService.findById(id);
		productoExistente.setIdProducto(id);
		productoExistente.setNombre(productos.getNombre());
		productoExistente.setPrecioUnidad(productos.getPrecioUnidad());
		productoExistente.setStockDisponible(productos.getStockDisponible());
		productoExistente.setDescripcion(productos.getDescripcion());
		productoExistente.setFechaVencimiento(productos.getFechaVencimiento());
		productoExistente.setMarca(productos.getMarca());
		productoExistente.setCategoriaProducto(productos.getCategoriaProducto());
		productoService.saveProductos(productoExistente);
		return "redirect:/Dashboard/productos/productoListar";
	}
	
	@GetMapping("/producto/{id}")
	public String eliminar(@PathVariable int id) {
		productoService.deleteProductos(id);
		return "redirect:/Dashboard/productos/productoListar";
	}
}
