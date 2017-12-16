package comkorlex.httpsgithub.jsplaceholder.ui.users;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;
import comkorlex.httpsgithub.jsplaceholder.ui.HomeActivity;
import comkorlex.httpsgithub.jsplaceholder.ui.adapters.ListItemClickListener;
import comkorlex.httpsgithub.jsplaceholder.ui.adapters.UsersListAdapter;
import dagger.android.support.AndroidSupportInjection;

public class UsersFragment extends Fragment implements UsersContract.View, ListItemClickListener, View.OnClickListener {


    @Inject UsersContract.Presenter usersPresenter;
    @BindView(R.id.users_state_layout) StatefulLayout usersStateLayout;
    @BindView(R.id.users_list) RecyclerView usersList;

    private Unbinder unbinder;
    private UsersListAdapter usersListAdapter;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidSupportInjection.inject(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_users, container, false);
        unbinder = ButterKnife.bind(this, v);
        setList();
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersPresenter.setUsers();

    }


    private void setList(){
        usersListAdapter = new UsersListAdapter();
        usersListAdapter.setListener(this);
        usersList.setLayoutManager(new LinearLayoutManager(getActivity()));
        usersList.setAdapter(usersListAdapter);
    }



    @Override
    public void onListItemClick(int id) {
        ((HomeActivity) getActivity()).addUserDetailFrag(this, id);
    }

//    retry btn
    @Override
    public void onClick(View v) {
        usersPresenter.setUsers();
    }

    @Override
    public void showUsers(List<User> users) {
        usersStateLayout.showContent();
        usersListAdapter.setUsers(users);
        usersListAdapter.notifyDataSetChanged();
    }


    @Override
    public void showLoading() {
        usersStateLayout.showLoading();
    }


    @Override
    public void showError(String infoMsg) {
        usersStateLayout.showError(infoMsg, this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //    restore activity/fragment/view  ... dagger clearUsersComp component !!!


}
