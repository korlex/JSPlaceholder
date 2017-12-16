package comkorlex.httpsgithub.jsplaceholder.ui.userdetail;


import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.Album;
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import comkorlex.httpsgithub.jsplaceholder.data.entity.UserWithAlbums;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserDetailPresenter implements UserDetailContract.Presenter {

    private UserDetailContract.View userDetailview;
    private Interactor networkInteractor;

    public UserDetailPresenter(UserDetailContract.View userDetailview, Interactor networkInteractor) {
        this.userDetailview = userDetailview;
        this.networkInteractor = networkInteractor;
    }

    @Override
    public void setUserInfo(int id) {
        userDetailview.showLoading();
        networkInteractor.getUserFlowable(id)
                .zipWith(networkInteractor.getAlbumsFlowable(id), new BiFunction<User, List<Album>, UserWithAlbums>() {
                    @Override
                    public UserWithAlbums apply(@NonNull User user, @NonNull List<Album> albums) throws Exception {
                        return new UserWithAlbums(user, albums);
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<UserWithAlbums>() {
                    @Override
                    public void accept(UserWithAlbums userWithAlbums) throws Exception {
                        userDetailview.showUserDetails(userWithAlbums);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        userDetailview.showError(throwable.getMessage());
                    }
                });
    }
}
