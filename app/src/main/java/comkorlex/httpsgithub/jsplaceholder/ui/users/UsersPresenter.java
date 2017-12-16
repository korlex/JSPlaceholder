package comkorlex.httpsgithub.jsplaceholder.ui.users;


import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UsersPresenter implements UsersContract.Presenter {

    private UsersContract.View usersView;
    private Interactor networkInteractor;

    public UsersPresenter(UsersContract.View usersView, Interactor networkInteractor) {
        this.usersView = usersView;
        this.networkInteractor = networkInteractor;
    }

    @Override
    public void setUsers() {
        usersView.showLoading();
        networkInteractor
                .getUsersFlowable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<User>>() {
                    @Override
                    public void accept(List<User> users) throws Exception {
                        usersView.showUsers(users);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        usersView.showError(throwable.getMessage());
                    }
                });
    }


}
