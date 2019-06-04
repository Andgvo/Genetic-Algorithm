<%-- 
    Document   : footer
    Created on : 16/02/2019, 09:34:15 AM
    Author     : andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String PATH_ASSETS = request.getContextPath()+ "/assets/"; %>
<footer class="col-12 footer font-small blue">
    <!-- Copyright -->
    <div class="footer-copyright text-center py-3">
        © 2018 Autor: López Sánchez Gustavo Andrés <a href="http://www.escom.ipn.mx/"> ESCOM </a>
    </div>
</footer>

<!-- scripts -->
<script src="<%= PATH_ASSETS %>js/jquery-3.3.1.min.js"></script>
<script src="<%= PATH_ASSETS %>js/bootstrap.min.js"></script>
<script src="<%= PATH_ASSETS %>js/sweetalert2.js"></script>
<script src="<%= PATH_ASSETS %>js/vue.js"></script>
<script>
    $(window).scroll(function () {
        var top = $(document).scrollTop();
        $('.splash').css({
            'background-position': '0px -'+(top/3).toFixed(2)+'px'
        });
        if(top < 10)
            $('.navbar').removeClass('navbar-shadow');
        else
            $('.navbar').addClass('navbar-shadow');
    });
</script>