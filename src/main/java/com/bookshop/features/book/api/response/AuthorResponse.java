package com.bookshop.features.book.api.response;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthorResponse {

    private Integer id;

    private String name;

    private String surname;


    @JsonCreator

    public AuthorResponse(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("surname") String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
