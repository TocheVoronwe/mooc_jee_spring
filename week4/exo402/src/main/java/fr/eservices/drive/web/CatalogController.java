package fr.eservices.drive.web;

import fr.eservices.drive.dao.CatalogDao;
import fr.eservices.drive.dao.DataException;
import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


// set as a Controller
// map to an url starting with "/catalog"
@Controller()
@RequestMapping(path="/catalog")
public class CatalogController {

    // Inject this with spring
    @Autowired
    CatalogDao dao;

    // Map this method to "categories.html"
    @RequestMapping(path="/categories.html")
    public String list(Model model) throws DataException {
        List<Category> categories = dao.getCategories();
        // add categories to model
        // return the view name
        model.addAttribute("categories", categories);
        System.err.println("model == " + model.toString());
        return "categories.jsp";
/*        throw new RuntimeException("Not yet implemented");*/
    }

    // Map this method to "category/ID_CATEGORY.html"
    @RequestMapping(path="/category/{id}/.html")
    public String categoryContent(Model model,
                                  @PathVariable("id")
                                  // Inject this parameter from url variable
                                  int id)
            throws DataException {
        List<Article> articles = dao.getCategoryContent(id);
        model.addAttribute("articles", articles);
        // add articles to model
        // return the view name
        return "category.jsp";
/*        throw new RuntimeException("Not yet implemented");*/
    }

}
