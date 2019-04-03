package com.ipn.mx.geneticos.servlet.tecnica;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ipn.mx.geneticos.modelo.dao.RuletaDAO;
import com.ipn.mx.geneticos.modelo.dto.Cromosoma;
import com.ipn.mx.geneticos.modelo.dto.Poblacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andres
 */
public class AlgoritmosGeneticosServlet extends HttpServlet {

    private final RuletaDAO dao = new RuletaDAO(Cromosoma.class);
    private final Gson gson = new GsonBuilder().create();
    private List<Poblacion<Cromosoma>> generaciones;
    
    private String accion;
    private int numeroGeneraciones;
    private int longitudCromosoma;
    private String porcentajeMutacion;
    private String seleccion;
    private String cruza;
    private String mutacion;
    
    //Variables para población bloques Constructores
    private String tipoBloque;
    private String bloque;
    
    //Variables para población Aleatorio
    private int numeroCromosomas;
    private int valorMinRandom;
    private int valorMaxRandom;
    
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
        accion = request.getParameter("radioTipoPoblacion");
        
        try (PrintWriter out = response.getWriter()) {
            if( accion == null ){
                out.println("ERROR");
            }else{ 
                //VALORES PARA GENERAR EL METODO
                numeroGeneraciones = Integer.parseInt(request.getParameter("txtNumeroGeneracion"));
                longitudCromosoma = Integer.parseInt(request.getParameter("txtLongitud"));
                porcentajeMutacion = request.getParameter("txtPorcentaje");
                seleccion = request.getParameter("selSeleccion");
                cruza = request.getParameter("selCruza");
                mutacion = request.getParameter("selMutacion");        
                switch (accion) {
                    case "BLOQUE":
                        executeAlgoritmoGenetico(request, out);
                        break;
                    case "ALEATORIO":
                        executeAlgoritmoGeneticoAleatorio(request, out);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void executeAlgoritmoGenetico(HttpServletRequest request, PrintWriter out) {
        tipoBloque = request.getParameter("selTipoBloque");
        bloque = request.getParameter("txtBloque");
        System.out.println("");
        switch(tipoBloque){
            case "BINARIO":
                generaciones = 
                    dao.executeAG(numeroGeneraciones, longitudCromosoma, 
                        porcentajeMutacion, bloque, seleccion,cruza, mutacion);
                break;
            case "REAL":
                break;   
            default:
                break;
        }
        out.print( gson.toJson(generaciones) );
    }
    
    private void executeAlgoritmoGeneticoAleatorio(HttpServletRequest request, PrintWriter out) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
