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
import com.sena.disocc.service.CategoriaProductoService;
import com.sena.disocc.service.MarcasService;
import com.sena.disocc.service.ProductoService;

@Controller
@RequestMapping("/Dashboard/admin")
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@Autowired
	MarcasService marcasService;
	
	@Autowired
	CategoriaProductoService categoriaProductoService;

	@GetMapping("/producto/listar")
	public String list(Model modelo) {
		modelo.addAttribute("prducto", productoService.listAllProductos());
		return "Dashboard/productos/productosListar";
	}

	@GetMapping("/producto/crear")
	public String formularioGuardar(Model modelo) {
		Productos producto = new Productos();
		modelo.addAttribute("producto", producto);
		modelo.addAttribute("marca",marcasService.listAllMarcas());
		modelo.addAttribute("categoria", categoriaProductoService.listAllCategoriasProductos());
		return "Dashboard/productos/productosCrear";
	}

	@PostMapping("/producto")
	public String guardar(@ModelAttribute("producto") Productos productos) {
		productoService.saveProductos(productos);
		return "redirect:/Dashboard/admin/producto/listar";
	}
	
	@GetMapping("/producto/editar/{id}")
	public String formularioEditar(@PathVariable int id, Model modelo) {
		modelo.addAttribute("producto", productoService.findById(id));
		modelo.addAttribute("marca",marcasService.listAllMarcas());
		modelo.addAttribute("categoria", categoriaProductoService.listAllCategoriasProductos());
		return "Dashboard/productos/productosEditar";
	}
	
	@PostMapping("/producto/editar/{id}")
	public String editar(@PathVariable int id, @ModelAttribute("producto") Productos productos) {
		Productos productoExistente = productoService.findById(id);
		productoExistente.setIdProducto(id);
		productoExistente.setNombre(productos.getNombre());
		productoExistente.setPrecioUnidad(productos.getPrecioUnidad());
		productoExistente.setStockDisponible(productos.getStockDisponible());
		productoExistente.setDescripcion(productos.getDescripcion());
		productoService.saveProductos(productoExistente);
		
		return "redirect:/Dashboard/admin/producto/listar";
	}
	
	@GetMapping("/producto/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		productoService.deleteProductos(id);
		return "redirect:/Dashboard/admin/producto/listar";
	}
}
