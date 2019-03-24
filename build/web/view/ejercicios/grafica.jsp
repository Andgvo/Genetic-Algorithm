<%-- 
    Document   : grafica
    Created on : 16/03/2019, 04:31:21 PM
    Author     : Andres
--%>

<%@page import="com.ipn.mx.geneticos.modelo.dto.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Gráfica</title>
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
                                <div class="form-group mb-2 ml-auto">
                                    <button id="btnQuicksort" class="btn btn-success" > Quicksort </button>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <canvas id="graphCromosomas"></canvas>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <!-- footer -->
        <%@ include file="../../shared/footer.jsp" %>
        <script src="<%= Route.STATIC %>/js/Chart.min.js"></script>
        <script>
            
            //bootstrapValidate('txtNombreCategoria','required:Por favor llena el campo');
            $(document).ready(function () {});
            /******************* VARIABLES *************************/
            

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
                        window.myPieChart.config.data.datasets[0].data = getValueCromosomas(app.$data.cromosomas);
                        window.myPieChart.config.data.labels = window.myPieChart.config.data.datasets[0].data;
                        window.myPieChart.update();
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
                        console.log(app.$data.cromosomasOrdenados);
                        window.myPieChart.config.data.datasets[0].data = getValueCromosomas(app.$data.cromosomasOrdenados);
                        window.myPieChart.config.data.labels = window.myPieChart.config.data.datasets[0].data;
                        window.myPieChart.update();
                    }
                });
            }
            
            /******************   GRAFICA   **************************/
            
            function getValueCromosomas( cromosomas ){
                datos = [];
                cromosomas.forEach(function(cromosoma) {
                    datos.push(cromosoma.valorReal);
                });
                return datos;
            }
            
            const ctx = $("#graphCromosomas");
            var config = {
                type: 'line',
                data: {
                    datasets: [{
                            label: 'Datos Random',
                            backgroundColor: '#F39C12',
                            borderColor: '#F39C12',
                            fill: false,
                            data: []
                        }],
                    labels: []
                },
                options: {
                    responsive: true
                }
            };

            // Init()
            $("#btnGetAleatorios").click(getCromosomas);
            $("#btnQuicksort").click(getQuicksort);
            var myPieChart = new Chart(ctx, config);
            getCromosomas();

        </script>
    </body>
</html>
