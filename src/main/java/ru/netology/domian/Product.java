package ru.netology.domian;

import java.util.Objects;

public class Product {
    protected int id;  //уникальныый номер
    protected String title;  //название
    protected int price; //стоимость

    public Product(){ //конструктор по умлочанию

    }

    public Product(int id, String title,int price) { //Конструктор с параметрами
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    public  int weight() { //метод вывода на экран сколько весит товар
//        return  -1;
//    }


    public int getId() { //Геттеры и сеттеры
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override //метод ИКЛС
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title);
    }

}
