package com.mx.consumoApi.servicio;

import java.util.HashMap;

import com.mx.consumoApi.dominio.Historial;

public class MetodosImp implements Metodos {
	
	HashMap<String, Historial> hash = new HashMap<String, Historial>();
	Historial historial;

	@Override
	public void guardar(Object obj) {
		historial = (Historial) obj;
		hash.put(historial.getCp(), historial);
		
	}

	@Override
	public void eliminar(Object obj) {
		historial = (Historial) obj;
		hash.remove(historial.getCp());
		
	}

	@Override
	public Object buscar(Object obj) {
		historial = (Historial) obj;
		return hash.get(historial.getCp());
	}

	@Override
	public void mostrar() {
		System.out.println(hash);		
	}
	
	public void eliminarTodo() {
		hash.clear();
		System.out.println("Se elimino el historial");
	}

}
