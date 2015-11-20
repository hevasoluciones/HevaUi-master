/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.heva.ui.server;

import com.heva.ui.shared.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yguzman
 */
public class DBConnection {

    String bd = "romano";
    String login = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/" + bd;
    Connection conn = null;

    public DBConnection() throws Exception {
        /*
        EnvReader env = new EnvReader();
        bd = env.getProperty("bd");
        login = env.getProperty("login");
        password = env.getProperty("password");
        url = "jdbc:mysql://" + env.getEnvVar("RED_DIGITAL_CLOUD") + "/";
        
        try {

            Class.forName("com.mysql.jdbc.Driver").newInstance();            
            conn = DriverManager.getConnection(url + bd, login, password);

        } catch (SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos " + url);
            throw ex;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
            throw ex;
        }
        */ 
    }

    public void closeConnection() throws SQLException {
        if (conn != null) {
            //System.out.println("Conexión a base de datos " + url + " ... Ok");
            conn.close();
        }
    }

    public static void main(String[] args) throws Exception {
        DBConnection dbConecction = new DBConnection();
    }

    public User getUser(String user, String psw) throws SQLException {
        User newUser = new User();
        /*
         int rolfk = 0;
         Statement s = conn.createStatement();
         String stateStatusQuery = "SELECT *"
         + " FROM usuarios inner join roles on usuarios.rolfk=roles.id"
         + " WHERE login='" + user + "' and password='" + psw + "';";
         ResultSet rs = s.executeQuery(stateStatusQuery);
         if (rs.next()) {
         newUser.setLogin(rs.getString("login"));
         newUser.setRole(rs.getString("nombre"));
         String apellidos = rs.getString("userLastName");
         newUser.setName(rs.getString("userName") + " " + apellidos);            
         newUser.setAuthenticated(true);
         } else {
         newUser.setAuthenticated(false);
         }
        
         //buscar modulos del usuario
         List<String> modulesList = new ArrayList<String>();
         modulesList.add("Almacen");
         newUser.setModules(modulesList);
         */

        newUser.setLogin("yguzman");
        newUser.setRole("admin");
        String apellidos = "Guzman Gonzalez";
        newUser.setName("Yasmani" + " " + apellidos);
        newUser.setEmail("yasmani.guzman@gmail.com");
        newUser.setAuthenticated(true);
        return newUser;
    }
}