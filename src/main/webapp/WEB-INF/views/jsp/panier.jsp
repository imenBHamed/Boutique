<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Arti_Tunisie</title>
    <link href="<%=request.getContextPath()%>/resources/assets/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets/css/font-awesome.min.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets/css/prettyPhoto.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets/css/price-range.css" rel="stylesheet">
    <link href="<%=request.getContextPath()%>/resources/assets/css/animate.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/assets/css/main.css" rel="stylesheet">
	<link href="<%=request.getContextPath()%>/resources/assets/css/responsive.css" rel="stylesheet">
 
</head><!--/head-->

<body>
	<header id="header"><!--header-->
	
		<%@include file="header_top.jsp" %>
		
	
		
	</header><!--/header-->
	<%@ include file="header_client.jsp"%>

	<section id="cart_items">
		<div class="container">
			<div class="table-responsive cart_info">
				<table class="table table-condensed">
					<thead>
						<tr class="cart_menu">
							<td class="image">Article</td>
							<td class="description"></td>
							<td class="price">Prix</td>
							<td class="quantity">Quantité</td>
							<td class="total">Total</td>
							<td></td>
						</tr>
					</thead>
					<tbody>
					
					<c:forEach items="${panier.items}" var="item">
						<tr>
							<td class="cart_product">
								<a href=""><img src="data:image/jpeg;base64,${item.image}" style="width:100" alt=""></a>
							</td>
							<td class="cart_description" style="width: 400px">
								<h4><a href="">${item.nomProduit}</a></h4>
								<p>${item.description}</p>
							</td>
							<td class="cart_price">
								<p>${item.prix} DT</p>
							</td>
							<td class="cart_quantity">
								<div class="cart_quantity_button">
									 
									<input disabled class="cart_quantity_input" type="text" name="quantity" value="${item.quantitePanier}" autocomplete="off" size="2">
								 
								</div>
							</td>
							<td class="cart_total">
								<p class="cart_total_price">${item.prixTotal} $</p>
							</td>
						
						</tr>
					</c:forEach>
						
					</tbody>
				</table>
			</div>
		</div>
	</section> <!--/#cart_items-->

	<section id="do_action">
		<div class="container">
				<div class="row">
				<div class="col-sm-6">
				</div>
				<div class="col-sm-6">
					<div class="total_area">
						<ul>
							<li>TOTAL TVQ : <span>${panier.totalTVQ} $</span>  </li>
							 
							<li>TOTAL TPS : <span>${panier.totalTPS} $</span>  </li>
							<li>TOTAL : <span>${panier.total} $</span>  </li>
						</ul>
 					</div>
				</div>
			</div>
			</div>
		 
	</section><!--/#do_action-->
	
</body>
</html>