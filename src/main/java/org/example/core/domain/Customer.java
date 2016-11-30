package org.example.core.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data @NoArgsConstructor
@Entity @Table(name="customer", schema="test")
public class Customer {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="name")
    private String name;
}
