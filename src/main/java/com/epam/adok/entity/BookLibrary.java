package com.epam.adok.entity;

import com.epam.adok.entity.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookLibrary {

    private List<Book> books = new ArrayList<>();

    public BookLibrary() {
        Book book1 = new Book("ATitle1 aubergine", Book.Genre.COOKERY, "Author", Book.Language.ENGLISH);
        Book book2 = new Book("ATitle2 melon", Book.Genre.DETECTIVE, "Author", Book.Language.RUSSIAN);
        Book book3 = new Book("ATitle3 watermelon", Book.Genre.FANTASY, "Author", Book.Language.ENGLISH);
        Book book4 = new Book("Title4 pear", Book.Genre.NOVEL, "Author", Book.Language.RUSSIAN);
        Book book5 = new Book("Title5 occasionally", Book.Genre.POETRY, "Author", Book.Language.KAZAKH);
        Book book6 = new Book("Title6 appreciate", Book.Genre.PROGRAMMING, "Author", Book.Language.ENGLISH);
        Book book7 = new Book("ATitle7 peach", Book.Genre.DETECTIVE, "Author", Book.Language.RUSSIAN);
        Book book8 = new Book("Title8 book", Book.Genre.COOKERY, "Author", Book.Language.KAZAKH);
        Book book9 = new Book("Title9 art", Book.Genre.FANTASY, "Author", Book.Language.ENGLISH);
        Book book10 = new Book("ATitle10 note", Book.Genre.NOVEL, "Author", Book.Language.ENGLISH);
        Collections.addAll(books,
                book1, book2, book3, book4, book5, book6, book7, book8, book9, book10);
    }

    public List<Book> getBooks() {
        return books;
    }
}
