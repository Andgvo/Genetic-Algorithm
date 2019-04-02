package com.ipn.mx.geneticos.servlet.tecnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipn.mx.geneticos.modelo.dao.RuletaDAO;
import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
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
public class AlgoritmosGeneticosServlet extends HttpServlet {

    private final RuletaDAO dao = new RuletaDAO();
    private final Gson gson = new GsonBuilder().create();
    private Poblacion<Cromosoma> lista;
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
        String accion = request.getParameter("radioTipoPoblacion");
        try (PrintWriter out = response.getWriter()) {
            switch (accion) {
                case "executeAlgoritmoGenetico":
                    executeAlgoritmoGenetico(request, out);
                    break;
                case "executeAlgoritmoGeneticoAleatorio":
                    executeAlgoritmoGeneticoAleatorio(request, out);
                    break;
                default:
                    break;
            }
        }
    }

    private void executeAlgoritmoGenetico(HttpServletRequest request, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void executeAlgoritmoGeneticoAleatorio(HttpServletRequest request, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setRangos(HttpServletRequest request, PrintWriter out) {
        int valorInicio = Integer.parseInt(request.getParameter("txtValorInicio"));
        int valorFinal = Integer.parseInt(request.getParameter("txtValorFinal"));
        //dao.setRango(valorInicio, valorFinal);
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

    

}
