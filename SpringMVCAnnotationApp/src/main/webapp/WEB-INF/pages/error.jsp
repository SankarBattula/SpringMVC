<html>
<body bgcolor="pink">
	<center>
		<h1>Spring MVC Greeting Application</h1>
		<hr>
		Message : <%= request.getAttribute("greetingMsg") %><br/>
		Message : ${greetingMsg}
	</center>
</body>
</html>