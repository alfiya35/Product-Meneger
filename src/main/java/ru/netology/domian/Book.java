package ru.netology.domian;

public class Book extends Product {
    protected String author;


    public Book(){ //Конструктор

    }

    public Book(int id, String title, String author, int price){  //Конструктор
        super(id, title,price);

        this.author = author;

    }

    public String getAuthor() { //Геттеры и сеттеры
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
