package site.camila.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;

import site.camila.gerenciador.modelo.Banco;
import site.camila.gerenciador.modelo.Empresa;

@WebServlet("/empresas")
public class EmpresasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Banco banco = new Banco();
//		List<Empresa> empresas = banco.getEmpresas();
		
		
		List<Empresa> empresas = new Banco().getEmpresas();
		
		XStream xstream = new XStream();
		xstream.alias("empresa", Empresa.class);
		String xml = xstream.toXML(empresas);
		
		response.setContentType("application/xml");
		response.getWriter().print(xml);
		
//		List<Empresa> empresas = new Banco().getEmpresas();
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(empresas);
//		
//		response.setContentType("application/json");
//		response.getWriter().print(json);
			
	}

}
