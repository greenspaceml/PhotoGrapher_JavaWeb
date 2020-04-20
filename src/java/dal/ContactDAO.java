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
import model.Contact;

/**
 *
 * @author green
 */
public class ContactDAO {
    //get all Contact information
    public Contact getContact() throws Exception {
        ContextPath contextPath = new ContextPath();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Contact n = new Contact();
        //sql statement
        String sql = "select * from Contact";
        DBContext dBContext = new DBContext();
        try {
            //trying connect to database
            connection = dBContext.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            //get the Contact out from databse
            while (rs.next()) {
                n.setName(rs.getString("Name"));
                n.setAddress(rs.getString("Address"));
                n.setCity(rs.getString("City"));
                n.setCountry(rs.getString("Country"));
                n.setPhone(rs.getInt("Telephone"));
                n.setEmail(rs.getString("Email"));
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
