package Students;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String _firstName;
    private String _lastName;
    private String _middleName;
    private List<Book> _books;

    public Student(String firstName, String lastName, String middleName) {
        _firstName = firstName;
        _lastName = lastName;
        _middleName = middleName;
        _books = new ArrayList<>();
    }

    public boolean addBook(Book book) {
        return _books.add(book);
    }

    public boolean removeBook(Book book) {
        return _books.remove(book);
    }

    public List<Book> getBooks() {
        return _books;
    }

    @Override
    public String toString() {
        return _lastName + " " + _firstName + " " + _middleName;
    }
}
