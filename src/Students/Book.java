package Students;

import java.util.Objects;

public class Book {
    private String _author;
    private int _year;
    private int _pages;
    private String _title;
    private String _description;
    private String _content;

    public Book(String title,
                String description,
                String content,
                String author,
                int year,
                int pages) {
        _title = title;
        _description = description;
        _content = content;
        _author = author;
        _year = year;
        _pages = pages;
    }

    public String getTitle() {
        return _title;
    }

    public String getDescription() {
        return _description;
    }

    public String getContent() {
        return _content;
    }

    public int getPages() {
        return _pages;
    }

    public int getYear() {
        return _year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;
        return Objects.equals(_title, book._title) &&
                Objects.equals(_description, book._description) &&
                Objects.equals(_author, book._author) &&
                Objects.equals(_content, book._content) &&
                _pages == book._pages &&
                _year == book._year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(_title, _description, _content, _author, _pages, _year);
    }

    @Override
    public String toString() {
        return _title + ". " + _author + ", " + _pages + "c., " + _year + "г.";
    }
}
