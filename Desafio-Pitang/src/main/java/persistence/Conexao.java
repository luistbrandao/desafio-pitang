package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class Conexao {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pitang");
	private EntityManager em = emf.createEntityManager();
	private EntityTransaction et = em.getTransaction();
	
	private static Conexao c = null;
	
	public EntityManagerFactory getEmf() {
		return emf;
	}
	
	public EntityManager conectarEntityManager() {
		return em;
	}
	
	public EntityTransaction conectarTrans() {
		return et;
	}
	
	
	public Conexao() {
		et.begin();
	}
	
	public static Conexao getCurrentInstance(){
        if(c == null)
            c = new Conexao();
        
        return c;
    }

	
}
