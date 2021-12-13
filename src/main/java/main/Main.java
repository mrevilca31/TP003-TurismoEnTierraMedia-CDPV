package main;

import java.util.List;

import modelo.Usuario;
import persistencia.UsuarioDAO;
import persistenciaGeneral.DAOFactory;
import servicios.LoginServicio;
import servicios.UsuarioServicio;

public class Main {

	public static void main(String[] args) {

		UsuarioServicio uservice = new UsuarioServicio();
		System.out.println(uservice.list());
		
	}
}