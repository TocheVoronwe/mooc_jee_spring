package fr.eservices.drive.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Category;
import fr.eservices.drive.model.Perishable;
import org.hibernate.annotations.Parameter;

public class CatalogDaoJPAImpl implements CatalogDao {
	EntityManager em;

	public CatalogDaoJPAImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Category> getCategories() {
		System.out.println("before getCategories");
		List<Category> categories = em.createQuery("from Category order by orderIdx", Category.class).getResultList();
		System.out.println("after getCategories");
		return categories;
	}

	@Override
	public List<Category> getArticleCategories(int id) throws DataException{
		// TODO Auto-generated method stub
		Article article = em.find(Article.class, id);
		if (article == null)
			throw new DataException("Nope");
		return article.getCategories();
	}

	@Override
	public List<Article> getCategoryContent(int categoryId) {
		System.out.println("before getCategoryContent");
		Query query = em.createQuery("from Article join Category on Category.id = :id", Article.class);
		query.setParameter("id", categoryId);
		List<Article> articles = query.getResultList();

		System.out.println("after getCategoryContent");
		return articles;
	}

	@Override
	public List<Perishable> getPerished(Date day) {
		List<Perishable> perishables = em.createQuery("from Perishable  where Perishable.bestBefore < :day", Perishable.class).getResultList();
		return perishables;
	}

	
}
