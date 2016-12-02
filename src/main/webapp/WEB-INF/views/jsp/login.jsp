<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<html>
<head>
<script
	type="<%=request.getContextPath()%>/resources/assets/js/calendrier.js"
	src="calendrier.js"></script>
<link rel="stylesheet" media="screen"
	type="<%=request.getContextPath()%>/resources/assets/css/design.css"
	title="Design" href="design.css" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link
	href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/assets/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/assets/css/prettyPhoto.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/assets/css/price-range.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/assets/css/animate.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/assets/css/main.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/assets/css/responsive.css"
	rel="stylesheet">

<link rel="shortcut icon" href="images/ico/favicon.ico">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="<%=request.getContextPath()%>/resources/assets/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="<%=request.getContextPath()%>/resources/assets/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="<%=request.getContextPath()%>/resources/assets/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="<%=request.getContextPath()%>/resources/assets/images/ico/apple-touch-icon-57-precomposed.png">
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">

</head>
<!--/head-->

<body>
	<header id="header">
		<!--header-->

		<%@include file="header_top.jsp"%>



	</header>
	<!--/header-->
	<%@ include file="header_client.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-sm-4 col-sm-offset-1">
				<div class="login-form">
					<!--login form-->
					<h2>
						<b>Connectez-vous à votre compte</b>
					</h2>
					<c:if test="${! empty errors}">
						<p>
							<font color="red"> ${errors}</font>
						</p>
					</c:if>
					<f:form cssClass="form-signin" action="connecter.html"
						method="post" modelAttribute="client">
						<input type="email" name="email_c" placeholder="Email" required />
						<input type="password" name="password_c"
							placeholder="Mot de passe" required />
						<button type="submit" class="btn btn-default">Login</button>
					</f:form>
				</div>
				<!--/login form-->
			</div>
			<div class="col-sm-1">
				<h2 class="or">OU</h2>
			</div>
			<div class="col-sm-4">
				<div class="signup-form">
					<!--sign up form-->
					<h2>
						<b>Inscription</b>
					</h2>
					<p>
						<font color="red">${errorsInscription}</font>
					</p>
					<p>
						<font color="red">${succes}</font>
					</p>
					<f:form cssClass="form-signin" action="inscription.html"
						method="post" modelAttribute="client">

						<br />
						<input type="text" name="nomClient" placeholder="Nom" required />
						<input type="text" name="prenomClient" placeholder="Prenom"
							required />
						<input type="email" name="email" placeholder="Email" required />
						<input type="password" name="password" placeholder="Mot de passe"
							required />
						<input type="text" name="tel" placeholder="Telephone" required />
						<input type="date" name="dateNaissance" id="datepicker"
							placeholder="date naissance">

						<button type="submit" title="valider" class="btn btn-default">Valider</button>
					</f:form>
				</div>
				<!--/sign up form-->
			</div>
		</div>
	</div>




	<script
		src="<%=request.getContextPath()%>/resources/assets/js/jquery.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/price-range.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/jquery.scrollUp.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/assets/js/jquery.prettyPhoto.js"></script>
	<script src="<%=request.getContextPath()%>/resources/assets/js/main.js"></script>
	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="http://code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
		Date.format = 'dd/MM/yyyy';
		$(function() {
			$("#datepicker").datepicker();
		});
	</script>
</body>
</html>