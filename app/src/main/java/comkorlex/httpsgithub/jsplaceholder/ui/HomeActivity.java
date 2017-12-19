package comkorlex.httpsgithub.jsplaceholder.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import comkorlex.httpsgithub.jsplaceholder.R;
import comkorlex.httpsgithub.jsplaceholder.ui.gallery.GalleryFragment;
import comkorlex.httpsgithub.jsplaceholder.ui.photo.PhotoFragment;
import comkorlex.httpsgithub.jsplaceholder.ui.userdetail.UserDetailFragment;
import comkorlex.httpsgithub.jsplaceholder.ui.users.UsersFragment;

import static comkorlex.httpsgithub.jsplaceholder.common.Constants.ALBUM_ID;
import static comkorlex.httpsgithub.jsplaceholder.common.Constants.PHOTO_URL;
import static comkorlex.httpsgithub.jsplaceholder.common.Constants.USER_ID;

public class HomeActivity extends AppCompatActivity {


    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initFragManager();
        if (savedInstanceState == null) {
            createAndAddUsersFrag();
        }
    }

    private void initFragManager(){
        fragmentManager = getSupportFragmentManager();
    }


    private void createAndAddUsersFrag(){
        UsersFragment usersFragment = new UsersFragment();
        addFragment(null, usersFragment, false);
    }

    public void createAndAddUserDetailFrag(Fragment fragment, int id){
        Bundle bundle = new Bundle();
        bundle.putInt(USER_ID, id);
        UserDetailFragment userDetailFragment = new UserDetailFragment();
        userDetailFragment.setArguments(bundle);
        addFragment(fragment, userDetailFragment, true);
    }

    public void createAndAddGalleryFrag(Fragment fragment, int id){
        Bundle bundle = new Bundle();
        bundle.putInt(ALBUM_ID, id);
        GalleryFragment galleryFragment = new GalleryFragment();
        galleryFragment.setArguments(bundle);
        addFragment(fragment, galleryFragment, true);
    }

    public void createAndAddPhotoFrag(Fragment fragment, String url){
        Bundle bundle = new Bundle();
        bundle.putString(PHOTO_URL, url);
        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(bundle);
        addFragment(fragment, photoFragment, true);
    }

    private void addFragment(Fragment old, Fragment requested, boolean addToBackstack){
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (old != null)ft.hide(old);
        ft.add(R.id.frag_container, requested);
        if (addToBackstack)ft.addToBackStack(null);
        ft.commit();
    }


}
