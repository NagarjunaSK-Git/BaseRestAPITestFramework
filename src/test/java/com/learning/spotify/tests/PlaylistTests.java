package com.learning.spotify.tests;

import com.learning.spotify.apiClient.StatusCode;
import com.learning.spotify.applicationApi.PlaylistApi;
import com.learning.spotify.pojo.error.ErrorResponse;
import com.learning.spotify.pojo.playlist.Playlist;
import com.learning.spotify.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.learning.spotify.utils.FakerUtils.generateDescription;
import static com.learning.spotify.utils.FakerUtils.generateName;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

@Epic("Spotify Integration API Test")
@Feature("Playlist")
public class PlaylistTests extends BaseTestConfig {

    @Story("Test relevant to creating a playlist")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("1234567")
    @Description("Playlist related scenarios relevant to spotify application on creation, viewing and updating")
    @Test(description = "System should be able to create a playlist", groups = {"playlist", "regression"})
    public void ShouldBeAbleToCreateAPlaylist() {
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_201);
        assertPlaylistEqual(response.as(Playlist.class), requestPlaylist);
    }

    @Test(description = "System should be able to view a playlist", groups = {"smoke", "playlist", "regression"})
    public void ShouldBeAbleToGetAPlaylist() {
        Response response = PlaylistApi.get(DataLoader.getInstance().getGetPlaylistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertThat(DataLoader.getInstance().getGetPlaylistId(), equalToIgnoringCase(response.as(Playlist.class).getId()));

    }

    @Test(description = "System should be able to update a playlist with details", groups = {"smoke", "playlist", "regression"})
    public void ShouldBeAbleToUpdateAPlaylist() {
        Playlist requestPlaylist = playlistBuilder("Updated Playlist Name Rest Assured", "Updated playlist description", false);
        Response response = PlaylistApi.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
    }

    @Story("Test relevant to creating a playlist")
    @Test(description = "System should not be able to create a playlist without name", groups = {"smoke", "playlist", "regression"})
    public void ShouldNotBeAbleToCreateAPlaylistWithoutName() {
        Playlist requestPlaylist = playlistBuilder("", generateDescription(), false);
        Response response = PlaylistApi.post(requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_400);
        assertError(response.as(ErrorResponse.class), StatusCode.CODE_400);
    }

    @Story("Test relevant to creating a playlist")
    @Test(description = "System should not be able to create a playlist with expired token", groups = {"regression", "playlist"})
    public void ShouldNotBeAbleToCreateAPlaylistWithExpiredToken() {
        String invalid_token = "12345";
        Playlist requestPlaylist = playlistBuilder(generateName(), generateDescription(), false);
        Response response = PlaylistApi.post(invalid_token, requestPlaylist);
        assertStatusCode(response.statusCode(), StatusCode.CODE_401);
        assertError(response.as(ErrorResponse.class), StatusCode.CODE_401);
    }

    @Step
    public Playlist playlistBuilder(String name, String description, boolean _public) {
        return Playlist.builder().
                name(name).
                description(description).
                _public(_public).
                build();
    }

    @Step
    public void assertPlaylistEqual(Playlist responsePlaylist, Playlist requestPlaylist) {
        assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
        assertThat(responsePlaylist.getDescription(), equalTo(requestPlaylist.getDescription()));
        assertThat(responsePlaylist.get_public(), equalTo(requestPlaylist.get_public()));
    }

    @Step
    public void assertStatusCode(int actualStatusCode, StatusCode statusCode) {
        assertThat(actualStatusCode, equalTo(statusCode.code));
    }

    @Step
    public void assertError(ErrorResponse responseErr, StatusCode statusCode) {
        assertThat(responseErr.getError().getStatus(), equalTo(statusCode.code));
        assertThat(responseErr.getError().getMessage(), equalTo(statusCode.msg));
    }
}
