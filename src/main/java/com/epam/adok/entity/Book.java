package com.epam.adok.entity;

public class Book {

    private String title;
    private Genre genre;
    private String author;
    private Language language;

    public Book() {
    }

    public Book(String title, Genre genre, String author, Language language) {
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.language = language;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "\n * book: " +
                "\n\t -> title = " + title +
                "\n\t -> genre = " + genre +
                "\n\t -> author = " + author +
                "\n\t -> language = " + language + ".";
    }

    public enum Genre {

        FANTASY("Fantasy"),
        POETRY("Poetry"),
        DETECTIVE("Detective"),
        NOVEL("Novel"),
        COOKERY("Cookery"),
        PROGRAMMING("Programming");

        private String value;

        Genre(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Genre from(String value) {
            for (Genre genre : Genre.values()) {
                if (value != null && genre.getValue().equals(value)) {
                    return genre;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    public enum Language {

        RUSSIAN("Russian"),
        ENGLISH("English"),
        KAZAKH("Kazakh");

        private String value;

        Language(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Language from(String value) {
            for (Language language : Language.values()) {
                if (value != null && language.getValue().equals(value)) {
                    return language;
                }
            }
            throw new IllegalArgumentException();
        }
    }
}
