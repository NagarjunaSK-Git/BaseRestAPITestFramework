package com.learning.spotify.tests;

import com.learning.spotify.apiClient.StatusCode;
import com.learning.spotify.applicationApi.ArtistApi;
import com.learning.spotify.pojo.artist.ArtistRoot;
import com.learning.spotify.pojo.error.ErrorResponse;
import com.learning.spotify.utils.DataLoader;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.text.IsEqualIgnoringCase.equalToIgnoringCase;

@Epic("Spotify Integration API Test")
@Feature("Artists")
public class ArtistTests extends BaseTestConfig {

    @Story("Test relevant to handling artist details")
    @Link("https://example.org")
    @Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("1234567")
    @Description("Artist related scenarios relevant to spotify application on viewing details, albums, related artist details")


    @Test(description = "System should be able to view an artist details", groups = {"artists", "regression"})
    public void ShouldBeAbleToViewArtist() {
        Response response = ArtistApi.get(DataLoader.getInstance().getArtistId());
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
        assertThat(DataLoader.getInstance().getArtistName(), equalToIgnoringCase(response.as(ArtistRoot.class).getName()));
    }

    @Test(description = "System should be able to view an Artist's albums", groups = {"smoke", "artists", "regression"})
    public void ShouldBeAbleToViewAlbumDetailsForAnArtist() {
        HashMap<String, String> queryParam = new HashMap<>();
        queryParam.put("market", "IN");
        queryParam.put("limit", "1");
        queryParam.put("offset", "1");
        Response response = ArtistApi.get(DataLoader.getInstance().getArtistId(), queryParam);
        assertStatusCode(response.statusCode(), StatusCode.CODE_200);
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
