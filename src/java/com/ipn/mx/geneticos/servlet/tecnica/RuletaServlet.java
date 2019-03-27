package com.ipn.mx.geneticos.servlet.tecnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipn.mx.geneticos.modelo.dao.RuletaDAO;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import com.ipn.mx.geneticos.tecnica.ruleta.IndividuoRuleta;
import com.ipn.mx.geneticos.utilerias.Rango;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class RuletaServlet extends HttpServlet {

    private final RuletaDAO dao = new RuletaDAO();
    private final Gson gson = new GsonBuilder().create();
    private Poblacion<IndividuoRuleta> lista;
    private Rango rango;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("txtAccion");
        try (PrintWriter out = response.getWriter()) {
            switch (accion) {
                case "getPoblacionAleatoria":
                    getPoblacionAleatoria(request, out);
                    break;
                case "getQuicksort":
                    getQuicksort(request, out);
                    break;
                case "setRangos":
                    setRangos(request, out);
                    break;
                default:
                    break;
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void getPoblacionAleatoria(HttpServletRequest request, PrintWriter out) {
        int num = Integer.parseInt(request.getParameter("txtNumeroPoblacion"));
        
        //dao.setRuleta(num);
        lista = dao.getPoblacionAleaotria();
        out.println(gson.toJson(dao.getRuleta()));
    }

    private void getQuicksort(HttpServletRequest request, PrintWriter out) throws IOException {
        lista = dao.quicksort(lista);
        out.println(gson.toJson(lista));
    }

    private void setRangos(HttpServletRequest request, PrintWriter out) {
        int valorInicio = Integer.parseInt(request.getParameter("txtValorInicio"));
        int valorFinal = Integer.parseInt(request.getParameter("txtValorFinal"));
        //dao.setRango(valorInicio, valorFinal);
    }
}
