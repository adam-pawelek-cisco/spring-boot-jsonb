package com.example.jsonb.data;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "parents")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Parent implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@GeneratedValue( generator = "abc")
    //@GenericGenerator(name = "abc", strategy = "increment")
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


    public  Parent(String name, List<Child> children, Bio bio) {
        this.name = name;
        this.children =  children;
        this.bio = bio;
    }
}
