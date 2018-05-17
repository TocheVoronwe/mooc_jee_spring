package fr.eservices.drive.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
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
	public List<Category> getArticleCategories(int id) {
		// TODO Auto-generated method stub
		System.out.println("before getArticleCategories");
		List<Category> categories = em.createQuery("select categories from Article", Category.class).getResultList();
		System.out.println("after getArticleCategories");
		return categories;
	}

	@Override
	public List<Article> getCategoryContent(int categoryId) {
		System.out.println("before getCategoryContent");
		List<Article> articles = em.createQuery("from Article where Article.categories.id = :id", Article.class).getResultList();
		System.out.println("after getCategoryContent");
		return articles;
	}

	@Override
	public List<Perishable> getPerished(Date day) {
		List<Perishable> perishables = em.createQuery("from Perishable  where Perishable.bestBefore < :day", Perishable.class).getResultList();
		return perishables;
	}

	
}
