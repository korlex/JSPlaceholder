package comkorlex.httpsgithub.jsplaceholder;

import android.app.Application;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import comkorlex.httpsgithub.jsplaceholder.di.app.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;


public class App extends Application implements HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> fragmentDispatchingAndroidInjector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent
                .builder()
                .application(this)
                .build()
                .inject(this);
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return fragmentDispatchingAndroidInjector;
    }




}
