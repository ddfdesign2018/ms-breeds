package com.ddfdesign.msbreeds.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name= "breeds")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Breed {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "junior_price")
    private Double junior_price;

    @Column(name = "adult_price")
    private Double adult_price;

    @Column(name = "specy")
    private Long specy;

}
