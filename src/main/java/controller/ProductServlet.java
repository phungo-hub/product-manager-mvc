package controller;

import dataservice.ProductData;
import dataservice.ProductDataFake;
import model.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {
    public static final int TOTAL_PER_PAGE = 5;
    ProductData productData = new ProductDataFake();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                showAddProduct(req, res);
                break;
            case "edit":
                showEditProduct(req, res);
                break;
            case "delete":
                showDeleteProduct(req, res);
                break;
            default:
                showProductDB(req, res);
                break;
        }
    }

    private void showDeleteProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product p = this.productData.searchById(id);
        if (p != null) {
            req.setAttribute("product", p);
            RequestDispatcher dispatcher = req.getRequestDispatcher("delete.jsp");
            dispatcher.forward(req, res);
        }
    }

    private void showEditProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Product p = this.productData.searchById(id);
        req.setAttribute("product", p);
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }

    private void showAddProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
        dispatcher.forward(req, res);
    }

    private void showProductDB(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String search = req.getParameter("search");
        List<Product> products;
        if (search != null) {
            products = this.productData.search(search);
        } else {
            products = this.productData.findAll();
        }

        String pageIds = req.getParameter("page");
        List<Product> newProduct = addCustomerPagination(products, pageIds);

        req.setAttribute("products", newProduct);
        req.setAttribute("totalPage", products.size() / TOTAL_PER_PAGE + 1);
        RequestDispatcher dispatcher = req.getRequestDispatcher("list.jsp");
        dispatcher.forward(req, res);
    }

    private static List<Product> addCustomerPagination(List<Product> products, String pageIds) {
        int pageId;
        if (pageIds == null)
            pageId = 1;
        else {
            pageId = Integer.parseInt(pageIds);
        }

        List<Product> newProducts = new ArrayList<>();

        for (int i = (pageId - 1) * TOTAL_PER_PAGE; (i < pageId*TOTAL_PER_PAGE) && (i < products.size()); i++) {
            newProducts.add(products.get(i));
        }
        return newProducts;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null)
            action = "";
        switch (action) {
            case "add":
                addProduct(req, res);
                break;
            case "edit":
                editProduct(req, res);
                break;
            case "delete":
                deleteProduct(req, res);
                break;
            default:
                showProductDB(req, res);
                break;
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        this.productData.remove(id);
        res.sendRedirect("/products");
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        int id = Integer.parseInt(req.getParameter("id"));

        Product p = new Product(id, name, desc, price);
        this.productData.update(id, p);
        req.setAttribute("message","Customer has been edited successfully!!!!!!!!!!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("edit.jsp");
        dispatcher.forward(req, res);
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name = req.getParameter("name");
        String desc = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        int id = (int) (Math.random() * 1000);

        Product newProd = new Product(id, name, desc, price);
        this.productData.add(newProd);
        req.setAttribute("message", "message has been added successfully");

        RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
        dispatcher.forward(req, res);
    }
}
