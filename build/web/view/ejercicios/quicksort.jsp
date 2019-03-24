<%-- 
    Document   : quicksort
    Created on : 16/03/2019, 11:01:42 AM
    Author     : Andres
--%>

<%@page import="com.ipn.mx.geneticos.modelo.dto.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quicksort</title>
        <%@ include file="../../shared/header.jsp" %>
    </head>
    <body >
        <!-- Navbar -->
        <%@ include file="../../shared/navbar.jsp" %>
        <div id="app">
            <div class="container animated fadeIn delay-100ms" >
                <div class="row">
                    <div class="col-12">
                        <div class="row">
                            <div class="col-8">
                                <h2>Lista de cromosomas</h2>
                            </div>
                            <div class="col-4"></div>
                        </div>
                        <hr>
                        <div class="row">
                            <div class="col-12">
                                <p>Ingrese aquí el número de cromosomas aleatorias que tendra la población.</p>
                            </div>
                            <div class="col-12 form-inline">
                                <div class="form-group mx-sm-3 mb-2">
                                    <label for="txtNumeroPoblacion">Número de cromosomas</label>
                                </div>
                                <div class="form-group mx-sm-3 mb-2">
                                    <input type="number" class="form-control" id="txtNumeroPoblacion" name="txtNumeroPoblacion" aria-describedby="emailHelp" value="10" placeholder="10">
                                    
                                </div>
                                <div class="form-group mb-2">
                                    <button id="btnGetAleatorios" class="btn btn-success" > Generar aleatorio </button>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <br class="m-t-4">
                            <div class="col-5">
                                <div class="table" id="tablaAleatorio" name="tablaCategoria">
                                    <table class='table table-sm table-hover'>
                                        <thead class=''>
                                            <tr class='table-light'>
                                                <th scope='col'> Num elemento </th>
                                                <th scope='col'> Valor </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for='(cromosoma,index) in cromosomas' >
                                                <td>{{index+1}}</td>
                                                <td>{{cromosoma.valorReal}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                            <div class="col-2">
                                <div class="form-group text-center">
                                    <button id="btnQuicksort" class="btn btn-info" > Quicksort </button>
                                </div>
                            </div>
                            <div class="col-5">
                                <div class="table" id="tablaAleatorio" name="tablaCategoria">
                                    <table class='table table-sm table-hover'>
                                        <thead class=''>
                                            <tr class='table-light'>
                                                <th scope='col'> Num elemento </th>
                                                <th scope='col'> Valor </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for='(cromosoma,index) in cromosomasOrdenados' >
                                                <td>{{index+1}}</td>
                                                <td>{{cromosoma.valorReal}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- footer -->
        <%@ include file="../../shared/footer.jsp" %>
        <script>
            //bootstrapValidate('txtNombreCategoria','required:Por favor llena el campo');
            $(document).ready(function () {});

            var app = new Vue({
                el: '#app',
                data: {
                    cromosomas: [],
                    cromosomasOrdenados: [],
                    cromosomaEditar: {
                        idCategoria: '',
                        nombreCategoria: '',
                        descripcionCategoria: ''
                    }
                },
                methods: {
                    modalEditar: function (cromosoma) {
                        this.cromosomaEditar = cromosoma;
                    }
                }
            });

            function getCromosomas() {
                $.ajax({
                    type: 'GET',
                    url: '<%=Route.PATH%>/CromosomaServlet',
                    data: {
                        txtAccion: 'getPoblacionAleatoria',
                        txtNumeroPoblacion: $("#txtNumeroPoblacion").val()
                    },
                    success: function (responseText) {
                        app.$data.cromosomas = JSON.parse(responseText);
                        app.$data.cromosomasOrdenados = app.$data.cromosomas;
                    }
                });
            }
            
            function getQuicksort() {
                $.ajax({
                    type: 'GET',
                    url: '<%=Route.PATH%>/CromosomaServlet',
                    data: {
                        txtAccion: 'getQuicksort'
                    },
                    success: function (responseText) {
                        app.$data.cromosomasOrdenados = JSON.parse(responseText);
                    }
                });
            }

            // Init()
            getCromosomas();
            $("#btnGetAleatorios").click( getCromosomas );
            $("#btnQuicksort").click( getQuicksort );

        </script>
    </body>
</html>