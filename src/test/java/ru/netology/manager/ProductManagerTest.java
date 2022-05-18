package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domian.Book;
import ru.netology.domian.Product;
import ru.netology.domian.Smartphone;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Book book1 = new Book(1, "Тихий дон", "Шолохов", 150);
    Book book2 = new Book(2, "Стихи", "Пушкин", 250);
    Book book3 = new Book(3, "Собрание сочинений", "Цветаева", 300);
    Smartphone phone1 = new Smartphone(4, "Нокиа", 4500, "Китай");
    Smartphone phone2 = new Smartphone(5, "Нокиа", 8500, "Япония");


    @Test
    public void shouldSave() {   //тест на метод добавления продукта
        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{book1, book2, book3};


        assertArrayEquals(actual, expected);
    }


    @Test
    public void shouldDefineMatchesTrue() {
        ProductManager manager = new ProductManager();

        String search = "Тихий дон";
        Product book1 = new Book(1, "Тихий дон", "Шолохов", 150);

        Boolean expected = true;//ожидаемый
        Boolean actual = manager.matches(book1, search); //фактический

        assertEquals(expected, actual);
    }

    @Test
    public void shouldDefineMatchesFalse() {
        ProductManager manager = new ProductManager();

        String search = "Стихи";
        Product book1 = new Book(1, "Тихий дон", "Шолохов", 150);

        Boolean expected = false;//ожидаемый
        Boolean actual = manager.matches(book1, search); //фактический

        assertEquals(expected, actual);
    }


    @Test
    public void shouldFindTheFoundGoods() {

        ProductManager manager = new ProductManager();

        manager.save(book1);
        manager.save(book2);

        Product[] actual = manager.searchBy("Тихий дон");
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldFindTheFoundGoodsMore() {

        ProductManager manager = new ProductManager();

        manager.save(book1);
        manager.save(book2);
        manager.save(book3);
        manager.save(phone1);
        manager.save(phone2);

        Product[] actual = manager.searchBy("Нокиа");
        Product[] expected = {phone1, phone2};

        assertArrayEquals(expected, actual);


    }

    @Test
    public void shouldRemoveById() {   //тест на метод удаления существ.продукта

        ProductManager manager = new ProductManager();

        manager.save(book1);
        manager.save(book2);
        manager.save(phone1);

        manager.remove(1);

        Product[] actual = manager.getAll();
        Product[] expected = {book2, phone1};

        assertArrayEquals(actual, expected);

    }

    @Test
    public void shouldRemoveNonExistentProduct() {   //тест на метод удаления существ.продукта

        ProductRepository repository = new ProductRepository();
        repository.add(book1);
        repository.add(book2);
        repository.add(book3);

        repository.removeById(10);

        assertThrows(NotFoundException.class, () -> {repository.removeById(13);});
    }
}