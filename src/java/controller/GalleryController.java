/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.GalleryDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Gallery;

/**
 *
 * @author green
 */
public class GalleryController extends HttpServlet {

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
            GalleryDAO galleryDAO = new GalleryDAO();
            ArrayList<Gallery> list3HeaderGalleries = new ArrayList<>();
            list3HeaderGalleries = galleryDAO.get3headerGalleries();
            Gallery gallery = new Gallery();
            int curentPage = 0;
            String errReporter = null;
            //get the gallery id from site

            String strgID = request.getParameter("gid");

            int gID = -1;
            // Try parsing galleryID to integer
            try {
                gID = Integer.parseInt(strgID);
            } catch (NumberFormatException e) {
                //if error when parsing, catch exception
                //ErrrorR  = errorString
                errReporter = "Page not found";
            }
            //pagesite hashed = 8
            int pageSize = 8;
            int totalImage = galleryDAO.imageCounter(gID);

            // calculate Number of pages
            //check if check if totoal pageSize are divived by totalGalerries or not 
            //if yes, Num of page = the result else Num of page = the result + 1
            int NumOfPage = (totalImage % pageSize == 0)
                    ? (totalImage / pageSize) : (totalImage / pageSize + 1);
            // Get current page position
            String pageIndex = request.getParameter("pageIndex");
            // Check if page index is existed or not
            if (pageIndex == null) {
                //else pageindex will automatically be the first page
                pageIndex = "1";
            }
            //try parsing current page that user entered to integer
            try {
                curentPage = Integer.parseInt(pageIndex);
                //check if current page is fit or not
                if (curentPage > NumOfPage || curentPage < 1) {
                    //if not, errrorR  = errorString
                    errReporter = "Page not found";
                }
            } catch (NumberFormatException ex) {
                //if error when parsing, catch exception
                //ErrrorR  = errorString
                errReporter = "Page not found";
            }
            gallery = galleryDAO.getGalleryByID(gID, curentPage, pageSize);
            if (gallery == null) {
                errReporter = "Page not found";
            }
            //send to gallery site
            request.setAttribute("list3HeaderGalleries", list3HeaderGalleries);
            request.setAttribute("errReporter", errReporter);
            request.setAttribute("NumOfPage", NumOfPage);
            request.setAttribute("curentPage", curentPage);
            request.setAttribute("gallery", gallery);
            request.getRequestDispatcher("gallery.jsp").forward(request, response);
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
