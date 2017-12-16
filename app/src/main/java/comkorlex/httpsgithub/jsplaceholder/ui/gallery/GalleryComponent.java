package comkorlex.httpsgithub.jsplaceholder.ui.gallery;

import comkorlex.httpsgithub.jsplaceholder.di.scopes.FragmentScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {GalleryModule.class})
@FragmentScope
public interface GalleryComponent extends AndroidInjector<GalleryFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<GalleryFragment>{};

}
