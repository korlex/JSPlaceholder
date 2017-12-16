package comkorlex.httpsgithub.jsplaceholder.di;

import android.support.v4.app.Fragment;

import comkorlex.httpsgithub.jsplaceholder.ui.gallery.GalleryComponent;
import comkorlex.httpsgithub.jsplaceholder.ui.gallery.GalleryFragment;
import comkorlex.httpsgithub.jsplaceholder.ui.userdetail.UserDetailComponent;
import comkorlex.httpsgithub.jsplaceholder.ui.userdetail.UserDetailFragment;
import comkorlex.httpsgithub.jsplaceholder.ui.users.UsersComponent;
import comkorlex.httpsgithub.jsplaceholder.ui.users.UsersFragment;
import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@Module
public abstract class FragmentBuilder {

    @Binds
    @IntoMap
    @FragmentKey(UsersFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindUsersFragment(UsersComponent.Builder builder);


    @Binds
    @IntoMap
    @FragmentKey(UserDetailFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindsUserDetailFragment(UserDetailComponent.Builder builder);


    @Binds
    @IntoMap
    @FragmentKey(GalleryFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment> bindsGalleryFragment(GalleryComponent.Builder builder);


}
