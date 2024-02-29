package com.project.libraraymgm.manager.infrastructure;

import com.project.libraraymgm.manager.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBookByAuthorName(String author);
    List<Book> findBooksByBookName(String bookName);
}
