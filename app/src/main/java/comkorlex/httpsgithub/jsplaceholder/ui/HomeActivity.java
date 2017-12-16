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
    private UsersFragment usersFragment;
    private UserDetailFragment userDetailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragManager();
        if (savedInstanceState == null) {
            addUsersFrag();
        }
    }

    private void initFragManager(){
        fragmentManager = getSupportFragmentManager();
    }


    private void addUsersFrag(){
        usersFragment = new UsersFragment();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frag_container, usersFragment);
        ft.commit();
    }

    public void addUserDetailFrag(Fragment fragment, int id){
        Bundle bundle = new Bundle();
        bundle.putInt(USER_ID, id);
        userDetailFragment = new UserDetailFragment();
        userDetailFragment.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.hide(fragment);
        ft.add(R.id.frag_container, userDetailFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void addGalleryFrag(Fragment fragment, int id){
        Bundle bundle = new Bundle();
        bundle.putInt(ALBUM_ID, id);
        GalleryFragment galleryFragment = new GalleryFragment();
        galleryFragment.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.hide(fragment);
        ft.add(R.id.frag_container, galleryFragment);
        ft.addToBackStack(null);
        ft.commit();
    }

    public void addPhotoFrag(Fragment fragment, String url){
        Bundle bundle = new Bundle();
        bundle.putString(PHOTO_URL, url);
        PhotoFragment photoFragment = new PhotoFragment();
        photoFragment.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.hide(fragment);
        ft.add(R.id.frag_container, photoFragment);
        ft.addToBackStack(null);
        ft.commit();
    }


}
