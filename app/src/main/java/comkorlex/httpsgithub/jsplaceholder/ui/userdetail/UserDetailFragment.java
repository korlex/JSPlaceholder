package comkorlex.httpsgithub.jsplaceholder.ui.userdetail;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gturedi.views.StatefulLayout;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import comkorlex.httpsgithub.jsplaceholder.R;
import comkorlex.httpsgithub.jsplaceholder.data.entity.UserWithAlbums;
import comkorlex.httpsgithub.jsplaceholder.ui.HomeActivity;
import comkorlex.httpsgithub.jsplaceholder.ui.adapters.AlbumsListAdapter;
import comkorlex.httpsgithub.jsplaceholder.ui.adapters.ListItemClickListener;
import dagger.android.support.AndroidSupportInjection;

import static comkorlex.httpsgithub.jsplaceholder.common.Constants.USER_ID;


public class UserDetailFragment extends Fragment implements UserDetailContract.View, View.OnClickListener, ListItemClickListener {

    @Inject UserDetailContract.Presenter userDetailPresenter;
    @BindView(R.id.user_detail_state_layout) StatefulLayout userDetailStateLayout;
    @BindView(R.id.user_detail_username) TextView nickName;
    @BindView(R.id.user_detail_name) TextView name;
    @BindView(R.id.user_detail_mail) TextView mail;
    @BindView(R.id.user_detail_phone) TextView phone;
    @BindView(R.id.albums_list) RecyclerView albumsList;
    private Unbinder unbinder;
    private AlbumsListAdapter albumsListAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_detail, container, false);
        unbinder = ButterKnife.bind(this, v);
        setList();
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        userDetailPresenter.setUserInfo(getUserId());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void showUserDetails(UserWithAlbums userWithAlbums) {
        userDetailStateLayout.showContent();
        nickName.setText(userWithAlbums.getUser().getUsername());
        name.setText(userWithAlbums.getUser().getName());
        mail.setText(userWithAlbums.getUser().getEmail());
        phone.setText(userWithAlbums.getUser().getPhone());
        albumsListAdapter.setAlbums(userWithAlbums.getAlbums());
        albumsListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String errorMsg) {
        userDetailStateLayout.showError(errorMsg, this);
    }

    @Override
    public void showLoading() {
        userDetailStateLayout.showLoading();
    }


    //    retry btn
    @Override
    public void onClick(View v) {
        userDetailPresenter.setUserInfo(getUserId());
    }

    @Override
    public void onListItemClick(int id) {
        ((HomeActivity) getActivity()).addGalleryFrag(this, id);
    }

    private int getUserId(){
        Bundle bundle = getArguments();
        int id = bundle.getInt(USER_ID);
        return  id;
    }

    private void setList(){
        albumsListAdapter = new AlbumsListAdapter();
        albumsListAdapter.setListener(this);
        albumsList.setLayoutManager(new LinearLayoutManager(getActivity()));
        albumsList.setAdapter(albumsListAdapter);
    }


}
