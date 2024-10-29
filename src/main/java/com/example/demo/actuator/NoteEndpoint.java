package com.example.demo.actuator;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "note", enableByDefault = true)
public class NoteEndpoint {
    private Map<String, Object> noteContent = new HashMap<>();

    @ReadOperation
    public Map<String, Object> readNote() {
        return this.noteContent;
    }

    @WriteOperation
    public Map<String, Object> writeNote(String key, Object value) {
        this.noteContent.put(key, value);
        return this.noteContent;
    }

    @DeleteOperation
    public Map<String, Object> deleteNote(String key) {
        this.noteContent.remove(key);
        return this.noteContent;
    }
}
