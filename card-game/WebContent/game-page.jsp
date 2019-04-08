<%@page import="model.data.CardData"%>
<%@page import="model.data.Player"%>
<%@page import="java.util.ArrayList"%>
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
<body class="body-game">
<div class="loading-indicator-container">
    <img src="images/svg-loading-spinner.svg" alt="Loading screen" /><br />
    <h2>Computer thinking...</h2>
</div>
<div class="main-container">
    <div class="game-page">    	
        <div class="game-container">
            <div class="info-container">
                <h2 class="page-title"></h2>
                <div class="result player-result-container">
                    <div class="card">
                        <h4 class="card-title">Player's card</h4>
                        <img src="images/unknown-card.png" alt="card-image" width="142" height="205" />
                        <table class="player-data">
                            <tr>
                                <td>Speed</td>
                                <td>n/a</td>
                            </tr>
                            <tr>
                                <td>Attack</td>
                                <td>n/a</td>
                            </tr>
                            <tr>
                                <td>Deffence</td>
                                <td>n/a</td>
                            </tr>
                            <tr>
                                <td>Shooting</td>
                                <td>n/a</td>
                            </tr>
                        </table>                      
                    </div>
                    <h2><% out.print(player.getName()); %>'s card</h2>
                    <h3><strong><% out.print(player.getScore()); %></strong> point(s)</h3>
                </div>
                <div class="result computer-result-container">
                    <div class="card">
                        <h4 class="card-title"><% out.print(computer.getName()); %>'s card</h4>
                        <img src="images/unknown-card.png" alt="card-image" width="142" height="205" />
                        <table class="player-data">
                            <tr>
                                <td>Speed</td>
                                <td class="speed">n/a</td>
                            </tr>
                            <tr>
                                <td>Attack</td>
                                <td class="attack">n/a</td>
                            </tr>
                            <tr>
                                <td>Deffence</td>
                                <td class="deffence">n/a</td>
                            </tr>
                            <tr>
                                <td>Shooting</td>
                                <td class="shooting">n/a</td>
                            </tr>
                        </table>                      
                    </div>
                    <h2>Computer's card</h2>
                    <h3><strong><% out.print(computer.getScore()); %></strong> point(s)</h3>
                </div>
                <h2 class="selected-category-info"></h2>
                <div class="do-action-button">Action</div>
                <div class="end-game-button"><a href="result-page.jsp">End game</a></div>
            </div>           
            <div class="cards-container">
            	<div class="disable-cards">Play next round</div>
            	<%
            		for(CardData card:player.getCardDeck()){                			                	
            	%>
                <div class="card">
                    <h4 class="card-title"><% out.print(card.getName()); %></h4>                     
                    <img src="images/<% out.print(card.getImageUrl()); %>" alt="card-image" width="142" height="205" />
                    <table class="player-data">
                        <tr>
                            <td>Speed</td>
                            <td><% out.print(card.getSpeed()); %></td>
                        </tr>
                        <tr>
                            <td>Attack</td>
                            <td><% out.print(card.getAttack()); %></td>
                        </tr>
                        <tr>
                            <td>Deffence</td>
                            <td><% out.print(card.getDeffence()); %></td>
                        </tr>
                        <tr>
                            <td>Shooting</td>
                            <td><% out.print(card.getShooting()); %></td>
                        </tr>
                    </table>
                    <div class="categories">
                        <ul>
                            <li>Speed</li>
                            <li>Attack</li>
                            <li>Deffence</li>
                            <li>Shooting</li>
                        </ul>
                    </div>
                </div>
                <% } %>                   
            </div>
        </div>
    </div>
</div>
<script src="scripts/external-libs/jquery-3.1.1.js" type="text/javascript"></script>
<script src="scripts/card-select.js" type="text/javascript"></script>
</body>
</html>