<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.11.3/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/v/bs5/jq-3.6.0/dt-1.11.3/datatables.min.js"></script>
<script type="text/javascript" src="assets/javascripts/libros.js"></script>
</head>
<body>
	<main class="container">
		<div class="bg-light p-5 rounded">
			<h1>Estos son los libros de la Tierra Media</h1>
			<p>
				Libros del usuario:
				<c:out value="${user}"></c:out>
			</p>
			
		</div>
		<table class="table table-stripped table-hover libros">
			<thead>
				<tr>
					<th>Titulo</th>
					<th>Autor</th>
					<th>Editorial</th>
					<th>Genero</th>
					<th>Paginas</th>
					<th>Botones</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${libros}" var="libro">
				<!-- items seria la coleccion y var cadalibro -->
				<tr>
				<td><c:out value= "${libro.titulo }"></c:out></td>
				<td><c:out value= "${libro.autor }"></c:out></td>
				<td><c:out value= "${libro.editorial }"></c:out></td>
				<td><c:out value= "${libro.genero }"></c:out></td>
				<td><c:out value= "${libro.paginas }"></c:out></td>
				<!-- hacemos esto para que no pueda comprar --><!-- es como un if -->
				<td><c:choose> 
				<c:when test="${libro.paginas>15 }">
				<a href="#" class="btn btn-primary">Ver</a>
				</c:when>
				<c:otherwise>
				<a href="#" class="btn btn-primary disabled">Ver</a>
				</c:otherwise>
				</c:choose></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>	
</body>
</html>