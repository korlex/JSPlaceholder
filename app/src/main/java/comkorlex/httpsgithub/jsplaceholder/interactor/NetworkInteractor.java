package comkorlex.httpsgithub.jsplaceholder.interactor;


import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.Album;
import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import comkorlex.httpsgithub.jsplaceholder.data.retrofit.IJsonPlaceholderService;
import io.reactivex.Flowable;

public class NetworkInteractor implements Interactor {

    private IJsonPlaceholderService jsonPlaceholderService;

    public NetworkInteractor(IJsonPlaceholderService jsonPlaceholderService) {
        this.jsonPlaceholderService = jsonPlaceholderService;
    }


    @Override
    public Flowable<List<User>> getUsersFlowable() {
        return jsonPlaceholderService.loadUsersData();
    }

    @Override
    public Flowable<User> getUserFlowable(int id) {
        return jsonPlaceholderService.loadUserData(id);
    }

    @Override
    public Flowable<List<Album>> getAlbumsFlowable(int userId) {
        return jsonPlaceholderService.loadUserAlbums(userId);
    }

    @Override
    public Flowable<List<Photo>> getPhotosFlowable(int albumId) {
        return jsonPlaceholderService.loadGalleryPhotos(albumId);
    }
}
