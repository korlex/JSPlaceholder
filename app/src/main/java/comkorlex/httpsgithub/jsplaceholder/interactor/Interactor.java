package comkorlex.httpsgithub.jsplaceholder.interactor;


import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.Album;
import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import io.reactivex.Flowable;

public interface Interactor {

    Flowable<List<User>> getUsersFlowable();
    Flowable<User> getUserFlowable(int id);
    Flowable<List<Album>> getAlbumsFlowable(int userId);
    Flowable<List<Photo>> getPhotosFlowable(int albumId);

}
