package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domian.Book;
import ru.netology.domian.Product;
import ru.netology.domian.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    Book book1 = new Book(1, "Тихий дон", "Шолохов", 150);
    Book book2 = new Book(2, "Стихи", "Пушкин", 250);
    Book book3 = new Book(3, "Собрание сочинений", "Цветаева", 300);
    Smartphone phone1 = new Smartphone(4, "Нокиа", 4500, "Китай");
    Smartphone phone2 = new Smartphone(5, "Самсунг", 8500, "Китай");


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
    public void shouldRemoveById() {   //тест на метод удаления  продукта

        ProductRepository repository = new ProductRepository();

        repository.add(book1);
        repository.add(book2);
        repository.add(phone1);

        repository.removeById(1);

        Product[] actual = repository.findAll();
        Product[] expected = {book2, phone1};

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


        manager.add(book1);
        manager.add(book2);

        Product[] actual = manager.searchBy("Тихий дон");
        Product[] expected = {book1};

        assertArrayEquals(expected, actual);


    }
}
