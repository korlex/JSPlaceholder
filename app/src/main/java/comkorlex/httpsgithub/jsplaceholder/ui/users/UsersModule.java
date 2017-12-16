package comkorlex.httpsgithub.jsplaceholder.ui.users;


import comkorlex.httpsgithub.jsplaceholder.di.scopes.FragmentScope;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import comkorlex.httpsgithub.jsplaceholder.ui.users.UsersContract;
import comkorlex.httpsgithub.jsplaceholder.ui.users.UsersPresenter;
import dagger.Module;
import dagger.Provides;

@Module
public class UsersModule {


    @Provides
    @FragmentScope
    public UsersContract.View provideUsersView(UsersFragment usersFragment){
        return usersFragment;
    }

    @Provides
    @FragmentScope
    public UsersContract.Presenter provideUsersPresenter(UsersContract.View usersView, Interactor networkInteractor){
        return new UsersPresenter(usersView, networkInteractor);
    }

}
