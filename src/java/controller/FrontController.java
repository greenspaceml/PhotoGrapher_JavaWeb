/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.GalleryDAO;
import dal.InformationDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;
import model.Information;

/**
 *
 * @author green
 */
public class FrontController extends HttpServlet {

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
        try {

            InformationDAO informationDAO = new InformationDAO();
            GalleryDAO galleryDAO = new GalleryDAO();
            int curentPage = 0;
            String errReporter = null;

            //get top 3 gallery
            ArrayList<Gallery> list3HeaderGalleries = new ArrayList<>();
            list3HeaderGalleries = galleryDAO.get3headerGalleries();
            ArrayList<Gallery> listGalleriesInPage = new ArrayList<>();
            Information information = new Information();
            information = informationDAO.getinformation();

            // Get current page position
            String pageIndex = request.getParameter("pageIndex");
            // Check if page index is existed or not
            if (pageIndex == null) {
                //else pageindex will automatically be the first page
                pageIndex = "1";
            }

            //get the number of gallery querried
            int totalGalerries = galleryDAO.GalleryCounter();
            int pageSize = 3;

            // calculate Number of pages
            //check if check if totoal pageSize are divive by totalGalerries or not 
            //if yes, Num of page = the result else Num of page = the result + 1
            int NumOfPage = (totalGalerries % pageSize == 0) ? (totalGalerries / pageSize) : (totalGalerries / pageSize + 1);

            //Check entered page number is fit or not
            try {
                //try parsing to Integer
                curentPage = Integer.parseInt(pageIndex);
                //check of pageNumbe is fited or not
                if (curentPage > NumOfPage || curentPage < 1) {
                    errReporter = "Page not found";
                }
            } catch (NumberFormatException ex) {
                errReporter = "Page not found";
            }

            //get list Gallery that paged by page number
            listGalleriesInPage = galleryDAO.listGalleriesInPage(curentPage, pageSize);

            //send to Front site
            request.setAttribute("list3HeaderGalleries", list3HeaderGalleries);
            request.setAttribute("information", information);
            request.setAttribute("listGalleriesInPage", listGalleriesInPage);
            request.setAttribute("NumOfPage", NumOfPage);
            request.setAttribute("curentPage", curentPage);
            request.setAttribute("errReporter", errReporter);
            request.getRequestDispatcher("front.jsp").forward(request, response);
        } catch (Exception e) {
            request.getRequestDispatcher("error.jsp").forward(request, response);
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

}
