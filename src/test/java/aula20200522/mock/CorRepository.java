package aula20200522.mock;

public interface CorRepository {

	Cor findById(String id);

	void save(Cor cor);
	
	void rollback();

	void commit();

}
