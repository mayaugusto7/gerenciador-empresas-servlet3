package br.com.alura.gerenciador.web;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Como logout deve ser restrito ao usuario a pagina deve ficar dentro do WEB-INF
 * @author Maycon Ribeiro
 *
 */
@WebServlet(urlPatterns = "/logout")
public class Logout2 extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * doPost quando eu vou alterar algo no servidor
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getSession().removeAttribute("usuarioLogado"); // remove somente o atributo
		//req.getSession().invalidate(); // invalida toda a sessao
		
		//Cookie cookie = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		//PrintWriter writer = resp.getWriter();

		/**if (cookie == null)
			writer.print("<html><body>Usuario nao estava logado!</html></body>");
				
		cookie.setMaxAge(0);
		resp.addCookie(cookie);**/
		
		//writer.println("<html><body>Deslogado!</html></boby>"); html deve ficar em paginas html
		
		//resp.sendRedirect("WEB-INF/paginas/logout.html"); // devolve pro cliente
		
		// trata o redirecionamento dentro do servidor
		RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/logout.html"); 
		dispatcher.forward(req, resp);
	}
	
}
