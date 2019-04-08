$(function() {
	$('#start-game-form').on('submit', function(event) {
		if(!isValidUsername()) {
			updateUI();
			event.preventDefault();
		}
	});
	
	function isValidUsername() {
		var username = $('.form-container .username').val().trim();
		
		return username.length >= 4 && username.length <= 10 && username.indexOf(' ') === -1;
	}
	
	function updateUI() {
		$('.error-message').show();
	}
});