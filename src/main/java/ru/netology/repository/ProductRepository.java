package ru.netology.repository;

import ru.netology.domian.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public ProductRepository() { //Конструктор

    }
//    public ProductRepository(Product[] products){ //Конструктор
//        this.products = products;


    public Product[] getProducts() { //Геттеры и Сеттеры
        return products;
    }

//    public void setProducts(Product[] products) {
//        this.products = products;


    public void add(Product product) { //метод добавления(сохранения) продукта
        Product[] tmp = new Product[products.length + 1];//создаем новый массив
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;//заполнение последней ячейки
        products = tmp;
    }

    public Product[] findAll() {  //метод получения всех сохраненных продуктов
        return getProducts();
    }

    public Product[] findById(int id) {
        Product[] tmp = new Product[products.length];
        for (int i = 0; i < products.length + 1; i++) {
            if (i == id) {
                return products;
            }
        }
        return null;
    }

    public String removeById(int id) {//метод удаления по id
        if (findById(id) == null) {
            throw new NotFoundException("Element with id: " + id + " not found");
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length]; //создаем массив на одну ячейку меньше
        int index = 0; //номер ячейки в которую будем копировать
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
            products = tmp;
        }
        return null;
    }
}




