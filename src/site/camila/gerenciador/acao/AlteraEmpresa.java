package site.camila.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.camila.gerenciador.modelo.Banco;
import site.camila.gerenciador.modelo.Empresa;

public class AlteraEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");

		String paramId = request.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		
		System.out.println("Ação altera empresa" + id);
		
		String paramDataEmpresa = request.getParameter("data");
		// parseando a Date -> String
		Date dataAbertura = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
			dataAbertura = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}

		Banco banco = new Banco();
		Empresa empresa = banco.buscaEmpresaPelaId(id);
		empresa.setNome(nome);
		empresa.setDataAbertura(dataAbertura);

		response.sendRedirect("entrada?acao=ListaEmpresas");

	}
}
