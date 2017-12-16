package comkorlex.httpsgithub.jsplaceholder.ui.users;

import comkorlex.httpsgithub.jsplaceholder.di.scopes.FragmentScope;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@Subcomponent(modules = {UsersModule.class})
@FragmentScope
public interface UsersComponent extends AndroidInjector<UsersFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<UsersFragment>{};
}
