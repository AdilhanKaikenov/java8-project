package com.epam.adok;

import com.epam.adok.entity.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {

        Book book1 = new Book("Title1", Book.Genre.COOKERY, "Author", Book.Language.ENGLISH);
        Book book2 = new Book("Title2", Book.Genre.DETECTIVE, "Author", Book.Language.RUSSIAN);
        Book book3 = new Book("Title3", Book.Genre.FANTASY, "Author", Book.Language.ENGLISH);
        Book book4 = new Book("Title4", Book.Genre.NOVEL, "Author", Book.Language.RUSSIAN);
        Book book5 = new Book("Title5", Book.Genre.POETRY, "Author", Book.Language.KAZAKH);
        Book book6 = new Book("Title6", Book.Genre.PROGRAMMING, "Author", Book.Language.ENGLISH);
        Book book7 = new Book("Title7", Book.Genre.DETECTIVE, "Author", Book.Language.RUSSIAN);
        Book book8 = new Book("Title8", Book.Genre.COOKERY, "Author", Book.Language.KAZAKH);
        Book book9 = new Book("Title9", Book.Genre.FANTASY, "Author", Book.Language.ENGLISH);
        Book book10 = new Book("Title10", Book.Genre.NOVEL, "Author", Book.Language.ENGLISH);
        Book book11 = new Book("Title11", Book.Genre.PROGRAMMING, "Author", Book.Language.RUSSIAN);
        Book book12 = new Book("Title12", Book.Genre.POETRY, "Author", Book.Language.KAZAKH);
        Book book13 = new Book("Title13", Book.Genre.COOKERY, "Author", Book.Language.ENGLISH);
        Book book14 = new Book("Title14", Book.Genre.PROGRAMMING, "Author", Book.Language.RUSSIAN);
        Book book15 = new Book("Title15", Book.Genre.DETECTIVE, "Author", Book.Language.ENGLISH);
        Book book16 = new Book("Title16", Book.Genre.NOVEL, "Author", Book.Language.RUSSIAN);
        Book book17 = new Book("Title17", Book.Genre.FANTASY, "Author", Book.Language.ENGLISH);
        Book book18 = new Book("Title18", Book.Genre.DETECTIVE, "Author", Book.Language.KAZAKH);
        Book book19 = new Book("Title19", Book.Genre.FANTASY, "Author", Book.Language.ENGLISH);
        Book book20 = new Book("Title20", Book.Genre.COOKERY, "Author", Book.Language.KAZAKH);

        List<Book> books = new ArrayList<>();

        Collections.addAll(books,
                book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14,
                book15, book16, book17, book18, book19, book20);

        Supplier<Stream<Book>> streamSupplier = books::stream;

        // filter
        long detectiveNumber = streamSupplier.get()
                .filter(book -> book.getGenre().equals(Book.Genre.DETECTIVE))
                .count();
        System.out.println("DETECTIVE Number = " + detectiveNumber);

        // skip
        Optional<Book> book = streamSupplier.get().skip(9).findFirst();
        System.out.println(book);

        // peek
        List<Book> peek = streamSupplier.get()
                .peek(b -> b.setAuthor(b.getAuthor().substring(0, 6)))
                .collect(Collectors.toList());
//        System.out.println(peek);

        // distinct
        List<Integer> distinct = Stream.of(1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7, 8, 9)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinct);



        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello");
            }
        };

        Runnable runnable1 = () -> System.out.println("Hello");

        Runnable runnable2 = () -> {
            System.out.println("Hello");
            System.out.println("Runnable");
        };

        /**
         * @FunctionalInterface
         *
         * Predicate
         * Consumer
         * Function
         * Supplier
         */

        Predicate<Integer> predicate = (x) -> x < 10;
//        Consumer<Integer> consumer = (x) -> System.out.println(x);
        Consumer<Integer> consumer = System.out::println;
//        Function<Integer, String> function = x -> x.toString();
        Function<Integer, String> function = Object::toString;

        lalala(Object::toString);
    }

    private static void lalala(final Function<Integer, String> func) {
        System.out.println(func.apply(12));
    }
}
