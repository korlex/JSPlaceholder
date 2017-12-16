package comkorlex.httpsgithub.jsplaceholder.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.R;
import comkorlex.httpsgithub.jsplaceholder.data.entity.Album;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class AlbumsListAdapter extends RecyclerView.Adapter<AlbumsListAdapter.AlbumsListViewHolder> {


    private List<Album> albums;
    private ListItemClickListener listItemClickListener;


    public AlbumsListAdapter() {
        albums = new ArrayList<>();
    }

    public void setAlbums(List<Album> albums){
        this.albums = albums;
    }

    public void setListener(ListItemClickListener listItemClickListener){
        this.listItemClickListener = listItemClickListener;
    }

    @Override
    public AlbumsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_album, parent, false);
        final AlbumsListViewHolder albumsListVH = new AlbumsListViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = albumsListVH.getAdapterPosition();
                if (pos != NO_POSITION) listItemClickListener.onListItemClick(albums.get(pos).getId());
            }
        });
        return albumsListVH;
    }

    @Override
    public void onBindViewHolder(AlbumsListViewHolder holder, int position) {
        holder.albumTitle.setText(albums.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return albums.size();
    }

    public class AlbumsListViewHolder extends RecyclerView.ViewHolder{

        private TextView albumTitle;

        public AlbumsListViewHolder(View itemView) {
            super(itemView);
            albumTitle = (TextView) itemView.findViewById(R.id.album_title);
        }
    }

}
