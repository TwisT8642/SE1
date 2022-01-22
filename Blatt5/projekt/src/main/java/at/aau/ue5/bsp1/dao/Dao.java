package at.aau.ue5.bsp1.dao;

import java.util.List;


public interface Dao<S,T> {
	T findOne(S id);
	List<T> findAll();
	T insert(T element);
	void delete(S id);
	T update(T element);
}
