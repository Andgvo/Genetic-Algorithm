<%-- 
    Document   : navbar
    Created on : 16/02/2019, 09:34:55 AM
    Author     : andres
--%>
<%@page import="com.ipn.mx.geneticos.modelo.dto.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar navbar-expand-lg fixed-top navbar-light bg-white">
    <div class="container">
        <a href="index.jsp" class="navbar-brand">IPN</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="index.jsp">Inicio <span class="pe-7s-home"></span></a>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Ejercicios<span class="caret"></span></a>
                    <div class="dropdown-menu" aria-labelledby="themes">
                        <a class="dropdown-item" href="quicksort">Quicksort</a>
                        <a class="dropdown-item" href="grafica">Gráfica</a>
                        <a class="dropdown-item" href="tiposDatos">Tipos de Datos</a>
                        <!--<div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="agregarCarrera.jsp">Agregar carrera</a>-->
                    </div>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Técnicas<span class="caret"></span></a>
                    <div class="dropdown-menu" aria-labelledby="themes">
                        <a class="dropdown-item" href="algoritmosGeneticos">Algoritmos Genéticos</a>
                    </div>
                </li>

            </ul>

        </div>
    </div>
</div>
