package fr.eservices.drive.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Category;
import fr.eservices.drive.model.Perishable;
import org.hibernate.annotations.Parameter;
import sun.rmi.runtime.Log;

public class CatalogDaoJPAImpl implements CatalogDao {
	EntityManager em;

	public CatalogDaoJPAImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Category> getCategories() {
		List<Category> categories = em.createQuery("from Category order by orderIdx", Category.class).getResultList();
		return categories;
	}

	@Override
	public List<Category> getArticleCategories(int id) throws DataException{
		Article article = em.find(Article.class, id);
		if (article == null)
			throw new DataException("Nope");
		return article.getCategories();
	}

	@Override
	public List<Article> getCategoryContent(int categoryId) throws DataException{
		if (em.find(Category.class, categoryId) == null)
			throw new DataException("Category does not exist");
		Query query = em.createQuery("select a from Article a join a.categories c where c.id = :id", Article.class);
		query.setParameter("id", categoryId);
		List<Article> articles = query.getResultList();

		return articles == null ? new ArrayList<>() : articles;
	}

	@Override
	public List<Perishable> getPerished(Date day) throws DataException{
		List<Perishable> perishables;
		 Query query = em.createQuery("select p from Perishable p where p.bestBefore <= :day", Perishable.class);
		 query.setParameter("day", day);
		 perishables = query.getResultList();
		 if (perishables.size() >= 200)
		 	throw new DataException("To many results");
		return perishables;
	}

	
}
