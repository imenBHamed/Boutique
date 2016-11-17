<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Core CSS - Include with every page -->
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<title>Arti_Tunisie</title>
<link
	href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/assets/css/font-awesome.min.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/assets/css/prettyPhoto.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/assets/css/price-range.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/assets/css/animate.css"
	rel="stylesheet" />
<link href="<%=request.getContextPath()%>/resources/assets/css/main.css"
	rel="stylesheet" />
<link
	href="<%=request.getContextPath()%>/resources/assets/css/responsive.css"
	rel="stylesheet" />
<body>

	<header id="header">

		<%@include file="header_top.jsp"%>
	</header>


	<section>
		<div class="container">

			<%@ include file="header_client.jsp"%>

			<div class="row">

				<div class="col-sm-9 padding-right">
					<div class="features_items">
						<!--features_items-->
						<h2 class="title text-center">Nos Articles</h2>
						<c:forEach items="${produits}" var="prod">
							<div class="col-sm-4">
								<div class="product-image-wrapper">
									<div class="single-products">
										<div class="productinfo text-center">
											<img alt="hh" src="data:image/jpeg;base64,${prod.image}" />
											<h2>${prod.prix}$</h2>
											<p>${prod.nomProduit}</p>
											<p>${prod.taille}</p>
											<a class="btn btn-default add-to-cart"
												onclick="window.location.href='detailProduit.html?id=${prod.idProduit}'">Detail Produit</a>
										</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<!--features_items-->
				</div>

			</div>

		</div>

	</section>
	 
 </body>
</html>