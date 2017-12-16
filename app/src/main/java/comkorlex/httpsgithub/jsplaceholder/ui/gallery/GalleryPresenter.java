package comkorlex.httpsgithub.jsplaceholder.ui.gallery;

import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class GalleryPresenter implements GalleryContract.Presenter {

    private GalleryContract.View galleryView;
    private Interactor networkInteractor;


    public GalleryPresenter(GalleryContract.View galleryView, Interactor networkInteractor) {
        this.galleryView = galleryView;
        this.networkInteractor = networkInteractor;
    }

    @Override
    public void setPhotos(int albumId) {
        galleryView.showLoading();
        networkInteractor
                .getPhotosFlowable(albumId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Photo>>() {
                    @Override
                    public void accept(List<Photo> photos) throws Exception {
                        galleryView.showPhotos(photos);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        galleryView.showError(throwable.getMessage());
                    }
                });
    }
}
