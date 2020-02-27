package com.Inventory;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/inventory")
public class InventoryResource {
	
	InventoryRepository repo=InventoryRepository.getInstance();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public List<Inventory> getInventories()
	{
		return repo.getInventories();
	}

	@GET
	@Path("/{name}")
	@Produces({MediaType.APPLICATION_JSON})
	public Inventory getInventory(@PathParam("name") String name)
	{
		return repo.getInventory(name);
	}

	@POST
	@Produces({MediaType.APPLICATION_JSON})
	public Inventory createInventory(Inventory object)
	{
		repo.create(object);
		return object;
	}
	
	@PUT
	public List<Inventory> updateInventory(Inventory object)
	{
		repo.update(object);
		return repo.getInventories();
	}
	
	@PUT
	@Path("/{name}")
	public Inventory updateOneInventory(@PathParam("name") String name,Inventory object)
	{
		Inventory object1=repo.updateOne(name,object);
		return object1;
	}
	
	@DELETE
	public List<Inventory> deleteInventory()
	{
		repo.deleteAll();
		return repo.getInventories();
	}
	
	@DELETE
	@Path("/{name}")
	public Inventory deleteOneInventory(@PathParam("name") String name)
	{
		Inventory object=repo.getInventory(name);
		repo.deleteOne(name);
		return object;
	}

}
