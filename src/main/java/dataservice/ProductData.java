package dataservice;

import model.Product;

import java.util.List;

public interface ProductData {
    void add (Product p);

    Product searchById(int id);

    List<Product> search(String search);

    boolean remove(int id);

    boolean update(int id, Product p);

    List<Product> findAll();
}
