package com.m2i.YouTube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.YouTube.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{}
