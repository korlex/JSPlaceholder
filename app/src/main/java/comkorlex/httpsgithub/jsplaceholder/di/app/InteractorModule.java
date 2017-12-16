package comkorlex.httpsgithub.jsplaceholder.di.app;

import javax.inject.Singleton;

import comkorlex.httpsgithub.jsplaceholder.data.retrofit.IJsonPlaceholderService;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import comkorlex.httpsgithub.jsplaceholder.interactor.NetworkInteractor;
import comkorlex.httpsgithub.jsplaceholder.ui.gallery.GalleryComponent;
import comkorlex.httpsgithub.jsplaceholder.ui.userdetail.UserDetailComponent;
import comkorlex.httpsgithub.jsplaceholder.ui.users.UsersComponent;
import dagger.Module;
import dagger.Provides;

@Module(subcomponents = {
        UsersComponent.class,
        UserDetailComponent.class,
        GalleryComponent.class})

public class InteractorModule {

    @Provides
    @Singleton
    Interactor getInteractor(IJsonPlaceholderService placeholderService){
        return new NetworkInteractor(placeholderService);
    }


}
