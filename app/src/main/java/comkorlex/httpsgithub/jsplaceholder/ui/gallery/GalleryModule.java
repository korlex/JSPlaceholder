package comkorlex.httpsgithub.jsplaceholder.ui.gallery;

import comkorlex.httpsgithub.jsplaceholder.di.scopes.FragmentScope;
import comkorlex.httpsgithub.jsplaceholder.interactor.Interactor;
import dagger.Module;
import dagger.Provides;

@Module
public class GalleryModule {

    @Provides
    @FragmentScope
    public GalleryContract.View provideGalleryView(GalleryFragment galleryFragment){
        return galleryFragment;
    }

    @Provides
    @FragmentScope
    public GalleryContract.Presenter provideGalleryPresenter(GalleryContract.View galleryView, Interactor networkInteractor){
        return new GalleryPresenter(galleryView, networkInteractor);
    }

}
