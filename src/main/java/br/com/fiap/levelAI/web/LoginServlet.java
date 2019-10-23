package br.com.fiap.levelAI.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.levelAI.BO.AlunoBO;
import br.com.fiap.levelAI.DAO.AlunoDAO;

@WebServlet(urlPatterns = "/LoginServlet")
public class LoginServlet extends HttpServlet {
	

/**
	 * 
	 */
	private static final long serialVersionUID = 2796157682848387926L;

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");		
		try {
			AlunoBO bo = new AlunoBO();
			if (bo.validarEmailESenha(email, senha).getCodigo()>0) {
				resp.sendRedirect("cursos.html");
			} else {
				out.print("Email ou login inválidos,  tente de novo");
				resp.sendRedirect("login.html");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
