/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.ContextPath;
import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Gallery;

/**
 *
 * @author green
 */
public class GalleryDAO {
    //get top 3 header gallery
    public ArrayList get3headerGalleries() throws Exception {
        ContextPath contextPath = new ContextPath();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Gallery> listGalleries = new ArrayList<>();
        //sql statement
        String sql = "  Select Top (3) *\n"
                + "  from Gallery";
        DBContext dBContext = new DBContext();
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            //get the 2 galleries out from databse
            while (rs.next()) {
                Gallery n = new Gallery();
                n.setId(rs.getInt("ID"));
                n.setName(rs.getString("Name"));
                n.setDescription(rs.getString("Description"));
                n.setImage(contextPath.getImage() + rs.getString("Image"));
                listGalleries.add(n);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listGalleries;
    }

    //count the number of record and return counted number
    public int GalleryCounter() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //sql statement
        String sql = "  Select count(*)\n"
                + "  from Gallery";
        DBContext dBContext = new DBContext();
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            //get the number of record from database
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return -1;
    }

    //Search and page the records
    public ArrayList<Gallery> listGalleriesInPage(int pageIndex, int pageSize) throws Exception {
        ContextPath contextPath = new ContextPath();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Gallery> listGalleries = new ArrayList<>();
        DBContext dBContext = new DBContext();
        //sql statement
        String sql = "	  Select *\n"
                + "	  From (Select *, ROW_NUMBER() Over (order by ID ASC) as rownum\n"
                + "			From Gallery) Ga \n"
                + "	  Where rownum >= ? and rownum <= ?";
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            //adding search materials to sql statement
            ps.setInt(1, ((pageIndex - 1) * pageSize + 1));
            ps.setInt(2, (pageIndex * pageSize));
            rs = ps.executeQuery();
            //get the searched galleries out from databse
            while (rs.next()) {
                Gallery n = new Gallery();
                n.setId(rs.getInt("ID"));
                n.setName(rs.getString("Name"));
                n.setDescription(rs.getString("Description"));
                n.setImage(contextPath.getImage() + rs.getString("Image"));
                listGalleries.add(n);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listGalleries;
    }
    //cout the gallery's image
    public int imageCounter(int galleryID) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //sql statement
        String sql = "  Select count(*)\n"
                + "  from ImageInGallery where GalleryID = ?";
        DBContext dBContext = new DBContext();
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, galleryID);
            rs = ps.executeQuery();
            //get the number of Gallery's image from database
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return -1;
    }
    //Page the image by page index, pagesize and GID
    public ArrayList<String> listImageInPage(int galleryID, int pageIndex, int pageSize) throws Exception {
        ContextPath contextPath = new ContextPath();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> listImages = new ArrayList<>();
        DBContext dBContext = new DBContext();
        //sql statement
        String sql = "Select *\n"
                + " FROM (Select *,ROW_NUMBER() OVER (Order by ID ASC ) as rownum\n"
                + " FROM ImageInGallery\n"
                + " where GalleryID = ?) Ga\n"
                + " where rownum >= ? and rownum <= ?";
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            //adding search materials to sql statement
            ps.setInt(1, galleryID);
            ps.setInt(2, ((pageIndex - 1) * pageSize + 1));
            ps.setInt(3, (pageIndex * pageSize));
            rs = ps.executeQuery();
            //get the searched news out from databse
            while (rs.next()) {
                listImages.add(contextPath.getImage() + rs.getString("Image"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return listImages;
    }
//get Gallery by ID
    public Gallery getGalleryByID(int galleryID, int pageIndex, int pageSize) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        //sql statement
        Gallery gallery = new Gallery();
        String sql = " select * \n"
                + " FROM Gallery\n"
                + " where ID = ?";
        DBContext dBContext = new DBContext();
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, galleryID);
            rs = ps.executeQuery();
            //get the gallery by ID
            if (rs.next()) {
                gallery.setId(rs.getInt("ID"));
                gallery.setName(rs.getString("Name"));
                gallery.setDescription(rs.getString("Description"));
                gallery.setImage(rs.getString("Image"));
                gallery.setImageList(listImageInPage(galleryID, pageIndex, pageSize));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return gallery;
    }
}
