package com.acciojob.BookMyShowapplication.Repository;

import com.acciojob.BookMyShowapplication.Entities.Show;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {
}
