package Service;

import model.Book;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookService {
    private final Map<Long, Book> db = new HashMap<>();
    Book book1 = new Book("1982","George Orwel",1949);
    Book book2 = new Book("Sindbad", "unknown", 1949);
    Book book3 = new Book("Min wahi Alkalam", "Mustafa sadek alrafeii", 1949);

    public BookService() {
        book1.setId(nextId++);
        book2.setId(nextId++);
        book3.setId(nextId++);


        db.put(book1.getId(), book1);
        db.put(book2.getId(), book2);
        db.put(book3.getId(), book3);
    }

    public List<Book> listAll() {
        return db.values().stream().toList();
    }

    public List<Book> listByAuthor(String author) {
        return db.values().stream().filter(book -> book.getAuthor().equals(author)).toList();
    }

    public Book get(Long id){
        return db.get(id);
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
        return db.get(book.getId());
    }

    void delete(Long id) {
    }

    Book patch(Book book) {
        return db.get(book.getId());
    }

}