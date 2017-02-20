//Check's user's unique login Ajax request
$(document).ready(function() {
	$('#loginInput').blur(function(event) {
		var loginToCheck = $('#loginInput').val();

		if (loginToCheck != "") {

			$.get('CheckNewLoginExistenceController', {
				login : loginToCheck
			}, function(responseText) {

				if (responseText != "empty") {

					$('#loginInput').val('');
					$("#loginInput").attr("placeholder", responseText);

				} else {
					$('#loginInput').removeAttr("placeholder");
				}
			});

		}
	});
});

$.ajax({
	data : data,
	success : success,
	dataType : text
});
