/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.toolsmanager2.dataaccess;

import com.mycompany.toolsmanager2.models.Eina;
import com.mycompany.toolsmanager2.models.Usuari;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Diego Ramirez
 */
public class DataAccess {
    
    public Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            properties.load(DataAccess.class.getClassLoader().getResourceAsStream("application.properties"));
            connection = DriverManager.getConnection(properties.getProperty("url"));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return connection;
    }
    
    public ArrayList<Usuari> getUsers() {
        ArrayList<Usuari> users = new ArrayList<>();
        try (Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "SELECT * FROM dbo.[usuaris]"
            );
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Usuari user = new Usuari(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("llinatge"),
                        resultSet.getString("username"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("foto"),
                        resultSet.getString("fotoMimeType")
                );
                user.setId(resultSet.getInt("id"));
                users.add(user);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return users;
    }
    
     public int insertUser(Usuari user) {

        try (Connection connection = getConnection();) {

            PreparedStatement insertStatement = connection.prepareStatement(
                    "INSERT INTO dbo.[usuaris] (nom, llinatge, username, email, password,foto, fotoMimeType) "
                    + "VALUES (?,?,?,?,?,?,?)");
            insertStatement.setString(1, user.getNom());
            insertStatement.setString(2, user.getLlinatge());
            insertStatement.setString(3, user.getUsername());
            insertStatement.setString(4, user.getEmail());
            insertStatement.setString(5, user.getPassword());
            insertStatement.setString(6, user.getFoto());
            insertStatement.setString(7, user.getFotoMimeType());

            int result = insertStatement.executeUpdate();

            if (result > 0) {
                PreparedStatement selectStatement = connection.prepareStatement(
                        "SELECT MAX(id) AS newId FROM dbo.[usuaris]");
                ResultSet resultSet = selectStatement.executeQuery();
                if (!resultSet.next()) {
                    return 0;
                }
                return resultSet.getInt("newId");
            }

            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
    
        public ArrayList<Eina> getTools(int usuariId) {
        ArrayList<Eina> tools = new ArrayList<>();
        try ( Connection connection = getConnection()) {
            PreparedStatement selectStatement = connection.prepareStatement(
                    "SELECT * FROM dbo.Inventari JOIN dbo.[tools]"
                            + " ON Inventari.id_eina=tools.id"
                            + " WHERE Inventari.id_usuari=?"
            );
            selectStatement.setInt(1, usuariId);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                Eina tool = new Eina(
                        resultSet.getInt("id"),
                        resultSet.getString("nom"),
                        resultSet.getString("foto"),
                        resultSet.getString("tipomimefoto")
                );
                tools.add(tool);

            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }

        return tools;
    }
}
    
