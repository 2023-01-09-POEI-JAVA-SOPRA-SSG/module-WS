package com.m2i.YouTube.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.m2i.YouTube.entity.Video;

public interface VideoRepository extends JpaRepository<Video, Integer> {}
