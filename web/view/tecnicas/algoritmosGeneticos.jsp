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
                        <form id="formMetodo">
                            <div class="row">
                                <div class="col-12">
                                    <p>Aquí podrás configurar el algoritmos genetico que deseas ejecutar.</p>
                                </div>
                                <div class="col-12">
                                    <div class="form-group">
                                        <label> Tipo de Población inicial:  </label><br>
                                        <div class="form-check form-check-inline">                                        
                                            <div class="custom-control custom-radio">
                                                <input class="custom-control-input form-check-input" value="BLOQUE" type="radio" id="radioBloque" name="radioTipoPoblacion" checked=""  v-model="tipoPoblacionIni">
                                                <label class="custom-control-label form-check-label" for="radioBloque">Bloque Contructor</label>
                                            </div>
                                        </div>
                                        <div class="form-check form-check-inline">                                        
                                            <div class="custom-control custom-radio">
                                                <input class="custom-control-input form-check-input" value="ALEATORIO" type="radio" id="radioAleatorio" name="radioTipoPoblacion" v-model="tipoPoblacionIni">
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
                                            <input type="number" class="form-control" id="txtLongitud" name="txtLongitud" aria-describedby="emailHelp" value="10" placeholder="10">
                                        </div>
                                        <div class="form-group col-6 col-sm-3 col-md-4 col-lg-4">
                                            <label for="txtNumeroPoblacion">Porcentaje de mutacion:</label>
                                            <input type="number" class="form-control" id="txtPorcentaje" name="txtPorcentaje" aria-describedby="emailHelp" value="10" placeholder="10">
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
                                        <div class="form-group col-12 col-sm-6 col-md-6 col-lg-6">
                                            <label for="txtNumeroPoblacion">Bloque de cromosomas con valor decimal:</label>
                                            <input type="text" class="form-control" id="txtBloqueIndividuosReal" name="txtBloqueIndividuosReal" aria-describedby="emailHelp" value="10" placeholder="10">
                                        </div>
                                        <div class="form-group col-12 col-sm-6 col-md-6 col-lg-6">
                                            <label for="txtNumeroPoblacion">Bloque de cromosomas con valor binario</label>
                                            <input type="text" class="form-control" id="txtBloqueIndividuosBinario" name="txtBloqueIndividuosBinario" aria-describedby="emailHelp" value="01101,11000,01000,10011,10111,01111" placeholder="10">
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
                                                    <option value="TORNEO">One</option>
                                                    <option value="JERARQUICO">Two</option>
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
                                                <select class="custom-select" id="selMutacion" name="selCruza">
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
                                            <button id="btnGetAleatorios" class="btn btn-success" > Generar aleatorio </button>
                                            <button id="btnRuleta" class="btn btn-warning" > Enviar bloque </button>
                                            <!--<button id="btnQuicksort" class="btn btn-info" > Quicksort </button>-->
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
                                                <th scope='col'> Num </th>
                                                <th scope='col'> Cadena Bits </th>
                                                <th scope='col'> Reales </th>
                                                <th scope='col'> Aptitud </th>
                                                <th scope='col'> Ve </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for='(individuo,index) in ruleta.poblacion' >
                                                <td>{{index+1}}</td>
                                                <td>{{individuo.cadenaBinaria}}</td>
                                                <td>{{individuo.valorReal}}</td>
                                                <td>{{individuo.aptitud}}</td>
                                                <td>{{individuo.valorEsperado}}</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Modal -->
            <div class="modal fade" id="modalAgregar" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form id="formAgregarCategoria"  method="post">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalLabel">Datos de la categoría</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <input type="hidden" value="addCategoria" class="form-control" id="txtAccion" name="txtAccion" required>
                                    <div class="form-group">
                                        <label for="txtNombreCategoria">Nombre categría</label>
                                        <input type="text" class="form-control" id="txtNombreCategoria" name="txtNombreCategoria" placeholder="Refresco" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtDescripcionCategoria">Descripción</label>
                                        <input type="text" class="form-control" id="txtDescripcion" name="txtDescripcionCategoria" placeholder="Ingresa algo que describade que trata la materia" required>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btnAgregarCategoria" type="button" class="btn btn-outline-success">Agregar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>

        <!-- footer -->
        <%@ include file="../../shared/footer.jsp" %>
        <script>
            //bootstrapValidate('txtNombreCategoria','required:Por favor llena el campo');
            $(document).ready(function () {});

            const swalWithBootstrapButtons = Swal.mixin({
                confirmButtonClass: 'btn btn-outline-success',
                cancelButtonClass: 'btn btn-outline-danger',
                buttonsStyling: false
            });

            var app = new Vue({
                el: '#app',
                data: {
                    tipoPoblacionIni: 'BLOQUE',
                    ruleta: {
                        f: 0,
                        n: 1,
                        poblacion: [],
                        r: 0,
                        t: 0
                    },
                    generaciones: []
                },
                methods: {}
            });
            
            function executeAlgoritmoGenetico() {
                $.ajax({
                    type: 'GET',
                    url: 'AlgoritmosGeneticosServlet',
                    data: $("#formMetodo").serializeArray(),
                    success: function (responseText) {
                        app.$data.generaciones = JSON.parse(responseText);
                    }
                });
            }
            
            function executeAlgoritmoGeneticoAleatorio() {
                $.ajax({
                    type: 'GET',
                    url: 'executeAlgoritmoGeneticoAleatorio',
                    data: $("#formMetodo").serializeArray(),
                    success: function (responseText) {
                        app.$data.generaciones = JSON.parse(responseText);
                    }
                });
            }

            // Init()
            $("#btnExecuteAlgoritmoGenetico").click(executeAlgoritmoGenetico);
            $("#btnExecuteAlgoritmoGeneticoAleatorio").click(executeAlgoritmoGeneticoAleatorio);

        </script>
    </body>
</html>