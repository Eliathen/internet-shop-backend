package com.bookshop.features.book.data.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity(name = "COVER")
public class CoverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Type(type = "org.hibernate.type.BinaryType")
    @Column(columnDefinition = "LONGBLOB")
    private byte[] data;

    private String type;

}
