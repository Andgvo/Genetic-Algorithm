<%-- 
    Document   : ruleta
    Created on : 16/03/2019, 10:59:12 AM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Ruleta</title>
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
                                <h2>Técnica de la Ruleta</h2>
                            </div>
                            <div class="col-4"></div>
                        </div>
                        <hr>
                        <form id="formMetodo" @submit="checkForm">
                            <div class="row">
                                <div class="col-12">
                                    <p>Aquí podrás configurar el algoritmos genetico que deseas ejecutar.</p>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label> Tipo de Población inicial:  </label><br>
                                        <div class="form-check form-check-inline">                                        
                                            <div class="custom-control custom-radio">
                                                <input class="custom-control-input form-check-input" value="BLOQUE" type="radio" id="radioBloque" name="txtAccion" checked=""  v-model="tipoPoblacionIni">
                                                <label class="custom-control-label form-check-label" for="radioBloque">Bloque Contructor</label>
                                            </div>
                                        </div>
                                        <div class="form-check form-check-inline">                                        
                                            <div class="custom-control custom-radio">
                                                <input class="custom-control-input form-check-input" value="ALEATORIO" type="radio" id="radioAleatorio" name="txtAccion" v-model="tipoPoblacionIni">
                                                <label class="custom-control-label form-check-label" for="radioAleatorio">Aleatorio</label>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="col-12">
                                    <!-- CONFIGURACION COMPARTIDA -->
                                    <div class="row">
                                        <div class="form-group col-6 col-sm-3 col-md-4 col-lg-4">
                                            <label for="txtNumeroGeneracion">Número de generaciones:</label>
                                            <input type="number" class="form-control" id="txtNumeroGeneracion" name="txtNumeroGeneracion" aria-describedby="emailHelp" value="4" placeholder="10">
                                        </div>
                                        <div class="form-group col-6 col-sm-3 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Longitud de cromosomas:</label>
                                            <input type="number" class="form-control" id="txtLongitud" name="txtLongitud" aria-describedby="emailHelp" value="5" placeholder="10">
                                        </div>
                                        <div class="form-group col-6 col-sm-3 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Porcentaje de mutacion:</label>
                                            <input type="number" class="form-control" id="txtPorcentaje" name="txtPorcentaje" aria-describedby="emailHelp" value="20" placeholder="10">
                                        </div>       
                                    </div>
                                    <!-- CONFIGURACION PARA BLOQUE -->
                                    <div v-if="tipoPoblacionIni === 'ALEATORIO'" class="row">
                                        <div class="form-group col-6 col-sm-4 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Número de cromosomas:</label>
                                            <input type="number" class="form-control" id="txtNumeroPoblacion" name="txtNumeroPoblacion" aria-describedby="emailHelp" value="10" placeholder="10">
                                        </div>
                                        <div class="form-group col-6 col-sm-4 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Valor mínimo del Random:</label>
                                            <input type="number" class="form-control" id="txtValorInicio" name="txtValorInicio" aria-describedby="emailHelp" value="1" placeholder="10">
                                        </div>
                                        <div class="form-group col-6 col-sm-4 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Valor máximo del Random:</label>
                                            <input type="number" class="form-control" id="txtValorFinal" name="txtValorFinal" aria-describedby="emailHelp" value="10" placeholder="10">
                                        </div>
                                    </div>
                                    <!-- CONFIGURACION PARA ALEATORIO -->
                                    <div v-else-if="tipoPoblacionIni === 'BLOQUE'" class="row">
                                        <div class="col-12 col-sm-4 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Tipo de Bloque: </label>
                                            <div class="input-group mb-3">
                                                <select v-model='tipoBloque' class="custom-select" id="selTipoBloque" name="selTipoBloque">
                                                    <option value="BINARIO" selected>Binario</option>
                                                    <option value="REAL">Reales</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group col-12 col-sm-8 col-md-8 col-lg-8">
                                            <label for="txtBloque">Bloque de cromosomas {{tipoBloque}}</label>
                                            <input type="text" class="form-control" id="txtBloque" name="txtBloque" aria-describedby="emailHelp" value="01101,11000,01000,10011,10111,01111" placeholder="10">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-12 col-sm-4 col-md-4 col-lg-4">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <label class="input-group-text" for="selSeleccion">Selección</label>
                                                </div>
                                                <select class="custom-select" id="selSeleccion" name="selSeleccion">
                                                    <option value="RULETA" selected>Ruleta</option>
                                                    <option value="TORNEO">Torneo</option>
                                                    <option value="JERARQUICO">Jerarquia</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-4 col-md-4 col-lg-4">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <label class="input-group-text" for="selCruza">Cruza</label>
                                                </div>
                                                <select class="custom-select" id="selCruza" name="selCruza">
                                                    <option value="N_PUNTOS" selected>N Puntos</option>
                                                    <option value="TORNEO">One</option>
                                                    <option value="JERARQUICO">Two</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-12 col-sm-4 col-md-4 col-lg-4">
                                            <div class="input-group mb-3">
                                                <div class="input-group-prepend">
                                                    <label class="input-group-text" for="selMutacion">Mutación</label>
                                                </div>
                                                <select class="custom-select" id="selMutacion" name="selMutacion">
                                                    <option value="CAMBIO_BTI" selected>Cambio de Bit</option>
                                                    <option value="1">One</option>
                                                    <option value="2">Two</option>
                                                    <option value="3">Three</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </form>
                        <div class="row">
                            <div class="col-12">
                                <div class="row">
                                    <div class="form-group col-6">
                                        <div class="text-left">
                                            <!--<button id="btnSetRangos" class="btn btn-warning" > Definir rango </button>-->
                                        </div>
                                    </div>
                                    <div class="form-group col-6">
                                        <div class="text-right">
                                            <button id="btnEjecutarAG" class="btn btn-success btn-lg" > Ejecutar Algoritmo Genetico </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <br class="m-t-4">
                            <div class="col-12">
                                <div class="table" id="tablaAleatorio" name="tablaCategoria">
                                    <table class='table table-xs table-hover'>
                                        <thead class=''>
                                            <tr class='table-info'>
                                                <th scope='col' colspan="11" class="text-center"> Generaciones </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for='(bloque,index) in generarBloques(generaciones)'>
                                                <td scope='row' colspan="1">
                                                    {{(index*10)+1}} - {{ (index+1)*10 }}
                                                </td>
                                                <td v-for='(poblacion, index2) in bloque'>
                                                    <a class="poblacion-button-modal" 
                                                       v-on:click="setPoblacionTable((index*10)+index2, poblacion)">
                                                        Gen. {{(index*10)+index2+1 }}
                                                    </a>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div><!-- /row -->
                        
                        <div class="row">
                            <div class="col-12">
                                <canvas id="graphCromosomas"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div id="source-modal" class="modal fade">
                <div class="modal-dialog modal-lg">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h4 class="modal-title">Poblacion No. {{poblacion.id+1}}</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        </div>
                        <div class="modal-body">
                            <table class='table table-sm'>
                                <thead class=''>
                                    <tr class='table-warning'>
                                        <th scope='col'> &Sigma; Aptitud </th>
                                        <th scope='col'> Prom. Aptitud </th>
                                        <th scope='col'> Máximo </th>
                                        <th scope='col'> Mínimo </th>
                                        <th scope='col'> &Sigma; Ve </th>
                                        <th scope='col'> Prom. Ve </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>{{poblacion.resultados.SumatoriaAptitud}}</td>
                                        <td>{{poblacion.resultados.PromedioAptitud}}</td>
                                        <td>{{poblacion.resultados.cromosomaMax.valorReal}}</td>
                                        <td>{{poblacion.resultados.cromosomaMin.valorReal}}</td>
                                        <td>{{poblacion.resultados.SumatoriaVe}}</td>
                                        <td>{{poblacion.resultados.PromedioVe}}</td>
                                    </tr>
                                </tbody>
                            </table>
                            <table class='table table-sm table-hover'>
                                <thead class=''>
                                    <tr class='table-info'>
                                        <th scope='col'> n </th>
                                        <th scope='col'> Cadena </th>
                                        <th scope='col'> Real </th>
                                        <th scope='col'> Aptitud </th>
                                        <th scope='col'> Ve </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for='(individuo, index) in poblacion.individuos' >
                                        <td>{{index+1}}</td>
                                        <td>{{individuo.cadenaBinaria}}</td>
                                        <td>{{individuo.valorReal}}</td>
                                        <td>{{individuo.aptitud}}</td>
                                        <td>{{individuo.valorEsperado}}</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="modal-footer">
                            <button v-if="(poblacion.id-1) >= 0 " type="button" v-on:click="setPoblacionTable(poblacion.id-1, generaciones[poblacion.id-1] )" class="btn btn-primary">Anterior</button>
                            <button v-if="(poblacion.id+1) < generaciones.length" type="button" v-on:click="setPoblacionTable(poblacion.id+1, generaciones[poblacion.id+1] )" class="btn btn-primary">Siguiente</button>
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

            //COSTANT
            class Cromosoma{
                contructor(valorReal, cadenaBinaria, aptitud, valorEsperado,
                    probabilidadAcumulada){
                }                
            }
            //Autocomplete modals
            function setListenerModals() {
                $(".poblacion-button-modal").click(function () {
                    $("#source-modal").modal();
                });
            }
            
            const swalWithBootstrapButtons = Swal.mixin({
                confirmButtonClass: 'btn btn-outline-success',
                cancelButtonClass: 'btn btn-outline-danger',
                buttonsStyling: false
            });

            var app = new Vue({
                el: '#app',
                data: {
                    tipoPoblacionIni: 'BLOQUE',
                    tipoBloque: 'BINARIO',
                    ruleta: {
                        f: 0,
                        n: 1,
                        poblacion: [],
                        r: 0,
                        t: 0
                    },
                    generaciones: [],
                    poblacion: {
                        id: -1,
                        resultados: {
                            PromedioAptitud: 0,
                            PromedioVe: 0,
                            SumatoriaAptitud: 0,
                            SumatoriaVe: 0,
                            cromosomaMax: {},
                            cromosomaMin: {}
                        },
                        individuos: []
                    }
                },
                methods: {
                    generarBloques: function (listaPoblaciones) {
                        var bloques = [];
                        var bloque = [];
                        var i;
                        for (i = 0; i < listaPoblaciones.length; i++) {
                            bloque.push(listaPoblaciones[i]);
                            if (((i + 1) % 10) === 0) {
                                bloques.push(bloque);
                                bloque = [];
                            }
                        }
                        if ((i % 10) !== 0) {
                            bloques.push(bloque);
                        }
                        return bloques;
                    },
                    setPoblacionTable: function (id, poblacion) {
                        this.poblacion.id = id;
                        this.poblacion.resultados = poblacion;
                        getPoblacion(id);
                        $("#source-modal").modal();
                    },
                    checkForm: function (e) {
                        this.errors = [];
                        
                        e.preventDefault();
                    }
                }
            });

            function executeAlgoritmoGenetico() {
                $.ajax({
                    type: 'GET',
                    url: 'AlgoritmosGeneticosServlet',
                    data: $("#formMetodo").serializeArray(),
                    success: function (responseText) {
                        app.$data.generaciones = JSON.parse(responseText);
                        updateGraph(app.$data.generaciones);
                    }
                });
            }

            function getPoblacion(indice) {
                $.ajax({
                    type: 'GET',
                    url: 'AlgoritmosGeneticosServlet',
                    data: {
                        txtAccion: 'GET_POBLACION',
                        idPoblacion: indice
                    },
                    success: function (responseText) {
                        app.$data.poblacion.individuos = JSON.parse(responseText);
                    }
                });
            }
            
            //----------------------- GRAFICAS ---------------------------------
            const ctx = $("#graphCromosomas");
            var config = {
                type: 'line',
                data: {
                    labels: [],
                    datasets: []
                },
                options: {
                        responsive: true,
                        title: {
                                display: true,
                                text: 'Resultados'
                        },
                        tooltips: {
                                mode: 'index',
                                intersect: false,
                        },
                        hover: {
                                mode: 'nearest',
                                intersect: true
                        },
                        scales: {
                                xAxes: [{
                                        display: true,
                                        scaleLabel: {
                                                display: true,
                                                labelString: 'Generaciones'
                                        }
                                }],
                                yAxes: [{
                                        display: true,
                                        scaleLabel: {
                                                display: true,
                                                labelString: 'Valor'
                                        }
                                }]
                        }
                }
            };
            
            function updateGraph(generaciones){
                var sumatoriasAptitud= [];
                var promediosAptitud = [];
                var sumatoriasVe = [];
                var promediosVe = [];
                var maximos = [];
                var minimos = [];
                var data = [];
                generaciones.forEach(function(poblacion) {
                    sumatoriasAptitud.push(poblacion.SumatoriaAptitud);
                    promediosAptitud.push(poblacion.PromedioAptitud);
                    sumatoriasVe.push(poblacion.SumatoriaVe);
                    promediosVe.push(poblacion.PromedioVe);
                    maximos.push(poblacion.cromosomaMax.valorReal);
                    minimos.push(poblacion.cromosomaMin.valorReal);
                });
                data.push( formatoConjuntoGrafica('Maximos','#18BC9C','#18BC9C',maximos) );
                data.push( formatoConjuntoGrafica('Maximos','#E74C3C','#E74C3C',minimos) );
                config.data.datasets = data;
                config.data.labels = labelsConjuntoGrafica(generaciones.length);
                graficaResultados.update();                
            }
            
            function formatoConjuntoGrafica(titulo, colorPrimario, colorSecundario, datos){
                conjunto = {
                    label: titulo,
                    backgroundColor: colorPrimario,
                    borderColor: colorSecundario,
                    data: datos,
                    fill: false
                };
                return conjunto;
            }
            
            function labelsConjuntoGrafica(numGeneraciones){
                var labels = [];
                for(var i = 1; i <= numGeneraciones; i++){
                    labels.push("Gen "+i);
                }
                return labels;
            }
            
            // Init()
            $("#btnEjecutarAG").click(executeAlgoritmoGenetico);
            var graficaResultados = new Chart(ctx, config);
        </script>
    </body>
</html>