package com.example.bookStore.repo;

import com.example.bookStore.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepo extends CrudRepository<Client, Long> {
}
