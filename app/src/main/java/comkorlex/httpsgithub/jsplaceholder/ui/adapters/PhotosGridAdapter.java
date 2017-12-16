package comkorlex.httpsgithub.jsplaceholder.ui.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.R;
import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

public class PhotosGridAdapter extends RecyclerView.Adapter<PhotosGridAdapter.PhotosGridViewHolder> {

    private Context context;
    private List<Photo> photos;
    private PhotosGridItemClickListener itemClickListener;


    public PhotosGridAdapter(Context context) {
        this.context = context;
        photos = new ArrayList<>();
    }

    @Override
    public PhotosGridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);
        final PhotosGridViewHolder photosGridViewHolder = new PhotosGridViewHolder(v);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = photosGridViewHolder.getAdapterPosition();
                if (pos != NO_POSITION) itemClickListener.onItemClick(photos.get(pos).getUrl());
            }
        });
        return photosGridViewHolder;
    }

    @Override
    public void onBindViewHolder(PhotosGridViewHolder holder, int position) {
        Picasso.with(context).load(photos.get(position).getThumbnailUrl()).error(R.drawable.ic_photo_black_56dp).into(holder.galleryPhoto);
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    public void setPhotos(List<Photo> photos){
        this.photos = photos;
    }

    public void setListener(PhotosGridItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public class PhotosGridViewHolder extends RecyclerView.ViewHolder{
        private ImageView galleryPhoto;

        public PhotosGridViewHolder(View itemView) {
            super(itemView);
            galleryPhoto = (ImageView) itemView.findViewById(R.id.gallery_photo);
        }
    }

}
