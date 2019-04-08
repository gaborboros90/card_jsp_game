package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import model.data.Player;
import model.data.ResponeObject;
import workflow.GameSimulator;

/**
 * Servlet implementation class GamePlayServlet
 */
@WebServlet("/game-play")
public class GamePlayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GamePlayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String cardName = request.getParameter("cardName");
		HttpSession session = request.getSession();
		
		if(session.getAttribute("gameSession") == null) {
			response.sendRedirect("index.jsp");
		}
		
		GameSimulator gameSimulator = new GameSimulator((ArrayList<Player>)session.getAttribute("gameSession"), cardName, category);
		gameSimulator.simulate();
		session.setAttribute("gameSession", gameSimulator.getPlayers());
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/json");
		
		ResponeObject responseObject = new ResponeObject(gameSimulator.getComputersCard(), gameSimulator.getPlayers().get(1).getScore(), gameSimulator.getPlayers().get(0).getScore(), gameSimulator.getWinner(), gameSimulator.isGameEnded());
		Gson gson = new Gson();
		
		out.print(gson.toJson(responseObject));
	}
}
