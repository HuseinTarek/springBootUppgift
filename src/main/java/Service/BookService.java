package Service;

import model.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    private final Map<Long, Book> db = new HashMap<>();

    public List<Book> listAll() {
        return null;
    }

    public List<Book> listByAuthor(String author) {
        return null;
    }

    public Book get(Long id){
        return null;
    }

    private Long nextId = 0L;

    //sätt updatedAt genom att hämta System.currentTimeMillis()
    public Book create(Book book) {
        book.setId(nextId++);
        book.setUpdatedAt(System.currentTimeMillis());
        db.put(book.getId(),book);
        return book;
    }

    Book update(Book book) {
        return null;
    }

    void delete(Long id) {
    }

    Book patch(Book book) {
        return null;
    }

}