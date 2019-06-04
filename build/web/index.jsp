<%-- 
    Document   : index
    Created on : 16/02/2019, 11:05:59 AM
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
                    <h2>Ejercicios</h2>
                    <hr>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card card-hover border-info mb-3" style="max-width: 20rem;">
                        <div class="card-header"> </div>
                        <div class="card-body">
                          <h4 class="card-title">Quicksort</h4>
                          <p class="card-text">Algoritmo de ordenamiento.</p>
                          <a href="quicksort" class="btn btn-lg btn-outline-info btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12 ">
                    <div class="card card-hover border-warning mb-3" style="max-width: 20rem;">
                        <div class="card-header"></div>
                        <div class="card-body">
                          <h4 class="card-title">Gráfica</h4>
                          <p class="card-text">Datos random y gráfica de los datos.</p>
                          <a href="grafica" class="btn btn-lg btn-outline-warning btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card card-hover border-success mb-3" style="max-width: 20rem;">
                        <div class="card-header"></div>
                        <div class="card-body">
                          <h4 class="card-title">Tipos de datos</h4>
                          <p class="card-text">Enteros, flotante, cadena bits y gray.</p>
                          <a href="tiposDatos" class="btn btn-lg btn-outline-success btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row ">
                <div class="col-12">
                    <h2>Técnicas</h2>
                    <hr>
                </div>
                <div class="col-md-4 col-xs-12">
                    <div class="card card-hover border-info mb-3" style="max-width: 20rem;">
                        <div class="card-header"> </div>
                        <div class="card-body">
                          <h4 class="card-title">Algoritmos Genéticos</h4>
                          <p class="card-text">Aplicar un Algoritmo Genético sobre una población: Selección, Cruza y Mutación.</p>
                          <a href="algoritmosGeneticos" class="btn btn-lg btn-outline-info btn-block">Revisar</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- footer -->
        <%@ include file="shared/footer.jsp" %>
    </body>
</html>