package com.acciojob.BookMyShowapplication.Repository;

import com.acciojob.BookMyShowapplication.Entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
