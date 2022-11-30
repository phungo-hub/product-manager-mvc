package dataservice;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDataFake implements ProductData{
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "sua ong tho", "sua tuoi nguyen chat", 25.00));
        products.add(new Product(2, "gói đăng ký OnlyFan", "giải trí", 50.00));
        products.add(new Product(3, "Admin Bootstrap", "code bootstrao xịn nhất", 49.00));
        products.add(new Product(4, "The Witcher 3", "MMORPG", 9.99));
        products.add(new Product(1, "sua ong tho", "sua tuoi nguyen chat", 25.00));
        products.add(new Product(2, "gói đăng ký OnlyFan", "giải trí", 50.00));
        products.add(new Product(3, "Admin Bootstrap", "code bootstrao xịn nhất", 49.00));
        products.add(new Product(4, "The Witcher 3", "MMORPG", 9.99));
        products.add(new Product(1, "sua ong tho", "sua tuoi nguyen chat", 25.00));
        products.add(new Product(2, "gói đăng ký OnlyFan", "giải trí", 50.00));
        products.add(new Product(3, "Admin Bootstrap", "code bootstrao xịn nhất", 49.00));
        products.add(new Product(4, "The Witcher 3", "MMORPG", 9.99));
        products.add(new Product(1, "sua ong tho", "sua tuoi nguyen chat", 25.00));
        products.add(new Product(2, "gói đăng ký OnlyFan", "giải trí", 50.00));
        products.add(new Product(3, "Admin Bootstrap", "code bootstrao xịn nhất", 49.00));
        products.add(new Product(4, "The Witcher 3", "MMORPG", 9.99));
    }

    @Override
    public void add(Product p) {
        products.add(p);
    }

    @Override
    public Product searchById(int id) {
        for (Product p: products)
            if (p.getId() == id)
                return p;
        return null;
    }


    @Override
    public boolean remove(int id) {
        Product p = searchById(id);
        if (p != null)
            products.remove(p);
        return false;
    }

    @Override
    public boolean update(int id, Product p) {
        Product searchP = searchById(id);
        if (searchP != null) {
            searchP.setName(p.getName());
            searchP.setDesc(p.getDesc());
            searchP.setPrice(p.getPrice());
            return true;
        }
        return false;
    }

    @Override
    public List<Product> search(String search) {
        List<Product> newProducts = new ArrayList<>();

        for (Product p: products) {
            String searchLowercase = search.toLowerCase();
            boolean checkId = Integer.toString(p.getId()).contains(search);
            boolean checkName = p.getName().toLowerCase().contains(searchLowercase);
            boolean checkDesc = p.getDesc().toLowerCase().contains(searchLowercase);
            boolean checkPrice = Double.toString(p.getPrice()).contains(search);
            if (checkId || checkName || checkDesc || checkPrice) {
                newProducts.add(p);
            }
        }
        return newProducts;
    }
    @Override
    public List<Product> findAll() {
        return products;
    }
}
