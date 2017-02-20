//Check user's password and password's retype

$(document).ready(function() {

	$('#userRepeatPassword').blur(function(event) {

		

		 var valueRepeatPassword = $('#userRepeatPassword').val();
		var valuePassword = $("#userPassword").val();

		if (valuePassword !== valueRepeatPassword) {

			$('#userRepeatPassword').val('');
			$("#userRepeatPassword").attr("placeholder", "Passwords don't match!");
			$("#userPassword").val('');

		} else {
			$('#userRepeatPassword').removeAttr("placeholder");
		}

	});
	
	 $('#userRepeatPassword').keypress(function(event){
	 $('#userRepeatPassword').removeAttr("placeholder");
	 });
});