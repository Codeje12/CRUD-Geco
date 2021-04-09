package com.codeje.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.codeje.demo.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer> {
	
}
