package com.example.jsonb.data;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "parents")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Schema(accessMode= Schema.AccessMode.READ_ONLY)
    private Integer id;

    @Column(length = 32, nullable = false)
    private String name;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private List<Child> children;

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    private Bio bio;

}
