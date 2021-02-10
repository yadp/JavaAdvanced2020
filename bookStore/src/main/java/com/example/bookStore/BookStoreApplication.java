package com.example.bookStore;

import com.example.bookStore.model.Author;
import com.example.bookStore.model.Book;
import com.example.bookStore.repo.AuthorRepo;
import com.example.bookStore.repo.BookRepo;
import com.example.bookStore.repo.OpenLibRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepo bookRepo, AuthorRepo authorRepo, OpenLibRepo openLibRepo){
		return (args)->{
			System.out.println("test");
			Author author=new Author("TestAuthor");
			authorRepo.save(author);

			bookRepo.save(new Book("21231231",author,"TestName"));
			bookRepo.save(new Book("21231231",author,"TestName2"));

			System.out.println(bookRepo.findByIsbn("0140328726"));

			Book book = openLibRepo.findByIsbn("0140328726");
			System.out.println(book);

			bookRepo.save(book);

			System.out.println(bookRepo.findByIsbn("0140328726"));


		};
	}

}
