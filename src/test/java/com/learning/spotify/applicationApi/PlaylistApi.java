package com.learning.spotify.applicationApi;

import com.learning.spotify.apiClient.ResourcePathConstants;
import com.learning.spotify.apiClient.RestRequestProcessor;
import com.learning.spotify.pojo.playlist.Playlist;
import com.learning.spotify.utils.ConfigLoader;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.learning.spotify.apiClient.TokenManager.getToken;

public class PlaylistApi {

    @Step
    public static Response post(Playlist requestPlaylist) {
        return RestRequestProcessor.post(ResourcePathConstants.USERS + "/" + ConfigLoader.getInstance().getUser()
                + ResourcePathConstants.PLAYLISTS, getToken(), requestPlaylist);
    }

    @Step
    public static Response post(String token, Playlist requestPlaylist) {
        return RestRequestProcessor.post(ResourcePathConstants.USERS + "/" + ConfigLoader.getInstance().getUser()
                + ResourcePathConstants.PLAYLISTS, token, requestPlaylist);
    }

    @Step
    public static Response get(String playlistId) {
        return RestRequestProcessor.get(ResourcePathConstants.PLAYLISTS + "/" + playlistId, getToken());
    }

    @Step
    public static Response update(String playlistId, Playlist requestPlaylist) {
        return RestRequestProcessor.update(ResourcePathConstants.PLAYLISTS + "/" + playlistId, getToken(), requestPlaylist);
    }
}
