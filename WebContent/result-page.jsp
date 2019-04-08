<%@page import="java.util.concurrent.TimeUnit"%>
<%@page import="model.data.Player"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	Player player = new Player();
    	Player computer = new Player();
    
    	if(session.getAttribute("gameSession") == null) {
    		response.sendRedirect("index.jsp");
    	}
    	else {
    		player = ((ArrayList<Player>)session.getAttribute("gameSession")).get(0);
    		computer = ((ArrayList<Player>)session.getAttribute("gameSession")).get(1);
    	}
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <title>SZTE FIFA card game - Deák Kristóf</title>
    <link rel="stylesheet" type="text/css" href="styles/custom-fonts.css" />
    <link rel="stylesheet" type="text/css" href="styles/page-style.css" />
</head>
<body>
<div class="main-container">
    <div class="result-page">
        <h1 class="page-title">Result of the game</h1>
        <div class="result-container">
            <div class="result player-result-container">
                <img src="images/player.png" alt="player" height="107" width="156" />
                <h2><%=player.getName()%></h2>
                <h3><strong><%=player.getScore()%></strong> point(s)</h3>
            </div>
            <div class="result computer-result-container">
                <img src="images/enemy.png" alt="player" height="107" width="107" />
                <h2><%=computer.getName()%></h2>
                <h3><strong><%=computer.getScore()%></strong> point(s)</h3>
            </div>
            <div class="game-time-container"><h3>Game time: <span class="game-time-value">
            	<%
            		Date startDate = (Date)session.getAttribute("gameStartDate");
            		Date endDate = new Date();
            		
            		long duration  = endDate.getTime() - startDate.getTime();

            		
            		out.print(TimeUnit.MILLISECONDS.toSeconds(duration));        
            	%>
            </span> seconds</h3></div>
            <div class="new-game-button"><a href="index.jsp">New game</a></div>
        </div>
    </div>
    <% session.invalidate(); %>
</div>
</body>
</html>