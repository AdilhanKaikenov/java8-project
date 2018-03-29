package com.epam.adok;

import com.epam.adok.entity.Book;
import com.epam.adok.entity.BookLibrary;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskApp {

    public static void main(String[] args) {

        BookLibrary bookLibrary = new BookLibrary();
        List<Book> books = bookLibrary.getBooks();

        Supplier<Stream<Book>> streamSupplier = books::stream;

        List<Book> task1 = streamSupplier.get()
                .filter(book -> book.getTitle().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("- TASK1 : Filter by title starts with A ------> " + task1.size());

        List<Book> task2 = streamSupplier.get()
                .filter(book -> book.getTitle().startsWith("A"))
                .filter(book -> book.getGenre().equals(Book.Genre.DETECTIVE))
                .collect(Collectors.toList());
        System.out.println("- TASK2 : Filter by title starts with A and id > 4 ------> " + task2.size());

        System.out.println("- TASK3 :  - return collection of book names : ");
        List<String> task3 = streamSupplier.get()
                .map(Book::getTitle)
                .collect(Collectors.toList());
        task3.forEach(title -> System.out.print("|" + title));

        System.out.println("\n- TASK4 :  - return collection of Genre string names : ");
        List<String> task4 = streamSupplier.get()
                .map(Book::getGenre)
                .map(Book.Genre::getValue)
                .distinct()
                .collect(Collectors.toList());
        task4.forEach(genre -> System.out.print("|" + genre));

        System.out.println("\n- TASK5 :  - return collection with all words which are in books titles : ");
        List<String> task5 = streamSupplier.get()
                .map(Book::getTitle)
                .map(title -> title.split("(\\p{Punct}?\\s)"))
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        task5.forEach(word -> System.out.print("|" + word));


        System.out.println("\n- TASK6 :  - return map title to book : ");
        Map<String, Book> task6 = streamSupplier.get()
                .collect(Collectors.toMap(Book::getTitle, Function.identity()));
        task6.forEach((title, book) -> System.out.print("{key = " + title + ";value = " + book.hashCode()+"},"));

        System.out.println("\n- TASK7 :  - return map title to language : ");
        Map<String, Book.Language> task7 = streamSupplier.get()
                .collect(Collectors.toMap(Book::getTitle, Book::getLanguage));
        task7.forEach((title, language) -> System.out.print("{key = " + title + "; value = " + language+"},"));

        System.out.println("\n- TASK8 :   - group books by genre  : ");
        Map<Book.Genre, List<Book>> task8 = streamSupplier.get()
                .collect(Collectors.groupingBy(Book::getGenre));
        task8.forEach((genre, groupedTogether) -> System.out.println("{genre = " + genre + "; size = " + groupedTogether.size() + "}"));

        System.out.println("\n- TASK8.1 : - group books by genre to title : ");
        Map<Book.Genre, Set<String>> task8_1 = streamSupplier.get()
                .collect(Collectors.groupingBy(
                        Book::getGenre,
                        Collectors.mapping(Book::getTitle, Collectors.toSet()))
                );
        task8_1.forEach((genre, title) -> System.out.println("{genre = " + genre + "; title = " + title + "}"));

        System.out.println("\n- TASK9 :   - return string with all authors names, separated by semicolon  : ");
        String result = streamSupplier.get()
                .map(Book::getAuthor)
                .collect(Collectors.joining(";"));
        System.out.println(result);

        System.out.println("\n\tanyMatch, allMatch, noneMatch");
        if (streamSupplier.get()
                .anyMatch(book -> book.getGenre() == Book.Genre.COOKERY)) {
            System.out.println("anyMatch() : There are cookbooks.");
        }

        if (streamSupplier.get()
                .allMatch(book -> book.getAuthor().equals("Author"))) {
            System.out.println("allMatch() : Shared author.");
        }

        if (streamSupplier.get()
                .noneMatch(book -> book.getAuthor().equals("Author_"))) {
            System.out.println("noneMatch() : There is no author named Author_.");
        }

        OptionalDouble average = streamSupplier.get().mapToInt(book -> book.getTitle().length()).average();
        System.out.println(average);



    }
}
