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
                            <div class="col-3 form-group">
                                <label for="txtNumeroPoblacion">Número de cromosomas: </label>
                                <input type="number" class="form-control" id="txtNumeroPoblacion" name="txtNumeroPoblacion" aria-describedby="emailHelp" value="60" placeholder="10">
                            </div>
                            <div class="col-3 form-group">
                                <label for="txtNumeroPoblacion">Longitud de cromosoma: </label>
                                <input type="number" class="form-control" id="txtLongitud" name="txtLongitud" aria-describedby="emailHelp" value="5" placeholder="10">
                            </div>
                            <div class="col-3 form-group">
                                <label for="txtNumeroPoblacion">Número de mínimo: </label>
                                <input type="number" class="form-control" id="txtMin" name="txtMin" aria-describedby="emailHelp" value="1" placeholder="10">
                            </div>
                            <div class="col-3 form-group">
                                <label for="txtNumeroPoblacion">Número de máximo: </label>
                                <input type="number" class="form-control" id="txtMax" name="txtMax" aria-describedby="emailHelp" value="31" placeholder="10">
                            </div>
                            <div class="col-4">
                                <button id="btnGetAleatorios" class="btn btn-success" > Generar aleatorio </button>
                            </div>
                            <div class="col-4">
                                <button id="btnQuicksort" class="btn btn-success" > Quicksort </button>
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
                var min = $("#txtMin").val();
                var max = $("#txtMax").val();
                if( min <= max ){
                    $.ajax({
                        type: 'GET',
                        url: 'CromosomaServlet',
                        data: {
                            txtAccion: 'getPoblacionAleatoria',
                            txtNumeroPoblacion: $("#txtNumeroPoblacion").val(),
                            txtLongitud: $("#txtLongitud").val(),
                            txtMin: $("#txtMin").val(),
                            txtMax: $("#txtMax").val()
                        },
                        success: function (responseText) {
                            app.$data.cromosomas = JSON.parse(responseText);
                            window.myPieChart.config.data.datasets[0].data = getValueCromosomas(app.$data.cromosomas);
                            window.myPieChart.config.data.datasets[1].data = getValueCromosomas(app.$data.cromosomas);
                            window.myPieChart.config.data.labels = window.myPieChart.config.data.datasets[0].data;
                            window.myPieChart.update();
                        }
                    });
                }else{
                    alert("El valor mínimo supera al máximo");
                }
            }

            function getQuicksort() {
                $.ajax({
                    type: 'GET',
                    url: 'CromosomaServlet',
                    data: {
                        txtAccion: 'getQuicksort'
                    },
                    success: function (responseText) {
                        app.$data.cromosomasOrdenados = JSON.parse(responseText);
                        console.log(app.$data.cromosomasOrdenados);
                        window.myPieChart.config.data.datasets[0].data = getValueCromosomas(app.$data.cromosomasOrdenados);
                        //window.myPieChart.config.data.datasets[1].data = getValueCromosomas(app.$data.cromosomasOrdenados);
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
                        }, {
                            label: 'Original',
                            backgroundColor: '#AED6F1',
                            borderColor: '#AED6F1',
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
