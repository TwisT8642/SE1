package at.aau.ue5.bsp1.dao.impl;

import java.util.ArrayList;
import java.util.List;

import at.aau.ue5.bsp1.dao.CustomerDao;
import at.aau.ue5.bsp1.entity.Customer;

public class ListCustomerDao extends AbstractListDao<Long, Customer> implements
		CustomerDao {

	public ListCustomerDao() {
		this.currentId = 1L;
	}

	public List<Customer> findAll() {
		return this.list;
	}

	public Customer findOne(Long id) {
		for (Customer c : this.list) {
			if (c.getId() == id) {
				return c;
			}
		}
		return null;
	}

	public Customer insert(Customer element) {
		element.setId(currentId++);
		this.list.add(element);
		return element;
	}

	public void delete(Long id) {
		Customer cust = null;
		for (Customer c : this.list) {
			if (c.getId() == id) {
				cust = c;
				break;
			}
		}
		if (cust != null) {
			this.list.remove(cust);
		}
	}

	public Customer update(Customer element) {
		Customer cust = null;
		for (Customer c : this.list) {
			if (c.getId() == element.getId()) {
				cust = c;
				break;
			}
		}
		if (cust != null) {
			this.list.remove(cust);
		}
		this.list.add(element);
		return cust;
	}

	public List<Customer> findCustomerByName(String name) {
		List<Customer> l = new ArrayList<Customer>();
		for (Customer c : this.list) {
			if (name.equals(c.getName())) {
				l.add(c);
			}
		}
		return l;
	}

}
