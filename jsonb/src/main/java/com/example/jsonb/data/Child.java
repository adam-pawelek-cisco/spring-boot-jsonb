package com.example.jsonb.data;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Child implements Serializable {
    private String name;
}
