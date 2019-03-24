<%-- 
    Document   : dashboard
    Created on : 15/02/2019, 10:30:44 AM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Dashboard</title>
        <%@ include file="shared/header.jsp" %>
    </head>
    <body>
        <!-- Navbar -->
        <%@ include file="shared/navbar.jsp" %>

        <div class="container animated fadeIn delay-10ms">
            <div class="row ">
                <div class="col-12">
                    <h2>Instituto</h2>
                    <hr>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card border-info mb-3" style="max-width: 20rem;">
                        <div class="card-header"> </div>
                        <div class="card-body">
                          <h4 class="card-title">Alumno</h4>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="mostrarAlumnos.jsp" class="btn btn-lg btn-outline-info btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12 ">
                    <div class="card border-warning mb-3" style="max-width: 20rem;">
                        <div class="card-header"></div>
                        <div class="card-body">
                          <h4 class="card-title">Carrera</h4>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="mostrarCarreras.jsp" class="btn btn-lg btn-outline-warning btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card border-success mb-3" style="max-width: 20rem;">
                        <div class="card-header"></div>
                        <div class="card-body">
                          <h4 class="card-title">Datos</h4>
                          <p class="card-text">Puedes ver relación de alumnos por carrera.</p>
                          <a href="datos.jsp" class="btn btn-lg btn-outline-success btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row ">
                <div class="col-12">
                    <h2>Tienda</h2>
                    <hr>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card border-info mb-3" style="max-width: 20rem;">
                        <div class="card-header"> </div>
                        <div class="card-body">
                          <h4 class="card-title">Categoría</h4>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="mostrarCategorias.jsp" class="btn btn-lg btn-outline-info btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card border-warning mb-3" style="max-width: 20rem;">
                        <div class="card-header"></div>
                        <div class="card-body">
                          <h4 class="card-title">Articulo</h4>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                          <a href="mostrarArticulos.jsp" class="btn btn-lg btn-outline-warning btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <%@ include file="shared/footer.jsp" %>
    </body>
</html>
