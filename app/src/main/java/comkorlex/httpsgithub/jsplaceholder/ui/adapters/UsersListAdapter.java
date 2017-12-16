package comkorlex.httpsgithub.jsplaceholder.ui.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.R;
import comkorlex.httpsgithub.jsplaceholder.data.entity.User;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.UsersListViewHolder> {


    private List<User> users;
    private ListItemClickListener listItemClickListener;

    public UsersListAdapter() {
        users = new ArrayList<>();
    }

    @Override
    public UsersListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        final UsersListViewHolder userViewHolder = new UsersListViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = userViewHolder.getAdapterPosition();
                if (pos != NO_POSITION) listItemClickListener.onListItemClick(users.get(pos).getId());
            }
        });
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(UsersListViewHolder holder, int position) {
        holder.nickname.setText(users.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }


    public void setUsers(List<User> users){
        this.users = users;
    }


    public void setListener(ListItemClickListener listItemClickListener){
        this.listItemClickListener = listItemClickListener;
    }


    public class UsersListViewHolder extends RecyclerView.ViewHolder{

        private TextView nickname;

        public UsersListViewHolder(View itemView) {
            super(itemView);
            nickname = (TextView) itemView.findViewById(R.id.item_user_nickname);
        }
    }

}
