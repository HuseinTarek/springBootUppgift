package controller;

import Service.BookService;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import model.Book;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/books")  // Lägg till denna annotation
public class BookControl {

    private final BookService service = new BookService();

    @GetMapping
    public ResponseEntity<List<Book>> books(@RequestParam(required = false)
                                            String author) {
        List<Book> result = (author == null) ? service.listAll() :
                service.listByAuthor(author);

        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(result.size()))
                .cacheControl(CacheControl.maxAge(30, TimeUnit.SECONDS))
                .body(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> book(@PathVariable Long id,
                                     @RequestHeader(value = "X-Client", required = false) String xClient) {
        Book b = service.get(id);
        if (b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok()
                .lastModified(b.getUpdatedAt())
                .header(HttpHeaders.CACHE_CONTROL, "no-cache")
                .header("X-Client", xClient == null ? "unknown" : xClient)
                .body(b);

    }


    @GetMapping("/test")
    public String test() {
        return "Test endpoint fungerar!\n";
    }

}