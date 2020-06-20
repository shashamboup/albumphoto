package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.Utilistateur;
import dao.AdministrateurDao;

/**
 * Servlet implementation class administrateur
 */
@WebServlet({ "/viewUser", "/adduser", "/deleteuser", "/updateuser", "/acceuil", "/connexion", "/administrer",
		"/addadmin" })
public class administrateur extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String VUE_AJOUTER_UTILISATAEUR = "/WEB-INF/AjouterUtilisateur.jsp";

	private static final String VUE_UPDATE_UTILISATEUR = "/WEB-INF/ModifierUtilisateur.jsp";

	private static final String VUE_LIST_UTILISATEURS = "/WEB-INF/ListerUtilisateur.jsp";

	private static final String VUE_ACCEUIL = "/WEB-INF/Index.jsp";

	private static final String VUE_SE_CONNECTER = "/WEB-INF/Connexion.jsp";

	private static final String VUE_ADMINISTRATUER = "/WEB-INF/VueAdministrateur.jsp";

	private static final String VUE_UTILISATEUR = "/WEB-INF/VueUtilisateur.jsp";

	private static final String VUE_AJOUTER_ADMINISTRATEUR = "/WEB-INF/AjouterAdministrateur.jsp";

	private ArrayList<Utilistateur> utilisateurs = new ArrayList<Utilistateur>();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public administrateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedUrl = request.getServletPath();

		if (requestedUrl.equals("/acceuil")) {
			getServletContext().getRequestDispatcher(VUE_ACCEUIL).forward(request, response);
		}

		if (requestedUrl.equals("/connexion")) {

			getServletContext().getRequestDispatcher(VUE_SE_CONNECTER).forward(request, response);
		}

		if (requestedUrl.equals("/adduser")) {
			getServletContext().getRequestDispatcher(VUE_AJOUTER_UTILISATAEUR).forward(request, response);
		}

		if (requestedUrl.equals("/addadmin")) {
			getServletContext().getRequestDispatcher(VUE_AJOUTER_ADMINISTRATEUR).forward(request, response);
		}

		if (requestedUrl.equals("/updateuser")) {
			String login = (request.getParameter("login"));
			String password = (request.getParameter("password"));
			Utilistateur utilisateur = AdministrateurDao.getUtilisateurBySession(login, password);
			if (utilisateur != null) {
				request.setAttribute("utilisateurs", utilisateur);
				getServletContext().getRequestDispatcher(VUE_UPDATE_UTILISATEUR).forward(request, response);
			}

		}

		if (requestedUrl.equals("/viewUser")) {
			request.setAttribute("utilisateurs", AdministrateurDao.readutilisateur());
			getServletContext().getRequestDispatcher(VUE_LIST_UTILISATEURS).forward(request, response);
		}
		if (requestedUrl.equals("/administrer")) {
			getServletContext().getRequestDispatcher(VUE_ADMINISTRATUER).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String privilege = request.getParameter("privilege");

		// int idutilisateur = Integer.parseInt(request.getParameter("id"));

		String requestedUrl = request.getServletPath();

		if (requestedUrl.equals("/connexion")) {

			Utilistateur utilistateur = AdministrateurDao.getUtilisateurBySession(login, password);

			if (utilistateur != null) {
				HttpSession session = request.getSession();
				session.setAttribute("utilisateur", utilistateur);
				if (utilistateur.getLogin().equalsIgnoreCase("admin")
						&& utilistateur.getPassword().equalsIgnoreCase("admin"))
					getServletContext().getRequestDispatcher(VUE_ADMINISTRATUER).forward(request, response);
				if (utilistateur.getPrivilege().equalsIgnoreCase("admin"))
					getServletContext().getRequestDispatcher(VUE_ADMINISTRATUER).forward(request, response);
				else
					getServletContext().getRequestDispatcher(VUE_UTILISATEUR).forward(request, response);

			} else {

				getServletContext().getRequestDispatcher(VUE_SE_CONNECTER).forward(request, response);

			}

		}
		if (requestedUrl.equals("/adduser")) {
			Utilistateur utilisateur = new Utilistateur(nom, prenom, login, password, privilege);
			request.setAttribute("utilisateur", utilisateur);
			AdministrateurDao.createUtilistateur(utilisateur);
		}
		if (requestedUrl.equals("/updateuser")) {
			for (Utilistateur utilisateur : utilisateurs) {
				if (utilisateur.getLogin() == login) {
					utilisateur.setNom(nom);
					utilisateur.setPrenom(prenom);
					utilisateur.setLogin(login);
					utilisateur.setPassword(password);
					utilisateur.setPrivilege(privilege);
					break;
				}
			}
		}
		response.sendRedirect(request.getContextPath() +  "/acceuil");
	}
}