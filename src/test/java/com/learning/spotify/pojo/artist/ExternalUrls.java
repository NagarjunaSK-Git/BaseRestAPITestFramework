package com.learning.spotify.pojo.artist;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalUrls {
    public String spotify;
}
