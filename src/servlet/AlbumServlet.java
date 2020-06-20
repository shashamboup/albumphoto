package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Album;
import dao.AlbumDao;

/**
 * Servlet implementation class AlbumServlet
 */
@WebServlet({ "/ajouterAlbum", "/modifierAlbum", "/supprimerAlbum", "/ajouterPhoto", "/supprimerPhoto" })
public class AlbumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_SUPPRIMER_PHOTO = "/WEB-INF/AjouterAlbum.jsp";
	private static final String VUE_AJOUTER_PHOTO = null;
	private static final String VUE_SUPPRIMER_ALBUM = null;
	private static final String VUE_MODIFIER_ALBUM = null;
	private static final String VUE_AJOUTER_ALBUM = "/WEB-INF/AjouterAlbum.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlbumServlet() {
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

		if (requestedUrl.equals("/ajouterAlbum")) {
			getServletContext().getRequestDispatcher(VUE_AJOUTER_ALBUM).forward(request, response);
		}

		if (requestedUrl.equals("/modifierAlbum")) {

			getServletContext().getRequestDispatcher(VUE_MODIFIER_ALBUM).forward(request, response);
		}

		if (requestedUrl.equals("/supprimerAlbum")) {
			getServletContext().getRequestDispatcher(VUE_SUPPRIMER_ALBUM).forward(request, response);
		}
		if (requestedUrl.equals("/ajouterPhoto")) {

			getServletContext().getRequestDispatcher(VUE_AJOUTER_PHOTO).forward(request, response);
		}
		if (requestedUrl.equals("/supprimerPhoto")) {

			getServletContext().getRequestDispatcher(VUE_SUPPRIMER_PHOTO).forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * 
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestedUrl = request.getServletPath();
		String titre = request.getParameter("nomalbum");
		String dateCreation = request.getParameter("datecreation");
		String categorie = request.getParameter("categorie");
		String type = request.getParameter("type");
		String proprietaire = request.getParameter("proprietaire");

		if (requestedUrl.equals("/ajouterAlbum")) {
			Album album = new Album(titre, dateCreation, categorie, type, proprietaire);
			request.setAttribute("album",album);
			AlbumDao.createAlbum(album);
		}
	}
}