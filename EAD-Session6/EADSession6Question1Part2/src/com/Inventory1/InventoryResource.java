package com.Inventory1;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Inventory")
public class InventoryResource{

    InventoryRepository repo=InventoryRepository.getInstance();
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Inventory> getInventories() throws SQLException
    {
        repo.connection();
        return repo.information();
    }

    @GET
    @Path("/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Inventory> getInventory(@PathParam("title") String name) throws SQLException
    {
            repo.connection();
            return repo.selectInfromation(name);
    }

    @POST
    public void createInventory(Inventory object) throws SQLException, IOException
    {
        repo.connection();
        repo.setDataEmployee(object);
    }
    
    @PUT
    @Path("/{title}")
    @Produces({MediaType.APPLICATION_JSON})
    public void updateInventory( @PathParam("title") String name ,Inventory object) throws SQLException, IOException
    {
        repo.connection();
        repo.updateBook(object, name);
    }
    
    @DELETE
    public void deleteInventory() throws SQLException
    {
        repo.connection();
        repo.deleteAll();
            
    }
   
    @DELETE
    @Path("/{name}")
    public void deleteBook(@PathParam("name") int id) throws SQLException
    {
        repo.connection();
        repo.deleteBook(id);
    }
    
}
