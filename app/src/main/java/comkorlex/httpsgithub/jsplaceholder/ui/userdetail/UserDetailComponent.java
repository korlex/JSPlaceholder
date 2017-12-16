package comkorlex.httpsgithub.jsplaceholder.ui.userdetail;

import comkorlex.httpsgithub.jsplaceholder.di.scopes.FragmentScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;


@Subcomponent(modules = {UserDetailModule.class})
@FragmentScope
public interface UserDetailComponent extends AndroidInjector<UserDetailFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UserDetailFragment>{};
}
