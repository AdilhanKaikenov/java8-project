package com.epam.adok;

import com.epam.adok.entity.Book;
import com.epam.adok.entity.BookLibrary;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SequentialParallelApp {
    public static void main(String[] args) {
        BookLibrary bookLibrary = new BookLibrary();
        List<Book> books = bookLibrary.getBooks();

        Supplier<Stream<Book>> streamSupplier = books::stream;

        Runnable sequential  = () -> {
            Long timeStarted = System.currentTimeMillis();
            streamSupplier.get()
                    .sequential()
                    .forEach(book -> System.out.println(book.getTitle()));
            System.out.println("Sequential processing took: " + (System.currentTimeMillis() - timeStarted));
        };


        Runnable parallel = () -> {
            Long timeStarted = System.currentTimeMillis();
            streamSupplier.get()
                    .parallel()
//                    .collect(Collectors.toList())
                    .forEach(book -> System.out.println(book.getTitle()));
            System.out.println("Parallel processing took: " + (System.currentTimeMillis() - timeStarted));
        };


        new Thread(sequential).start();
        new Thread(parallel).start();
    }
}
