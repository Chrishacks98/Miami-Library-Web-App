package com.henrybooks.repository;

import com.henrybooks.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface AuthorRepository extends JpaRepository<Author, BigInteger> {
}
