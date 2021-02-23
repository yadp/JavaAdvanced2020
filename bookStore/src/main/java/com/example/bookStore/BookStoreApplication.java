package com.example.bookStore;

import com.example.bookStore.model.Author;
import com.example.bookStore.model.Book;
import com.example.bookStore.model.User;
import com.example.bookStore.repo.AuthorRepo;
import com.example.bookStore.repo.BookRepo;
import com.example.bookStore.repo.OpenLibRepo;
import com.example.bookStore.repo.UserRepo;
import com.example.bookStore.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}


	@Bean
	public CommandLineRunner demo(BookRepo bookRepo, UserRepo userRepo, AuthorRepo authorRepo, OpenLibRepo openLibRepo, BookService bookService){
		return (args)->{
			System.out.println("test");
			Author author=new Author("TestAuthor");
			//author.setId(5L);


			bookService.createBook(new Book("21231231",author,"TestName"));
			bookService.createBook(new Book("312312",author,"Test Mr. Fox"));

			bookService.updatePrice(2L,2.0);
			bookService.addBookQuantity(2L,20);
			bookService.sellBook(2L,10);



			bookService.getBookByIsbn("0140328726");


			System.out.println("Found book: "+bookService.getBookByNamePart("Mr. Fox"));


			User user = new User();
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

			user.setName("Yavor");
			user.setUsername("test");
			user.setPassword(passwordEncoder.encode("test"));
			user.setEnabled(true);
			user.setRole("ROLE_ADMIN");

			userRepo.save(user);

		};
	}

}
