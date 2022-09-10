package com.example.jsonb.data;

import java.io.Serializable;
import lombok.Data;


@Data
public class Bio implements Serializable {
    private String text;
}
