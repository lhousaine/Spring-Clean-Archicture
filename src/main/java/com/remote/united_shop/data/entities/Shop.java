package com.remote.united_shop.data.entities;

import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Builder
@Entity
@Table(name = "shops")
public class Shop implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSchop;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    @Size(min = 100)
    private String description;
    @NotNull
    private String logo;
    @Embedded
    private Coordinates coordinates;
}
