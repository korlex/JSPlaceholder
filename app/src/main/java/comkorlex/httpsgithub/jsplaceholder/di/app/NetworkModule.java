package comkorlex.httpsgithub.jsplaceholder.di.app;

import javax.inject.Singleton;

import comkorlex.httpsgithub.jsplaceholder.data.retrofit.IJsonPlaceholderService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static comkorlex.httpsgithub.jsplaceholder.common.Constants.BASIC_URL;

@Module
public class NetworkModule {


    @Provides
    @Singleton
    public IJsonPlaceholderService getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASIC_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(IJsonPlaceholderService.class);
    }

}
