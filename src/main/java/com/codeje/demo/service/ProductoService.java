package com.codeje.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.codeje.demo.interfaceService.IProductoService;
import com.codeje.demo.interfaces.IProducto;
import com.codeje.demo.modelo.Producto;


@Service
public class ProductoService implements IProductoService{

	@Autowired
	private IProducto service;
	@Override
	public List<Producto> listar() {
		
		return (List<Producto>)service.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		
		return service.findById(id);
	}

	

	@Override
	public void delete(int id) {
		
		service.deleteById(id);
	}

	@Override
	public int save(Producto p) {
		int num=0;
		Producto producto = service.save(p);
		
		if(!producto.equals(null)) {
			num = 1;
		}
		return num;
	}
	
}
