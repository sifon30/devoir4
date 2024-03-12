package com.saif.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.saif.entities.Montre;
import com.saif.util.JPAutil;
//classe contenant les méthodes génériques ajouter, supprimer,
//consulter par clé primaire (Id)
public class MontreDao {
	private EntityManager entityManager=JPAutil.getEntityManager("MonProjetJPA");
	//méthode ajouter d'une entité à la bd
	public void ajouter(Montre m)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.persist(m);
		tx.commit();
	}
	//méthode modifier d'une entité à partir de la bd
	public void modifier(Montre m)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		entityManager.merge(m);
		tx.commit();
	}
	//méthode Supprimer d'une entité à partir de la bd
	public void supprimer(Montre m)
	{
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		m=entityManager.merge(m); // important
		entityManager.remove(m);
		tx.commit();
	}
	//méthode Consulter d'une entité à partir de la bd
	public Montre consulter(Montre m,Object id)
	{
		return entityManager.find(m.getClass(), id);
	}
	//méthode pour lister tous les objets à partir de la bd
	public List<Montre> listerTous() {
		List<Montre> montres =
				entityManager.createQuery(
						"select m from Montre m").getResultList();

		return montres;
	}
	//méthode pour lister tous les Montre dont le nom contient un
	//texte donné en paramètre (pnom)
	public List<Montre> listerParNom(String nom) {List<Montre> montres
		=entityManager.createQuery( "select m from Montre m where m.nom like :pnom")
		.setParameter("pnom","%"+nom+"%").getResultList();

	return montres; }}