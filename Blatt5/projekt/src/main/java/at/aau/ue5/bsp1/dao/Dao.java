package at.aau.ue5.bsp1.dao;

import java.util.List;


public interface Dao<S,T> {
	public T findOne(S id);
	public List<T> findAll();
	public T insert(T element);
	public void delete(S id);
	public T update(T element);
}
