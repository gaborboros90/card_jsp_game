<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
        <div class="home-page">
            <h1 class="page-title">SZTE FIFA card game</h1>
            <div class="form-container">
                <img src="images/banner-image.png" width="272" height="205" class="banner-image"  alt="hero image. FIFA logo" />
                <p class="error-message">Invalid username! Should be min 4 character and max 10 character long! Should not contain spaces in text!</p>
                <form method="post" action="init-game" id="start-game-form">
                	<div>
                		<p>Username</p> 
                    	<input class="username" type="text" name="username" id="username" />
                    	<input class="submit-button" type="submit" name="submit-username" value="Let's play" />
                	</div>
                </form>
            </div>
        </div>
    </div>
    <script src="scripts/external-libs/jquery-3.1.1.js" type="text/javascript"></script>
	<script src="scripts/username-validator.js" type="text/javascript"></script>
</body>
</html>