package exam_hibernate.servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exam_hibernate.models.Car;
import exam_hibernate.models.Color;
import exam_hibernate.services.CarService;
import exam_hibernate.services.ColorService;

/**
 * Servlet implementation class DashboardServlets
 */
public class DashboardServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CarService cs;
	private ColorService cls;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DashboardServlets() {
		super();
		this.cs = new CarService();
		this.cls = new ColorService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("marques", cs.getInfoMarques());
		request.setAttribute("count", cs.getCountCar());

		// récupérer la liste de couleurs
		List<Color> colors = cls.getAll();
		List<String> infoCouleurs = Collections.emptyList();
		request.setAttribute("lastAdded", cs.get10LastAdded());

		request.setAttribute("colors", infoCouleurs);

		request.getRequestDispatcher("result_page.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
