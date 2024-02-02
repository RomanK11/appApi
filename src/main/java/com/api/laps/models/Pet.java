package com.api.laps.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("pets")
public class Pet {
    @Id
    private Long id;

    private String name;

    private Integer age;

    private Integer weight;

    private String gender;

    private Long user_id;
}
