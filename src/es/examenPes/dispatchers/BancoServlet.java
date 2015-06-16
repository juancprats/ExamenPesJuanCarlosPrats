package es.examenPes.dispatchers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.examenPes.controler.ejb.AmpliarCupoControllerEjb;
import es.examenPes.controler.ejb.BloquearTarjetaControllerEjb;
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
		
		case "ListaTodo": 
			ListarTodoControlerEjb todos = new ListarTodoControlerEjb();
			ArrayList<TarjetaCredito> tarjeta = todos.listarTodos();
			request.setAttribute("tarjetas", tarjeta);
			rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
			titulo = "Listado general de tarjetas";
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);			
			break;
		
		 // se invoca al controlador adecuado
			// se redirige a otra pagina
			/*ListarTodoControllerEjb todos1 = new ListarTodoControllerEjb();
			ArrayList<Cliente> clientes1 = todos1.listarTodos();
			request.setAttribute("clientes", clientes1);
			rd = request.getRequestDispatcher("/jsp/ListarTodo2.jsp");
			titulo = "Listado general de clientes";
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);			
			break;*/
		case "ampliarCupo":
			TarjetaCredito actualizado = new TarjetaCredito();
			actualizado.setId(Integer.parseInt(request.getParameter("id")));
			actualizado.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo"))); 
			int aumento = Integer.parseInt(request.getParameter("aumento"));
			
			AmpliarCupoControllerEjb controladorAumentar = new AmpliarCupoControllerEjb();
			TarjetaCredito result = controladorAumentar.aumentacupo(actualizado,aumento);
			request.setAttribute("tarjetas", result);
			rd = request.getRequestDispatcher("/jsp/ListarTodo2.jsp");
			
			rd.forward(request, response);
			
			break;
			
		case "bloquearTarjeta": 
			ListarTodoControlerEjb todo = new ListarTodoControlerEjb();
			ArrayList<TarjetaCredito> tarj = todo.listarTodos();
			request.setAttribute("tarjetas", tarj);
			rd = request.getRequestDispatcher("/jsp/ListaTodoBloqueo.jsp");
			titulo = "Listado general de tarjetas";
			request.setAttribute("titulo", titulo);
			rd.forward(request, response);			
			break;
			
		case "altaTarjeta": // se invoca al controlador adecuado
			
			
			rd = request.getRequestDispatcher("/jsp/altaTarjeta.jsp");
			rd.forward(request, response);

			break;
		
		case "buscarPorId":
			int id = Integer.parseInt(request.getParameter("id"));
			BuscarPorIdControlerEjb controladorBusqueda = new BuscarPorIdControlerEjb();
			TarjetaCredito resultado =  controladorBusqueda.buscarPorId(id);
			request.setAttribute("tarjetas", resultado);
			rd = request.getRequestDispatcher("/jsp/ListarTodo2.jsp");
			request.setAttribute("titulo", "Búsqueda por: " + id);
			rd.forward(request, response);
			break;
			
		case "buscarParaAmpliar":
			TarjetaCredito resultado1 = new TarjetaCredito();
			resultado1.setId( Integer.parseInt(request.getParameter("id"))); 
			resultado1.setNumero(request.getParameter("numero"));
			resultado1.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
			resultado1.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
			resultado1.setTipo(request.getParameter("tipo"));
					
			request.setAttribute("tarjetas", resultado1);
			rd = request.getRequestDispatcher("/jsp/ListarTodo2.jsp");
			
			rd.forward(request, response);
			break;
			
		case "buscarParaBloquear":
			TarjetaCredito resulbloqueo = new TarjetaCredito();
			resulbloqueo.setId( Integer.parseInt(request.getParameter("id"))); 
			resulbloqueo.setNumero(request.getParameter("numero"));
			resulbloqueo.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
			resulbloqueo.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
			resulbloqueo.setTipo(request.getParameter("tipo"));
			resulbloqueo.setContrasenha(request.getParameter("contrasenha"));
			resulbloqueo.setNumComprobacion(request.getParameter("numComprobacion"));
			resulbloqueo.setTipo(request.getParameter("bloqueada"));
					
			request.setAttribute("tarjetas", resulbloqueo);
			rd = request.getRequestDispatcher("/jsp/ListarTodoBloqueo2.jsp");
			
			rd.forward(request, response);
			break;
			
		case "bloqueo":
			TarjetaCredito actualizadobloqueo = new TarjetaCredito();
			actualizadobloqueo.setId(Integer.parseInt(request.getParameter("id")));
			actualizadobloqueo.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
			actualizadobloqueo.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
			actualizadobloqueo.setContrasenha(request.getParameter("contrasenha"));
			actualizadobloqueo.setNumComprobacion(request.getParameter("numComprobacion"));
			actualizadobloqueo.setNumero(request.getParameter("numero"));
			actualizadobloqueo.setTipo(request.getParameter("tipo"));
			actualizadobloqueo.setTipo(request.getParameter("bloqueada"));		
			BloquearTarjetaControllerEjb controladorbloquear = new BloquearTarjetaControllerEjb();
			TarjetaCredito resultbloqueo = controladorbloquear.bloqueada(actualizadobloqueo);
			request.setAttribute("tarjetas", resultbloqueo);
			rd = request.getRequestDispatcher("/jsp/ListarTodoBloqueo3.jsp");		
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
		TarjetaCredito resultado =  controladorBusqueda.buscarPorId(id);
		request.setAttribute("id", resultado);
		rd = request.getRequestDispatcher("/jsp/ListarTodo.jsp");
		request.setAttribute("titulo", "Búsqueda por: " + id);
		rd.forward(request, response);
		break;
		
	
		
		
	case "buscarParaAmpliar":
		TarjetaCredito resultado1 = new TarjetaCredito();
		resultado1.setId( Integer.parseInt(request.getParameter("id"))); 
		resultado1.setNumero(request.getParameter("numero"));
		resultado1.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
		resultado1.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
		resultado1.setTipo(request.getParameter("tipo"));
		resultado1.setContrasenha("contrasenha");
		resultado1.setNumComprobacion("numComprobacion");		
		request.setAttribute("tarjetas", resultado1);
		rd = request.getRequestDispatcher("/jsp/ListarTodo2.jsp");
		
		rd.forward(request, response);
		break;
		
		
		
	case "ampliarCupo":
		TarjetaCredito actualizado = new TarjetaCredito();
		actualizado.setId(Integer.parseInt(request.getParameter("id")));
		actualizado.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
		actualizado.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
		actualizado.setContrasenha("contrasenha");
		actualizado.setNumComprobacion("numComprobacion");
		actualizado.setNumero("numero");
		actualizado.setTipo("tipo");
		int aumento = Integer.parseInt(request.getParameter("aumento"));		
		AmpliarCupoControllerEjb controladorAumentar = new AmpliarCupoControllerEjb();
		TarjetaCredito result = controladorAumentar.aumentacupo(actualizado,aumento);
		request.setAttribute("tarjetas", result);
		rd = request.getRequestDispatcher("/jsp/ListarTodo3.jsp");		
		rd.forward(request, response);		
		break;
		
		
	case "bloqueo":
		TarjetaCredito actualizadobloqueo = new TarjetaCredito();
		actualizadobloqueo.setId(Integer.parseInt(request.getParameter("id")));
		actualizadobloqueo.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
		actualizadobloqueo.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
		actualizadobloqueo.setContrasenha(request.getParameter("contrasenha"));
		actualizadobloqueo.setNumComprobacion(request.getParameter("numComprobacion"));
		actualizadobloqueo.setNumero(request.getParameter("numero"));
		actualizadobloqueo.setTipo(request.getParameter("tipo"));
		actualizadobloqueo.setTipo(request.getParameter("bloqueada"));		
		BloquearTarjetaControllerEjb controladorbloquear = new BloquearTarjetaControllerEjb();
		TarjetaCredito resultbloqueo = controladorbloquear.bloqueada(actualizadobloqueo);
		request.setAttribute("tarjetas", resultbloqueo);
		rd = request.getRequestDispatcher("/jsp/ListarTodoBloqueo3.jsp");		
		rd.forward(request, response);		
		break;
		
	case "buscarParaBloquear":
		TarjetaCredito resulbloqueo = new TarjetaCredito();
		resulbloqueo.setId( Integer.parseInt(request.getParameter("id"))); 
		resulbloqueo.setNumero(request.getParameter("numero"));
		resulbloqueo.setCupoMaximo(Integer.parseInt(request.getParameter("cupoMaximo")));
		resulbloqueo.setCupoDisponible(Integer.parseInt(request.getParameter("cupoDisponible")));
		resulbloqueo.setTipo(request.getParameter("tipo"));
		resulbloqueo.setContrasenha("contrasenha");
		resulbloqueo.setNumComprobacion("numComprobacion");
		resulbloqueo.setTipo(request.getParameter("bloqueada"));
				
		request.setAttribute("tarjetas", resulbloqueo);
		rd = request.getRequestDispatcher("/jsp/ListarTodoBloqueo2.jsp");
		
		rd.forward(request, response);
		break;

		
	}
	}

}
