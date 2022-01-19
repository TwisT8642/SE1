package at.aau.ue5.bsp1.dao.impl;

import java.util.ArrayList;
import java.util.List;

public class AbstractListDao<S, T> {
	protected List<T> list=new ArrayList<T>();
	protected S currentId;
}
