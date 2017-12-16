package comkorlex.httpsgithub.jsplaceholder.di.app;

import android.app.Application;

import javax.inject.Singleton;

import comkorlex.httpsgithub.jsplaceholder.App;
import comkorlex.httpsgithub.jsplaceholder.di.FragmentBuilder;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
//        AppModule.class,
        NetworkModule.class,
        InteractorModule.class,
        FragmentBuilder.class,
        AndroidInjectionModule.class
        })

@Singleton
public interface AppComponent {

    @Component.Builder
    interface Builder{
        @BindsInstance Builder application (Application application);
        AppComponent build();
    }

    void inject(App app);

}
