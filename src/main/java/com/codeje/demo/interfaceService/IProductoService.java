package com.codeje.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.codeje.demo.modelo.Producto;

public interface IProductoService {
	public List<Producto>listar();
	public Optional<Producto>listarId(int id);
	public int save(Producto p);
	public void delete(int id);
}
