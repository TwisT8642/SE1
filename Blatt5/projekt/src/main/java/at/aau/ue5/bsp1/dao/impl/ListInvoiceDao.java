package at.aau.ue5.bsp1.dao.impl;

import java.util.List;

import at.aau.ue5.bsp1.dao.InvoiceDao;
import at.aau.ue5.bsp1.entity.Invoice;

public class ListInvoiceDao extends AbstractListDao<Long, Invoice> implements
		InvoiceDao {

	public ListInvoiceDao() {
		this.currentId = 1L;
	}

	public List<Invoice> findAll() {
		return this.list;
	}

	public Invoice findOne(Long id) {
		for (Invoice i : this.list) {
			if (i.getId() == id) {
				return i;
			}
		}
		return null;
	}

	public Invoice insert(Invoice element) {
		element.setId(currentId++);
		this.list.add(element);
		return element;
	}

	public void delete(Long id) {
		Invoice inv = null;
		for (Invoice i : this.list) {
			if (i.getId() == id) {
				inv = i;
				break;
			}
		}
		if (inv != null) {
			this.list.remove(inv);
		}
	}

	public Invoice update(Invoice element) {
		Invoice inv = null;
		for (Invoice c : this.list) {
			if (c.getId() == element.getId()) {
				inv = c;
				break;
			}
		}
		if (inv != null) {
			this.list.remove(inv);
		}
		this.list.add(element);
		return inv;
	}
}
