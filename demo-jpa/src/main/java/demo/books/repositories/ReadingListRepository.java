package demo.books.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.books.entities.Book;

public interface ReadingListRepository extends JpaRepository<Book, Long> {
	List<Book> findByReader(String reader);
}