package com.twoguysonepanda.itfest2018.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class TestObject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "testObject", cascade = CascadeType.ALL)
    private List<MiniTestObject> miniTestObjects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MiniTestObject> getMiniTestObjects() {
        return miniTestObjects;
    }

    public void setMiniTestObjects(List<MiniTestObject> miniTestObjects) {
        this.miniTestObjects = miniTestObjects;
    }
}
