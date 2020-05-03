package mensajeJSTL.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mensajeJPA.dao.MensajeDAO;
import mensajeJPA.entities.Mensaje;
import mensajeJPA.entities.Usuario;

/**
 * Servlet implementation class MensajeControl
 */
@WebServlet("/MensajeControl")
public class MensajeControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Mensaje m = new Mensaje();
	Usuario u = new Usuario();
	MensajeDAO mDao = new MensajeDAO();
    /**
     * Default constructor. 
     */
    public MensajeControl() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String accion = request.getParameter("accion");	
		
		switch (accion) {
		case "registrar":
		    request.getRequestDispatcher("registro.jsp").forward(request, response);
		    break;
		case "listar":
		    MensajeDAO mD = new MensajeDAO();
		    request.getRequestDispatcher("mensaje.jsp").forward(request, response);
		    break;
		case "ingresar":
			String nombre = request.getParameter("nombre");
			String email = request.getParameter("email");
			String website = request.getParameter("website");
			String mensaje = request.getParameter("mensaje");
			String usuario = request.getParameter("usuario"); 
			u.setUser(usuario);
			m.setNombre(nombre);
			m.setEmail(email);
			m.setWebsite(website);
			m.setMensaje(mensaje);
			m.setUsuario1(u);
			mDao.registrar(m);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		case "atras":
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		case "eliminar":
			String p = request.getParameter("id");
			int uno = Integer.parseInt(request.getParameter("id"));
			mDao.eliminar(uno);
			request.getRequestDispatcher("mensaje.jsp").forward(request, response);
			break;
		case "editar":
			//String x = request.getParameter("id");
			int dos = Integer.parseInt(request.getParameter("id"));
			m = mDao.buscar(dos);
			request.setAttribute("mensaje", m);
			System.out.println(m.getNombre());
			System.out.println(m.getEmail());
			System.out.println(m.getId());
			request.getRequestDispatcher("editar.jsp").forward(request, response);
			break;
			
		case "update":
			String nombre1= request.getParameter("nombre1");
			String email1= request.getParameter("email1");
			String website1= request.getParameter("website1");
			String mensaje1= request.getParameter("mensaje1");
			String usu = request.getParameter("usuario1");
			u.setUser(usu);
			m.setNombre(nombre1);
			m.setEmail(email1);
			m.setWebsite(website1);
			m.setUsuario1(u);
			m.setMensaje(mensaje1);
			mDao.actualizar(m);
			request.getRequestDispatcher("mensaje.jsp").forward(request, response);
			break;
			
		default:
			break;
	}

	}
}
