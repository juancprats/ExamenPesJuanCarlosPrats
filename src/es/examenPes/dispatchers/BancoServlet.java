package es.examenPes.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import es.examenPes.controler.ejb.BuscarPorIdControlerEjb;
import es.examenPes.controler.ejb.DarAltaTarjetaEjb;
import es.examenPes.controler.ejb.ListarTodoControlerEjb;
import es.examenPes.model.entity.TarjetaCredito;

/**
 * Servlet implementation class BancoServlet
 */
@WebServlet("/Banco/*")
public class BancoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BancoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");

		String titulo = "Sin titulo";
		RequestDispatcher rd;
		switch (action) {
		
		case "ListaTodo": // se invoca al controlador adecuado
			// se redirige a otra pagina
			ListarTodoControlerEjb todos = new ListarTodoControlerEjb();
			ArrayList<TarjetaCredito> tarjeta = todos.listarTodos();
			request.setAttribute("tarjetas", tarjeta);
			rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
			titulo = "Listado general de tarjetas";
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);			
			break;
		
		case "ampliarCupo": // se invoca al controlador adecuado
			// se redirige a otra pagina
			/*ListarTodoControllerEjb todos1 = new ListarTodoControllerEjb();
			ArrayList<Cliente> clientes1 = todos1.listarTodos();
			request.setAttribute("clientes", clientes1);
			rd = request.getRequestDispatcher("/jsp/ListarTodo2.jsp");
			titulo = "Listado general de clientes";
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);			
			break;*/
			
		case "bloquearTarjeta": // se invoca al controlador adecuado que
								// obtendra
								// se redirige a otra pagina
			
			/*rd = request.getRequestDispatcher("/jsp/BuscarPorNombre.jsp");
			rd.forward(request, response);
			break;*/
			
		case "altaTarjeta": // se invoca al controlador adecuado
			
			
			rd = request.getRequestDispatcher("/jsp/altaTarjeta.jsp");
			rd.forward(request, response);

			break;
		
	case "buscarPorId":
		int id = Integer.parseInt(request.getParameter("id"));
		BuscarPorIdControlerEjb controladorBusqueda = new BuscarPorIdControlerEjb();
		ArrayList<TarjetaCredito> resultado =  controladorBusqueda.buscarPorId(id);
		request.setAttribute("id", resultado);
		rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
		request.setAttribute("titulo", "Búsqueda por: " + id);
		rd.forward(request, response);
		break;
	
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	
		String action = request.getPathInfo().substring(1);
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher rd;
		
		switch (action) {
		
	case "altaTarjeta": 
		
		
		String numero =request.getParameter("numero");
		int cupoMaximo = Integer.parseInt(request.getParameter("cupoMaximo"));
		int cupoDisponible = Integer.parseInt(request.getParameter("cupoDisponible"));
		String tipo = request.getParameter("tipo");
		String numComprobacion = request.getParameter("numComprobacion");
		String contrasenha = request.getParameter("contrasenha");
		boolean bloqueada = Boolean.parseBoolean(request.getParameter("bloqueada"));
		
		TarjetaCredito tarjeta = new TarjetaCredito(0, numero, cupoMaximo,cupoDisponible,tipo,numComprobacion,
				contrasenha, bloqueada);		

		DarAltaTarjetaEjb controlador = new DarAltaTarjetaEjb();
		controlador.agregar(tarjeta);
		rd = request.getRequestDispatcher("../index.html");
		rd.forward(request, response);

		break;
		
		
	case "buscarPorId":
		int id = Integer.parseInt(request.getParameter("id"));
		BuscarPorIdControlerEjb controladorBusqueda = new BuscarPorIdControlerEjb();
		ArrayList<TarjetaCredito> resultado =  controladorBusqueda.buscarPorId(id);
		request.setAttribute("id", resultado);
		rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
		request.setAttribute("titulo", "Búsqueda por: " + id);
		rd.forward(request, response);
		break;
		
	case "ampliarCupo":
		
	}
	}

}
