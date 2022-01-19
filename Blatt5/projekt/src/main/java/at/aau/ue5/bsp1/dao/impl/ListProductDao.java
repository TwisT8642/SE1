package at.aau.ue5.bsp1.dao.impl;

import java.util.List;

import at.aau.ue5.bsp1.dao.ProductDao;
import at.aau.ue5.bsp1.entity.Product;

public class ListProductDao extends AbstractListDao<Long, Product> implements
		ProductDao {

	public ListProductDao() {
		this.currentId = 1L;
	}

	public List<Product> findAll() {
		return this.list;
	}

	public Product findOne(Long id) {
		for (Product p : this.list) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}

	public Product insert(Product element) {
		element.setId(currentId++);
		this.list.add(element);
		return element;
	}

	public void delete(Long id) {
		Product prod = null;
		for (Product p : this.list) {
			if (p.getId() == id) {
				prod = p;
				break;
			}
		}
		if (prod != null) {
			this.list.remove(prod);
		}
	}

	public Product update(Product element) {
		Product prod = null;
		for (Product c : this.list) {
			if (c.getId() == element.getId()) {
				prod = c;
				break;
			}
		}
		if (prod != null) {
			this.list.remove(prod);
		}
		this.list.add(element);
		return prod;
	}
}
