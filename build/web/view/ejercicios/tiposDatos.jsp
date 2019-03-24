<%-- 
    Document   : tiposDatos
    Created on : 17/03/2019, 08:57:45 AM
    Author     : Andres
--%>

<%@page import="com.ipn.mx.geneticos.modelo.dto.Route"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tipos de Datos</title>
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
                                <h2>Tipos de Datos</h2>
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
                                    <button id="btnQuicksort" class="btn btn-info" > Quicksort </button>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <br class="m-t-4">
                            <div class="col-12">
                                <div class="table" id="tablaAleatorio" name="tablaCategoria">
                                    <table class='table table-sm table-hover'>
                                        <thead class=''>
                                            <tr class='table-light'>
                                                <th scope='col'> Num </th>
                                                <th scope='col'> Entero </th>
                                                <th scope='col'> Reales </th>
                                                <th scope='col'> Cadena Bits </th>
                                                <th scope='col'> Grey </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr v-for='(cromosoma,index) in cromosomas' >
                                                <td>{{index+1}}</td>
                                                <td>{{cromosoma.valorReal}}</td>
                                                <td>{{cromosoma.valorReal}}</td>
                                                <td>{{cromosoma.cadenaBinaria}}</td>
                                                <td>{{cromosoma.cadenaGray}}</td>
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

            <!-- Modal editar -->
            <div class="modal fade" id="modalEditar" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <form id="formEditarCategoria"  method="post">
                            <div class="modal-header">
                                <h4 class="modal-title" id="exampleModalLabel">Datos de la categoría</h4>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <div class="form-group">
                                    <input type="hidden" value="updateCategoria" class="form-control" id="txtAccion" name="txtAccion" required>
                                    <div class="form-group">
                                        <label for="txtIdCategoria">Id Categría</label>
                                        <input v-model="cromosomaEditar.idCategoria" type="text" class="form-control" id="txtIdCategoria" name="txtIdCategoria" readonly required>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtNombreCategoria">Nombre categría</label>
                                        <input v-model="cromosomaEditar.nombreCategoria" type="text" class="form-control" id="txtNombreCategoria" name="txtNombreCategoria" placeholder="Refresco" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="txtDescripcionCategoria">Descripción</label>
                                        <input v-model="cromosomaEditar.descripcionCategoria" type="text" class="form-control" id="txtDescripcion" name="txtDescripcionCategoria" placeholder="Ingresa algo que describade que trata la materia" required>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-outline-danger" data-dismiss="modal">Cancelar</button>
                                <button id="btnEditarCategoria" type="button" class="btn btn-outline-info">Editar</button>
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
                        //txtPoblacion: JSON.stringify( app.$data.cromosomas ) //Obtiene el JSON de Cromosomas
                    },
                    success: function (responseText) {
                        app.$data.cromosomas = JSON.parse(responseText);
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
            $("#btnGetAleatorios").click( getCromosomas );
            $("#btnQuicksort").click( getQuicksort );

        </script>
    </body>
</html>