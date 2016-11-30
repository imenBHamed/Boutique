<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Arti_Tunisie</title>
   <link href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets/css/font-awesome.min.css" rel="stylesheet" />
    <link href="<%=request.getContextPath()%>/resources/assets/css/prettyPhoto.css" rel="stylesheet" />
   <link href="<%=request.getContextPath()%>/resources/assets/css/price-range.css" rel="stylesheet" />
      <link href="<%=request.getContextPath()%>/resources/assets/css/animate.css" rel="stylesheet" />
           <link href="<%=request.getContextPath()%>/resources/assets/css/main.css" rel="stylesheet" />
   <link
	href="<%=request.getContextPath()%>/resources/assets/css/responsive.css"
	rel="stylesheet" />
  
<!--/head-->

<body>
	<header id="header">
		<!--header-->

		<%@include file="header_top.jsp"%>

	</header>
	<!--/header-->

	<section>
		<div class="container">
	<%@ include file="header_client.jsp"%>
			<div class="row">


				<div class="col-sm-9 padding-right">
					<div class="product-details">
						<!--product-details-->
						<div class="col-sm-5">
							<div class="view-product">
								<img src="data:image/jpeg;base64,${produit.image}" alt="" />
							</div>
						</div>
						<div class="col-sm-7">
							<div class="product-information">
								<!--/product-information-->
								<img src="" class="newarrival" alt="" />
								<h2>${produit.nomProduit}</h2>
								<!--  <p>ID: 1089772</p>-->
								<f:form action="addPanier.html" method="get">
									<input type="hidden" name="id" value="${produit.idProduit}">
									<span> <span>${produit.prix} $</span> <label>Quantité:</label>


										<input type="text" name="qte" id="qte" value="1" />


										<button id="ajouter_au_panier" type="submit" class="btn btn-fefault cart">
											<i class="fa fa-shopping-cart"></i> ajouter au panier
										</button>

									</span>
								</f:form>
								<c:if test="${produit.quantite>0}">
									<p>
										<b>disponibilité:</b> en Stock
									</p>
								</c:if>
								<c:if test="${produit.quantite==0}">
									<p>
										<b>disponibilité:</b> Hors Stock
									</p>
								</c:if>
							 


							</div>
							<!--/product-information-->
						</div>
					</div>
					<!--/product-details-->

				</div>
			</div>
		</div>
	</section>


	 
</body>
</html>