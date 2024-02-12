package com.acciojob.BookMyShowapplication.Repository;

import com.acciojob.BookMyShowapplication.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
}
