package site.camila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.camila.gerenciador.modelo.Banco;
import site.camila.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//pegando os parametros do JSP
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		System.out.println("Logando " + login);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}

}
