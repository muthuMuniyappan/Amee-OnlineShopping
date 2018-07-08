<div class="container">

	<!-- Breadcrumb -->
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">

				<li><a href="${contextRoot}/home"> Home </a></li>
				<li><a href="${contextRoot}/show/all/products"> Products </a></li>
				<li class="active">${product.name}</li>

			</ol>

		</div>

	</div>

	<div class="row">
		<!--  To display the Product Image -->
		<div class="col-xs-12 col-sm-4">
			<div class="thumbnail">

				<img src="${images}/${product.code}.jpg" class="img img-responsive" />

			</div>

		</div>

		<!-- To display a Product Description -->
		<div class="col-xs-12 col-sm-8">

			<h3>${product.name}</h3>
			<hr />

			<p>${product.description}</p>
			<hr />

			<h4>
				Price: <strong>&#8377; ${product.unitPrice} /-</strong>
			</h4>
			<hr />
		

			<c:choose>

				<c:when test="${product.quantity < 1}">

					<h5>
						Qty. Available: <span style="color:red"> &#160; Out of Stock</span>
					</h5>

				</c:when>
				<c:otherwise>

					<h5>Qty. Available: ${product.quantity}</h5>

				</c:otherwise>

			</c:choose>
				<br>


			<c:choose>

				<c:when test="${product.quantity < 1}">

					<a href="javascript:void(0)"
				class="btn btn-success disabled"> <strike> <span
				class="glyphicon glyphicon-shopping-cart"> </span> Add to Cart </strike> </a>

				</c:when>
				<c:otherwise>

					<a href="${contextRoot}/cart/add/${product.id}/product"
				class="btn btn-success"> <span
				class="glyphicon glyphicon-shopping-cart"> </span> Add to Cart	</a>

				</c:otherwise>

			</c:choose>


			
				
				<a href="${contextRoot}/show/all/products" class="btn btn-primary">
				Back </a>


		</div>

	</div>


</div>