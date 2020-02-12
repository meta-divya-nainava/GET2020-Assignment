package com.Inventory1;

import java.awt.List;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class InventoryRepository {

    private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private final String DB_URL = "jdbc:mysql://localhost/Book";
    private final String DB_user  = "root";
    private final String DB_PASS = "root";
    private Connection con = null;
    private Statement stm = null;
    private ResultSet rs = null;
    ArrayList<String> list = new ArrayList<String>();
    private static InventoryRepository repo = new InventoryRepository();
    
    
    
    private InventoryRepository(){}
    
    public void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            con = (Connection) DriverManager.getConnection(DB_URL, DB_user,
                    DB_PASS);
        } catch (Exception e) {
            System.out.println("Error : "+e.getMessage());
        }
    }
    public static InventoryRepository getInstance(){
        return repo;
    }

    public void setDataEmployee(Inventory inventory) throws SQLException, IOException{
        PreparedStatement ps = con
                .prepareStatement("insert into Book(BookId, Title, Writer, Publisher, PublisherYear) values(?,?,?,?,?)");
        ps.setInt(1, inventory.getId());
        ps.setString(2, inventory.getTitle());
        ps.setString(3, inventory.getWriter());
        ps.setString(4, inventory.getPublisher());
        ps.setString(5, inventory.getPublisherYear());
        ps.executeUpdate();
        
    }
    
    public ArrayList<Inventory> information() throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT * FROM Book";
        rs =  stm.executeQuery(strQuery);
        ArrayList<Inventory> inventories = new ArrayList<Inventory>();
        while(rs.next()){
            Inventory  object = new Inventory();
            object.setTitle(rs.getString("Title"));
            object.setId(Integer.parseInt(rs.getString("BookId")));
            object.setPublisher(rs.getString("Publisher"));
            object.setPublisherYear(rs.getString("PublisherYear"));
            object.setWriter(rs.getString("Writer"));
            inventories.add(object);
        }
        
        return inventories;
    }
    
    public ArrayList<Inventory> selectInfromation(String title) throws SQLException{
        stm = null;        
        stm = (Statement) con.createStatement();
        String strQuery = "SELECT * FROM Book where Title = '"+title+"'";
        rs = stm.executeQuery(strQuery);
        ArrayList<Inventory> inventories = new ArrayList<Inventory>();
        while(rs.next()){
            Inventory  object = new Inventory();
            object.setTitle(rs.getString("Title"));
            object.setId(Integer.parseInt(rs.getString("BookId")));
            object.setPublisher(rs.getString("Publisher"));
            object.setPublisherYear(rs.getString("PublisherYear"));
            object.setWriter(rs.getString("Writer"));
            inventories.add(object);
        }
        
        return inventories;
    }
    
    public void updateBook(Inventory inventory, String title) throws SQLException, IOException{
        PreparedStatement ps = con
                .prepareStatement("update Book set BookId = ?, Title = ?, Writer = ?, Publisher = ?, PublisherYear = ?"
                        + "where Title = ?");
        ps.setInt(1, inventory.getId());
        ps.setString(2, inventory.getTitle());
        ps.setString(3, inventory.getWriter());
        ps.setString(4, inventory.getPublisher());
        ps.setString(5, inventory.getPublisherYear());
        ps.setString(6, title);
        ps.executeUpdate();
     }
    public void deleteAll() throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("delete from Book");
        ps.executeUpdate();
    }
    
    public void deleteBook(int id) throws SQLException{
        PreparedStatement ps = con
                .prepareStatement("delete from Book where BookId = ?");
        ps.setInt(1, id);
        ps.executeUpdate();
    }
    
    public void close() throws SQLException{
        con.close();
    }
}

