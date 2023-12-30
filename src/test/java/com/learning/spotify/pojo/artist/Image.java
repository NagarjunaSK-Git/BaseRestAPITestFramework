package com.learning.spotify.pojo.artist;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {
    public int height;
    public String url;
    public int width;
}
