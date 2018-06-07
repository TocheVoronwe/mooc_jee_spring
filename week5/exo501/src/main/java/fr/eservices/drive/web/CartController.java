package fr.eservices.drive.web;

import fr.eservices.drive.dao.CartDao;
import fr.eservices.drive.dao.DataException;
import fr.eservices.drive.dao.OrderDao;
import fr.eservices.drive.mock.ArticleMockDao;
import fr.eservices.drive.model.Article;
import fr.eservices.drive.model.Cart;
import fr.eservices.drive.model.Order;
import fr.eservices.drive.repository.OrderRepository;
import fr.eservices.drive.web.dto.CartEntry;
import fr.eservices.drive.web.dto.SimpleResponse;
import fr.eservices.drive.web.dto.SimpleResponse.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.Data;
import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/cart")
public class CartController {

    @Autowired
    CartDao daoCart;

    @Autowired
    OrderRepository daoOrder;
    @Autowired
    ArticleMockDao articleMockDao;

    @ExceptionHandler(DataException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String dataExceptionHandler(Exception ex) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintWriter w = new PrintWriter(out);
        ex.printStackTrace(w);
        w.close();
        return
                "ERROR"
                        + "<!--\n" + out.toString() + "\n-->";
    }

    @GetMapping(path = "/{id}.html", produces = "text/html")
    public String getCart(@PathVariable(name = "id") int id, Model model) throws DataException {
        if (id <= 0)
            throw new DataException("Id should be a real one");
        Cart cart = daoCart.getCartContent(id);
        model.addAttribute("cart", cart);
        return "_cart_header";
        // get cart from dao
        // assign to model var "cart"
        // return view name to display content of /WEB-INF/views/_cart_header.jsp
    }

    private SimpleResponse _error(String message) {
        SimpleResponse res = new SimpleResponse();
        res.status = Status.ERROR;
        res.message = message;
        return res;
    }

    private SimpleResponse _success(String message) {
        SimpleResponse res = new SimpleResponse();
        res.status = Status.OK;
        res.message = message;
        return res;
    }

    @ResponseBody
    @PostMapping(path = "/{id}/add.json", consumes = "application/json")
    public SimpleResponse add(@PathVariable(name = "id") int id, @RequestBody CartEntry art) throws DataException {
        if (daoCart.getCartContent(id) == null)
            daoCart.store(id, new Cart());
        if (art == null || art.getQty() < 0)
            return _error("quantity < 0");
        for (int i = 0; i < art.getQty() && art.getQty() > 0; i++) {
            Article article = articleMockDao.find(art.getId());
            if (article == null)
                return _error("Article not found");
            daoCart.getCartContent(id).getArticles().add(article);
        }

        return _success("********************\n"
                + "***** " + String.format("Add Article %d x [%s] to cart", art.getQty(), art.getId()) + "\n"
                + "********************");
    }

    @RequestMapping("/{id}/validate.html")
    public String validateCart(@PathVariable(name = "id") int id, Model model) throws DataException {

        // get cart by its id
        // create an order
        // for each article, add it to the order
        // set order date
        // set order amount (sum of each articles' price)
        // persist everything
        // redirect user to list of orders
        Order order = new Order();
        Cart cart = daoCart.getCartContent(id);
        if (cart == null)
            throw new DataException("No Article");
        ArrayList<String> articles = new ArrayList<>();

        cart.getArticles().forEach(article -> {
            articles.add(article.getId());
            order.setAmount(order.getAmount() + article.getPrice());
        });
        /*for (Article article : cart.getArticles())
        {
            articles.add(article.getId());
            order.setAmount(order.getAmount() + article.getPrice());
        }*/

        System.out.println(articles.toString());
        order.setArticles(articles);
        order.setCreatedOn(new Date());
        order.setCustomerId("chuckNorris");
        order.setCurrentStatus(fr.eservices.drive.dao.Status.ORDERED);
        model.addAttribute(order);
        daoOrder.save(order);
        return "redirect:/order/ofCustomer/checkNorris.html";
    }
}
