package com.demo;

import com.dong.service.FileProcessor;
import com.dong.service.PhoneProcess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.StringWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

public class PhoneTest {

//    public static void main(String[] args) throws Exception {
//        ObjectMapper objectMapper = new ObjectMapper()
//                .registerModule(new JavaTimeModule());
//
//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
////                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,true);
//
//        Entity entity = new Entity(LocalDateTime.now());
//        StringWriter writer = new StringWriter();
//        objectMapper.writeValue(writer, entity);
//        System.out.println(writer.getBuffer());
//    }
 public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .disable(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS);
     ;

//        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,true);

        Entity2 entity = new Entity2(Instant.now());
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, entity);
        System.out.println(writer.getBuffer());
    }

    static class Entity {
        LocalDateTime timestamp;

        public Entity(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }

        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
        }
    }
    static class Entity2 {
        Instant timestamp;

        public Entity2(Instant timestamp) {
            this.timestamp = timestamp;
        }

        public Instant getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(Instant timestamp) {
            this.timestamp = timestamp;
        }
    }

}
