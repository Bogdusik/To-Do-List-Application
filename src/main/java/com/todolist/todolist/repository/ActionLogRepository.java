package com.todolist.todolist.repository;

import com.todolist.todolist.model.ActionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionLogRepository extends JpaRepository<ActionLog, Long> {
}
