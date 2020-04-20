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
import model.Information;

/**
 *
 * @author green
 */
public class InformationDAO {
    //get Informattion from database
    public Information getinformation() throws Exception {
        ContextPath contextPath = new ContextPath();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Information n = new Information();
        //sql statement
        String sql = "  Select Top (1) *\n"
                + "  from Information";
        DBContext dBContext = new DBContext();
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            //get the Information out from databse
            while (rs.next()) {
                n.setAbout(rs.getString("About"));
                n.setSortAbout(rs.getString("ShortAbout"));
                n.setImage(contextPath.getImage() + rs.getString("Image"));
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close all connection
            dBContext.closeAll(connection, ps, rs);
        }
        return n;
    }
}
