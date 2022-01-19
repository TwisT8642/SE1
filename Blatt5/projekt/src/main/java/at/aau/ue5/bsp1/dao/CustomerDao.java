package at.aau.ue5.bsp1.dao;

import java.util.List;

import at.aau.ue5.bsp1.entity.Customer;

public interface CustomerDao extends Dao<Long, Customer> {
	public List<Customer> findCustomerByName(String name);
}
