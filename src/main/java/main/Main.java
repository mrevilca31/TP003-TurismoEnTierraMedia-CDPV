package main;

import java.util.List;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;
import servicios.AtraccionServicio;
import servicios.LoginServicio;
import servicios.OrdenadorServicio;
import servicios.UsuarioServicio;

public class Main {

	public static void main(String[] args) {
		
		OrdenadorServicio oservice = new OrdenadorServicio();
		System.out.println(oservice.crearListaOrdenada("Eowyn"));

		UsuarioServicio uservice = new UsuarioServicio();
		System.out.println(uservice.find(1));
		System.out.println("------------------------------------------------------");
		System.out.println(uservice.list());
		System.out.println("------------------------------------------------------");

		AtraccionServicio aservice = new AtraccionServicio();
		System.out.println(aservice.list());
		System.out.println("------------------------------------------------------");
		System.out.println(aservice.findAtraccionById(1));
	}
}