package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

@WebServlet(urlPatterns="/busca")
public class BuscaEmpresa2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//private String filtro;
	
	/**
	 * Construtor que instancia o servlet
	 */
	public BuscaEmpresa2() {
		System.out.println("Construindo uma servlet do tipo BuscaEmpresa " + this);
	}
	
	/**
	 * Inicializa a servlet
	 * @throws ServletException
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a servlet " + this);
	}

	
	/**
	 * 
	 */
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servlet " + this);
	}
	
	/**
	 * Pesquisa metodo http get consulta dados do servidor
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/**
		PrintWriter writer = resp.getWriter();
	
		writer.println("<html><body>");
		writer.println("Resultado da busca:<br/>");
		
		String filtro = req.getParameter("filtro");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		
		writer.println("<ul>");
		
		for (Empresa empresa : empresas) {
			writer.println("<li>" + empresa.getId() + ": " + empresa.getNome() + "</li>");
		}
		
		writer.println("</ul>");
		writer.println("</html></body>");
		
		**/
		
		String filtro = req.getParameter("filtro");

		//String filtro = "doce";
		Collection<Empresa> empresas = new EmpresaDAO().buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);
	}
}
