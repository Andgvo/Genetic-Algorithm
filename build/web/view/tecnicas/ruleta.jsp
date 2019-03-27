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
                        <div class="row">
                            <div class="col-12">
                                <p>Ingrese aquí el número de cromosomas aleatorias que tendra la población.</p>
                            </div>
                            <div class="col-12 row">

                                <div class="form-group col-3">
                                    <label for="txtNumeroPoblacion">Número de cromosomas:</label>
                                    <input type="number" class="form-control" id="txtNumeroPoblacion" name="txtNumeroPoblacion" aria-describedby="emailHelp" value="10" placeholder="10">
                                </div>
                                <div class="form-group col-3">
                                    <label for="txtNumeroGeneracion">Número de generaciones:</label>
                                    <input type="number" class="form-control" id="txtNumeroGeneracion" name="txtNumeroGeneracion" aria-describedby="emailHelp" value="10" placeholder="10">
                                </div>
                                <div class="form-group col-3">
                                    <label for="txtNumeroPoblacion">Valor mínimo del Random:</label>
                                    <input type="number" class="form-control" id="txtValorInicio" name="txtValorInicio" aria-describedby="emailHelp" value="1" placeholder="10">
                                </div>
                                <div class="form-group col-3">
                                    <label for="txtNumeroPoblacion">Valor máximo del Random:</label>
                                    <input type="number" class="form-control" id="txtValorFinal" name="txtValorFinal" aria-describedby="emailHelp" value="10" placeholder="10">
                                </div>

                                <div class="form-group col-6">
                                    <label for="txtNumeroPoblacion">Bloque de cromosomas con valor decimal:</label>
                                    <input type="text" class="form-control" id="txtBloqueCromosomas" name="txtBloqueCromosomas" aria-describedby="emailHelp" value="10" placeholder="10">
                                </div>
                                <div class="form-group col-6">
                                    <label for="txtNumeroPoblacion">Bloque de cromosomas con valor binario</label>
                                    <input type="text" class="form-control" id="txtBloqueCromosomas" name="txtBloqueCromosomas" aria-describedby="emailHelp" value="01101,11000,01000,10011,10111,01111" placeholder="10">
                                </div>

                                <div class="col-6">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text" for="inputGroupSelect01">Selección</label>
                                        </div>
                                        <select class="custom-select" id="inputGroupSelect01">
                                            <option value="RULETA" selected>Ruleta</option>
                                            <option value="TORNEO">One</option>
                                            <option value="JERARQUICO">Two</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="col-6">
                                    <div class="input-group mb-3">
                                        <div class="input-group-prepend">
                                            <label class="input-group-text" for="inputGroupSelect01">Mutación</label>
                                        </div>
                                        <select class="custom-select" id="inputGroupSelect01">
                                            <option value="SIMPLE" selected>Simple</option>
                                            <option value="1">One</option>
                                            <option value="2">Two</option>
                                            <option value="3">Three</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group col-6">
                                    <div class="text-left">
                                        <button id="btnSetRangos" class="btn btn-warning" > Definir rango </button>
                                    </div>
                                </div>
                                <div class="form-group col-6">
                                    <div class="text-right">
                                        <button id="btnGetAleatorios" class="btn btn-success" > Generar aleatorio </button>
                                        <button id="btnRuleta" class="btn btn-warning" > Enviar bloque </button>
                                        <button id="btnQuicksort" class="btn btn-info" > Quicksort </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="accordion col-12" id="accordionExample">
                                <div class="card">
                                    <div class="card-header card-no-padding" id="headingOne">
                                        <h2 class="">
                                            <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                Generación #1
                                            </button>
                                        </h2>
                                    </div>

                                    <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
                                        <div class="card-body">
                                            Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
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
                            <div class="col-12">
                                <div class="table" id="tablaAleatorio" name="tablaCategoria">
                                    <table class='table table-sm table-hover'>
                                        <thead class=''>
                                            <tr class='table-success'>
                                                <th scope='col'> n </th>
                                                <th scope='col'> f </th>
                                                <th scope='col'> r </th>
                                                <th scope='col'> t </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>{{ruleta.n}}</td>
                                                <td>{{ruleta.f}}</td>
                                                <td>{{ruleta.r}}</td>
                                                <td>{{ruleta.t}}</td>
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
                    ruleta: {
                        f: 0,
                        n: 1,
                        poblacion: [],
                        r: 0,
                        t: 0
                    },
                    cromosomasOrdenados: []
                },
                methods: {}
            });

            function getCromosomas() {
                $.ajax({
                    type: 'GET',
                    url: 'RuletaServlet',
                    data: {
                        txtAccion: 'getPoblacionAleatoria',
                        txtNumeroPoblacion: $("#txtNumeroPoblacion").val()
                    },
                    success: function (responseText) {
                        app.$data.ruleta = JSON.parse(responseText);
                    }
                });
            }

            function getQuicksort() {
                $.ajax({
                    type: 'GET',
                    url: 'RuletaServlet',
                    data: {
                        txtAccion: 'getQuicksort'
                                //txtPoblacion: JSON.stringify( app.$data.ruleta.poblacion ) //Obtiene el JSON de Cromosomas
                    },
                    success: function (responseText) {
                        app.$data.ruleta.poblacion = JSON.parse(responseText);
                    }
                });
            }

            function setRangos() {
                $.ajax({
                    type: 'GET',
                    url: 'RuletaServlet',
                    data: {
                        txtAccion: 'setRangos',
                        txtValorInicio: $('#txtValorInicio').val(),
                        txtValorFinal: $('#txtValorFinal').val()
                                //txtPoblacion: JSON.stringify( app.$data.ruleta.poblacion ) //Obtiene el JSON de Cromosomas
                    },
                    success: function (responseText) {
                        //app.$data.ruleta.poblacion = JSON.parse(responseText);
                    }
                });
            }

            function addCategoria() {
                $.ajax({
                    type: 'POST',
                    url: 'CategoriaServlet',
                    data: {
                        txtAccion: 'getPoblacionAleatoria',
                        txtNumeroPoblacion: $("#txtNumeroPoblacion").val()
                    },
                    success: function (responseText) {
                        getCromosomas();
                    }
                });
            }

            function updateCategoria() {
                $.ajax({
                    type: 'POST',
                    url: 'CategoriaServlet',
                    data: $("#formEditarCategoria").serialize(),
                    success: function (responseText) {
                        getCromosomas();
                    }
                });
            }

            function deleteCategoria(varIdCategoria) {
                $.ajax({
                    type: 'POST',
                    url: 'CategoriaServlet',
                    data: {
                        txtAccion: 'deleteCategoria',
                        txtIdCategoria: varIdCategoria
                    },
                    success: function (responseText) {
                        getCromosomas();
                    }
                });
            }

            // Init()
            getCromosomas();
            $("#btnGetAleatorios").click(getCromosomas);
            $("#btnQuicksort").click(getQuicksort);
            $("#btnSetRangos").click(setRangos);

        </script>
    </body>
</html>