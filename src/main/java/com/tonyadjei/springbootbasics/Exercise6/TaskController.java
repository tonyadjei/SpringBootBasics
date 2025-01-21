package com.tonyadjei.springbootbasics.Exercise6;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @GetMapping("{id}")
    public ResponseEntity<Task> getTask(@PathVariable int id) {
        Task task = TaskManager.tasks.get(id);
        if (task != null) {
            return ResponseEntity.ok(task);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("")
    public ResponseEntity<Task> addTask(@RequestBody Task.TaskRequest taskRequest) {
        Task task = TaskManager.addTask(taskRequest);
        if (task != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(task);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }

    @PutMapping("{id}")
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task.TaskRequest taskRequest) {
        Task task = TaskManager.updateTask(id, taskRequest.getTitle());
        if (task != null) {
            return ResponseEntity.status(HttpStatus.OK).body(task);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable int id) {
        boolean result = TaskManager.deleteTask(id);
        if (result) {
            return ResponseEntity.status(HttpStatus.OK).body(null);
        }
        return ResponseEntity.status((HttpStatus.NOT_FOUND)).body(null);
    }

}
