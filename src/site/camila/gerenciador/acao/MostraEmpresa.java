package site.camila.gerenciador.acao;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.camila.gerenciador.modelo.Banco;
import site.camila.gerenciador.modelo.Empresa;

public class MostraEmpresa implements Acao {

	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("mostrando dados da empresa");

		String parameterId = request.getParameter("id");
		Integer id = Integer.valueOf(parameterId);

		Banco banco = new Banco();
		banco.getEmpresas();

		Empresa empresa = banco.buscaEmpresaPelaId(id);

		System.out.println(empresa.getNome());

		// chamar um JSP
		request.setAttribute("empresa", empresa);
		
		return "forward:formAlteraEmpresa.jsp";
	}
}
