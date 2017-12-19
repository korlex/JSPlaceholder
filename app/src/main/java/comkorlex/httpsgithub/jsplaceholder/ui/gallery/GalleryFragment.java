package comkorlex.httpsgithub.jsplaceholder.ui.gallery;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gturedi.views.StatefulLayout;

import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import comkorlex.httpsgithub.jsplaceholder.R;
import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;
import comkorlex.httpsgithub.jsplaceholder.ui.HomeActivity;
import comkorlex.httpsgithub.jsplaceholder.ui.adapters.PhotosGridAdapter;
import comkorlex.httpsgithub.jsplaceholder.ui.adapters.PhotosGridItemClickListener;
import dagger.android.support.AndroidSupportInjection;

import static comkorlex.httpsgithub.jsplaceholder.common.Constants.ALBUM_ID;

public class GalleryFragment extends Fragment implements GalleryContract.View, View.OnClickListener, PhotosGridItemClickListener {

    @Inject GalleryContract.Presenter galleryPresenter;
    @BindView(R.id.gallery_state_layout) StatefulLayout galleryStateLayout;
    @BindView(R.id.photos_grid) RecyclerView photosGrid;
    private PhotosGridAdapter photosGridAdapter;
    private Unbinder unbinder;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        unbinder = ButterKnife.bind(this, v);
        setGrid();
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        galleryPresenter.setPhotos(getAlbumId());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }



    @Override
    public void showPhotos(List<Photo> photos) {
        galleryStateLayout.showContent();
        photosGridAdapter.setPhotos(photos);
        photosGridAdapter.notifyDataSetChanged();
    }

    @Override
    public void showLoading() {
        galleryStateLayout.showLoading();
    }

    @Override
    public void showError(String errorMsg) {
        galleryStateLayout.showError(errorMsg, this);
    }

//    retry btn
    @Override
    public void onClick(View v) {
        galleryPresenter.setPhotos(getAlbumId());
    }

    @Override
    public void onItemClick(String url) {
        ((HomeActivity) getActivity()).createAndAddPhotoFrag(this, url);
    }

    private void setGrid(){
        photosGridAdapter = new PhotosGridAdapter(getActivity());
        photosGridAdapter.setListener(this);
        photosGrid.setLayoutManager(new GridLayoutManager(getActivity(),4));
        photosGrid.setAdapter(photosGridAdapter);
    }

    private int getAlbumId(){
        Bundle bundle = getArguments();
        int albumId = bundle.getInt(ALBUM_ID);
        return albumId;
    }

}
