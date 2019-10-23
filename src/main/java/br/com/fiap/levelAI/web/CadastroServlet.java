package br.com.fiap.levelAI.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.levelAI.DAO.AlunoDAO;
import br.com.fiap.levelAI.beans.Aluno;


@WebServlet(urlPatterns = "/cadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

     


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		int codigo = Integer.parseInt(req.getParameter("codigo"));
		String nome = req.getParameter("nome");
		String endereco = req.getParameter("endereco");
		String telefone = req.getParameter("telefone"); 
		String dataNascimento = req.getParameter("dataNascimento");
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		AlunoDAO dao;
		Aluno aluno = new Aluno(codigo, nome, endereco, telefone, dataNascimento, email, senha);
		try {
			dao = new AlunoDAO();
			if(dao.addAluno(aluno)>0) {
				resp.sendRedirect("form.html");
			}else {
				out.print("não consegui cadastrar");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		


	}

}
