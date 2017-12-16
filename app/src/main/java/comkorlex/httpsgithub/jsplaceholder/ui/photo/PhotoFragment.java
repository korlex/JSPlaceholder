package comkorlex.httpsgithub.jsplaceholder.ui.photo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import comkorlex.httpsgithub.jsplaceholder.R;

import static comkorlex.httpsgithub.jsplaceholder.common.Constants.PHOTO_URL;

public class PhotoFragment extends Fragment {

    @BindView(R.id.photo) ImageView photo;
    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo, container, false);
        unbinder = ButterKnife.bind(this, v);
        return v;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Picasso.with(getActivity()).load(getPhotoUrl()).error(R.drawable.ic_photo_album_black_56dp).into(photo);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private String getPhotoUrl(){
        Bundle bundle = getArguments();
        String photoUrl = bundle.getString(PHOTO_URL);
        return photoUrl;
    }

}
