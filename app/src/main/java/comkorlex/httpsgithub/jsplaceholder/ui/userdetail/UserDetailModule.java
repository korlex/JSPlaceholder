package comkorlex.httpsgithub.jsplaceholder.ui.userdetail;

import comkorlex.httpsgithub.jsplaceholder.di.scopes.FragmentScope;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import comkorlex.httpsgithub.jsplaceholder.ui.userdetail.UserDetailContract;
import comkorlex.httpsgithub.jsplaceholder.ui.userdetail.UserDetailPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class UserDetailModule {


    @Provides
    @FragmentScope
    public UserDetailContract.View provideUserDetailView(UserDetailFragment userDetailFragment){
        return userDetailFragment;
    }

    @Provides
    @FragmentScope
    public UserDetailContract.Presenter provideUserDetailPresenter(UserDetailContract.View userDetailView, Interactor networkInteractor){
        return new UserDetailPresenter(userDetailView, networkInteractor);
    }

}
