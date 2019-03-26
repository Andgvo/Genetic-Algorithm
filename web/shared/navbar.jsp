<%-- 
    Document   : navbar
    Created on : 16/02/2019, 09:34:55 AM
    Author     : andres
--%>
<%@page import="com.ipn.mx.geneticos.modelo.dto.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="navbar navbar-expand-lg fixed-top navbar-light bg-white">
    <div class="container">
        <a href="dashboard.jsp" class="navbar-brand">IPN</a>
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
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Tecnicas<span class="caret"></span></a>
                    <div class="dropdown-menu" aria-labelledby="themes">
                        <a class="dropdown-item" href="<%=Route.PATH%>/view/tecnicas/ruleta.jsp">Ruleta</a>
                        <!--<a class="dropdown-item" href="datos.jsp">Ver alumnos por carrera</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="agregarCarrera.jsp">Agregar carrera</a>-->
                    </div>
                </li>

            </ul>

            <ul class="nav navbar-nav ml-auto">
                <!--<li class="nav-item">
                  <a class="nav-link" href="https://wrapbootstrap.com/?ref=bsw" target="_blank">ESCOM</a>
                </li>-->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" id="themes">Opciones<span class="caret"></span></a>
                    <div class="dropdown-menu" aria-labelledby="themes">
                        <a class="dropdown-item" href="mostrarCarreras.jsp">Ver perfil</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="index.jsp">Cerrar sesión</a>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
