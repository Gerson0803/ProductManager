package edu.unac;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    void testAddAndGetProduct() {
        ProductManager manager = new ProductManager();
        Product p = new Product("1", "Laptop", "Electronics", 1200.0);
        manager.addProduct(p);

        Product result = manager.getProductById("1");
        assertNotNull(result);
        assertEquals("Laptop", result.getName());
    }

    @Test
    void testDuplicateIdThrowsException() {
        ProductManager manager = new ProductManager();
        Product p1 = new Product("1", "Laptop", "Electronics", 1200.0);
        Product p2 = new Product("1", "Tablet", "Electronics", 800.0);

        manager.addProduct(p1);
        assertThrows(IllegalArgumentException.class, () -> manager.addProduct(p2));
    }

    @Test
    void testRemoveProduct() {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("1", "Laptop", "Electronics", 1200.0));
        manager.removeProduct("1");

        assertNull(manager.getProductById("1"));
    }

    @Test
    void testGetProductsByCategory() {
        ProductManager manager = new ProductManager();
        manager.addProduct(new Product("1", "Laptop", "Electronics", 1200.0));
        manager.addProduct(new Product("2", "Shirt", "Clothing", 40.0));

        List<Product> electronics = manager.getProductsByCategory("Electronics");
        assertEquals(1, electronics.size());
        assertEquals("Laptop", electronics.get(0).getName());
    }

    @Test
    void testListAllProducts() {
        ProductManager manager = new ProductManager();
        Product p1 = new Product("1", "Laptop", "Electronics", 1200.0);
        Product p2 = new Product("2", "Shirt", "Clothing", 40.0);
        Product p3 = new Product("3", "Book", "Education", 25.0);

        manager.addProduct(p1);
        manager.addProduct(p2);
        manager.addProduct(p3);

        List<Product> allProducts = manager.listAll();

        assertEquals(3, allProducts.size());
        assertTrue(allProducts.contains(p1));
        assertTrue(allProducts.contains(p2));
        assertTrue(allProducts.contains(p3));
    }
    @Test
    void testGetProductsByPrice() {
        ProductManager gestor = new ProductManager();

        Product prod1 = new Product("1", "Telefono", "Tecnología", 850.0);
        Product prod2 = new Product("2", "Cuaderno", "Papeleria", 15.0);
        Product prod3 = new Product("3", "Esfero", "Papeleria", 5.0);
        Product prod4 = new Product("4", "Cable", "Accesorios", 10.0);

        gestor.addProduct(prod1);
        gestor.addProduct(prod2);
        gestor.addProduct(prod3);
        gestor.addProduct(prod4);

        List<Product> resultado = gestor.getProductsByPriceRange(5.0, 15.0);

        assertEquals(3, resultado.size());
        assertTrue(resultado.contains(prod2));
        assertTrue(resultado.contains(prod3));
        assertTrue(resultado.contains(prod4));
    }


}