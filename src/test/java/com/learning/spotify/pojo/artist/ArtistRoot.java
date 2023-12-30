package com.learning.spotify.pojo.artist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.learning.spotify.pojo.IRequestResponseBase;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import java.util.ArrayList;

@Getter
@Setter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ArtistRoot implements IRequestResponseBase {

    public ExternalUrls external_urls;
    public Followers followers;
    public ArrayList<String> genres;
    public String href;
    public String id;
    public ArrayList<Image> images;
    public String name;
    public int popularity;
    public String type;
    public String uri;
}
