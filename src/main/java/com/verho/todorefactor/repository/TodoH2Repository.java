package com.verho.todorefactor.repository;

import com.verho.todorefactor.model.Status;
import com.verho.todorefactor.model.Todo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Qualifier("db")
public interface TodoH2Repository extends TodoRepository, JpaRepository<Todo, Long> {

    @Modifying
    @Transactional
    @Query("update Todo t set t.title = ?2 where t.id = ?1")
    void update(Long id, String title);

    List<Todo> findAllByStatus(Status status);

    @Query("SELECT t from Todo t where t.status = UPPER(?1)")
    List<Todo> findAllByStatusString(String status);

    @Transactional
    void removeById(Long id);

    @Transactional
    void removeByStatus(Status status);

    @Modifying
    @Transactional
    @Query("update Todo t set t.status = ?2 where t.id = ?1")
    void setStatus(Long id, Status status);
}
