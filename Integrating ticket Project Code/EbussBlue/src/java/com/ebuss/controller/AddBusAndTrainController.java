/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ebuss.controller;

import com.ebuss.beans.AddTrainAndBusPass;
import com.ebuss.model.AdminModel;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ramu
 */
public class AddBusAndTrainController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        AddTrainAndBusPass atabp = new AddTrainAndBusPass();
        
        atabp.setStartingOrigin(request.getParameter("startingOrigin"));
        atabp.setStartingStopName(request.getParameter("startingStopName"));        
        atabp.setFisrtRootNumber(request.getParameter("fisrtRootNumber"));
        atabp.setFirstCost(Float.parseFloat(request.getParameter("firstCost")));
        atabp.setGetDownFirstStop(request.getParameter("getDownFirstStop"));        
        atabp.setFirstWalkDistance(request.getParameter("firstWalkDistance"));
        atabp.setFirstTrainStationName(request.getParameter("firstTrainStationName"));
        atabp.setFirstTrainName(request.getParameter("firstTrainName"));
        atabp.setSecondCost(Float.parseFloat(request.getParameter("secondCost")));
        atabp.setGetDownTrainStopName(request.getParameter("getDownTrainStopName"));
        atabp.setSecondWalkDistance(request.getParameter("secondWalkDistance"));
        atabp.setGetInSecondBusNumber(request.getParameter("getInSecondBusNumber"));
        atabp.setThirdCost(Float.parseFloat(request.getParameter("thirdCost")));
        atabp.setDestination(request.getParameter("destination"));
        atabp.setTotalCost(Float.parseFloat(request.getParameter("totalCost")));
        
        AdminModel am = new AdminModel();
        String msg = am.adminAddBusPass(atabp);
        response.sendRedirect("AddBusAndTrainPass.jsp?msg="+msg);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
