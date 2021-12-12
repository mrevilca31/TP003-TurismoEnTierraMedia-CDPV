package persistenciaGeneral;

import java.util.List;

public interface GenericDAO<T> {

	public int insert(T t);

	public int update(T t);

	public int delete(Integer id);

	public int countAll();

	public T find(Integer id);

	public List<T> findAll();
}