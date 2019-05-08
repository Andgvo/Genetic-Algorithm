package com.ipn.mx.geneticos.servlet.tecnica;

import com.ipn.mx.geneticos.modelo.dao.MetodoDAO;
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

    private final MetodoDAO dao = new MetodoDAO(Cromosoma.class);
    
    private List<Poblacion<Cromosoma>> generaciones;
    
    private String accion;
    private int numeroGeneraciones;
    private int longitudCromosoma;
    private String seleccion;
    private String porcentajeSeleccionPoblacion;
    private String porcentajeSeleccionCromosoma;
    private String cruza;
    private int puntosCruza;
    private String porcentajeCruzaPoblacion;
    private String porcentajeCruzaCromosoma;
    private String mutacion;
    private int numElementosMutacion;
    private String porcentajeMutacionPoblacion;
    private String porcentajeMutacionCromosoma;
    
    //Variables para población bloques Constructores
    private String tipoBloque;
    private String bloque;
    
    
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
        accion = request.getParameter("txtAccion");
        
        try (PrintWriter out = response.getWriter()) {
            if( accion == null ){
                out.println("ERROR");
            }else if(accion.equals("GET_POBLACION")){
                getPoblacion(request, out);
            }else{ 
                //VALORES PARA GENERAR EL METODO
                numeroGeneraciones = Integer.parseInt(request.getParameter("txtNumeroGeneracion"));
                longitudCromosoma = Integer.parseInt(request.getParameter("txtLongitud"));
                porcentajeMutacionCromosoma = request.getParameter("txtPorcentajeMutacionCromosoma");
                //Seleccion
                seleccion = request.getParameter("selSeleccion");
                porcentajeSeleccionPoblacion = request.getParameter("txtPorcentajeSeleccionPoblacion");
                porcentajeSeleccionCromosoma = request.getParameter("txtPorcentajeSeleccionCromosoma");
                //Cruza
                cruza = request.getParameter("selCruza");
                puntosCruza = Integer.parseInt(request.getParameter("txtPuntosCruza"));
                porcentajeCruzaPoblacion = request.getParameter("txtPorcentajeCruzaPoblacion");
                porcentajeCruzaCromosoma = request.getParameter("txtPorcentajeCruzaCromosoma");
                //Mutacion
                mutacion = request.getParameter("selMutacion");
                numElementosMutacion = Integer.parseInt(request.getParameter("txtNumElementosMutacion"));
                porcentajeMutacionPoblacion = request.getParameter("txtPorcentajeMutacionPoblacion");
                porcentajeMutacionCromosoma = request.getParameter("txtPorcentajeMutacionCromosoma");
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
        switch(tipoBloque){
            case "BINARIO":
                generaciones = 
                    dao.executeAG(numeroGeneraciones, longitudCromosoma, bloque,
                        seleccion, porcentajeSeleccionPoblacion, porcentajeSeleccionCromosoma,
                        cruza, puntosCruza, porcentajeCruzaPoblacion, porcentajeCruzaCromosoma,
                        mutacion, numElementosMutacion, porcentajeMutacionPoblacion, porcentajeMutacionCromosoma);
                break;
            case "REAL":
                break;   
            default:
                break;
        }
        out.print( generaciones.toString() );
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

    private void getPoblacion(HttpServletRequest request, PrintWriter out) {
        int idPoblacion = Integer.parseInt(request.getParameter("idPoblacion"));
        if(generaciones != null){
            out.println(generaciones.get(idPoblacion).individuosToJSON());
        }else{
            out.println("ERROR POBLACION");
        }
    }
}
