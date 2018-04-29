package fr.eservices.drive.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Category;
import fr.eservices.drive.model.Perishable;

public class CatalogDaoJPAImpl implements CatalogDao {
	EntityManager em;

	public CatalogDaoJPAImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public List<Category> getCategories() {
		TypedQuery<Category> q = em.createQuery("select c from Category c", Category.class);
		throw new RuntimeException("Not yet implemented");
	}

	@Override
	public List<Category> getArticleCategories(int id) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not yet implemented");
	}

	@Override
	public List<Article> getCategoryContent(int categoryId) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not yet implemented");
	}

	@Override
	public List<Perishable> getPerished(Date day) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Not yet implemented");
	}

	
}
