package com.lindsaySenia.lucyscloset.v1.repositories;

import com.lindsaySenia.lucyscloset.v1.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
