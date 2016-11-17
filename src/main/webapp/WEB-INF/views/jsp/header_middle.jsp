<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

		<div class="header-middle"><!--header-middle-->
			
			<div style=" width:90%; padding:1px 10px; float:right;" class="container">
				<div class="row" style=" width:97%;">
				<div style=" width:9%; float:left;" class="col-sm-4">
							<div class="logo pull-left">
							<a href="index.html"><img alt="" src="resources/images/home/logo.png"></a>
						</div>
					</div>
				
				<div class="col-sm-3" style="float:left; width:30%;">
					<form action="listProduitByMc.html" name="rechercheForm" method="get">
				
						<div class="search_box pull-right" style=" padding:1px 12px; margin-bottom:20px; width:90%; float:left; ">
							<input type="text" name="mc" placeholder="rechercher" style="width:540px"/>
						</div>
						</form>
					</div>
					
					
					
					
					<div style="width:60%; float:right;" class="col-sm-8">
						<div class="shop-menu pull-right">
							<ul class="nav navbar-nav">
								<li><a href="panier.html"><i class="fa fa-shopping-cart"></i>Panier</a></li>
							<c:if test="${utilisateur.idUtilisateur>0}">
								<c:if test="${utilisateur.typeUser=='FOURNISSEUR'}">
									<li><a href="fournisseur.html"><i class="fa fa-user"></i> ${utilisateur.nomUtilisateur} ${utilisateur.prenomUtilisateur}</a></li>
								</c:if>
								<c:if test="${utilisateur.typeUser=='CLIENT'}">
									<li><a href="Profilclient.html"><i class="fa fa-user"></i> ${utilisateur.nomUtilisateur} ${utilisateur.prenomUtilisateur}</a></li>
								</c:if>
								<li><a href="logout.html" class="active"><i class="fa fa-lock"></i> Déconnexion</a></li>
							</c:if>
							<c:if test="${empty utilisateur || utilisateur.idUtilisateur==0}">
									<li><a href="affLogin.html" class="active"><i class="fa fa-lock"></i> Login</a></li>
								</c:if>
							</ul>
						</div>
					</div>
					
				</div>
			</div>
		</div><!--/header-middle-->
			<script type="text/javascript">
		
		function rechercheProduit()
{
			document.forms["rechercheForm"].elements[""].value;
	        document.forms["rechercheForm"].submit();
			
			
			}<!--

//-->
</script>