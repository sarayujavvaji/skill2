package com.inventory.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.inventory.entity.Product;
import com.inventory.util.HibernateUtil;

public class HQLDemo {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        // HQL Query to fetch all products
        String hql = "FROM Product";

        Query<Product> query = session.createQuery(hql, Product.class);

        List<Product> products = query.list();

        for (Product p : products) {
            System.out.println(
                    p.getId() + " " +
                    p.getName() + " " +
                    p.getDescription() + " " +
                    p.getPrice() + " " +
                    p.getQuantity()
            );
        }

        session.close();
    }
}