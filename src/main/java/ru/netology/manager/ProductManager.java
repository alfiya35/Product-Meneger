package ru.netology.manager;

import ru.netology.domian.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {

    protected Product[] products = new Product[0];

    protected ProductRepository repository;



    public ProductManager(ProductRepository repository) { //конструкторы
        this.repository = repository;

    }
    public ProductManager(){

    }

    public ProductRepository getRepository() {
        return repository;
    }

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public void add(Product product) { //метод добавления продуктов в репозиторий
        repository.add(product);
    }

    public void removeById(int id) { //метод удвления продуктов
        repository.removeById(id);
    }

    public Product[] getAll() { //метод получения всех сохраненных продуктов
        Product[] products = repository.findAll();

        return products;
    }

    // метод определения соответствия товара product запросу search
    public boolean matches(Product product, String search) {
        if (product.getTitle().contains(search)) {  // если текущий продукт содержит поиск
            return true;
        } else {
            return false;
        }
    }

    public Product[] searchBy(String text) { //метод ("искать по"),возвращения массива найденных товаров
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        for (Product product : repository.findAll()) {
            if (matches(product, text)) {
//                result[result.length-1] = product;
                Product[] tmp = new Product[result.length + 1];//создаем новый массив на 1ячейку больше
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }


}

