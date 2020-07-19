package com.cg.bookStore.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.cg.bookStore.entity.BookInformation;

@Repository
public class ListBookInCategoryDaoImpl implements ListBookInCategoryDao{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<BookInformation> viewBooksInCategory(int categoryId) {
		String jpql = "from BookInformation binfo inner join fetch binfo.category c where c.categoryId=:cid";
		TypedQuery<BookInformation> query = em.createQuery(jpql, BookInformation.class);
		query.setParameter("cid", categoryId);
		return query.getResultList();
	}

}
