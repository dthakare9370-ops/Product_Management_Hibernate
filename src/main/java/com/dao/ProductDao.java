package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.config.HibernateConfig;
import com.entity.Product;

public class ProductDao {

    SessionFactory sf = HibernateConfig.getSessionFactory();

    // Save Product
    public String save(Product product) {

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        session.persist(product);

        tr.commit();
        session.close();

        return "Product Inserted Successfully!";
    }

    // Get Product By ID
    public Product getProductById(int productId) {

        Session session = sf.openSession();

        Product product = session.get(Product.class, productId);

        session.close();

        return product;
    }

    // Get All Products
    public List<Product> getAllProduct() {

        Session session = sf.openSession();

        List<Product> products =
                session.createQuery("from Product", Product.class).list();

        session.close();

        return products;
    }

    // Update Product
    public String update(Product product) {

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Product existingProduct =
                session.get(Product.class, product.getProductId());

        if (existingProduct == null) {
            session.close();
            return "Product Not Found in Database for Update!";
        }

        existingProduct.setProductName(product.getProductName());
        existingProduct.setUnitPrice(product.getUnitPrice());
        existingProduct.setAvailableQuantity(product.getAvailableQuantity());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setAvailabilityStatus(product.isAvailabilityStatus());

        tr.commit();
        session.close();

        return "Product Updated Successfully!";
    }

    // Delete Product
    public String delete(int productId) {

        Session session = sf.openSession();
        Transaction tr = session.beginTransaction();

        Product product = session.get(Product.class, productId);

        if (product == null) {
            session.close();
            return "Product Not Found in Database for Deletion!";
        }

        session.remove(product);

        tr.commit();
        session.close();

        return "Product Deleted Successfully!";
    }
}