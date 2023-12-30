package com.learning.spotify.pojo.artist;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Followers {

    public Object href;
    public int total;
}
