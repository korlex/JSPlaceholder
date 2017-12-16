package comkorlex.httpsgithub.jsplaceholder.data.retrofit;

import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.Album;
import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IJsonPlaceholderService {

    @GET("/users")
    Flowable<List<User>> loadUsersData();

    @GET("/users/{id}")
    Flowable<User> loadUserData(@Path("id") int userId);


    @GET("/albums")
    Flowable<List<Album>> loadUserAlbums(@Query("userId") int userId);

    @GET("/photos")
    Flowable<List<Photo>> loadGalleryPhotos(@Query("albumId") int albumId);

}
