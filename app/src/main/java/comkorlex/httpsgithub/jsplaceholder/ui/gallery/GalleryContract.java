package comkorlex.httpsgithub.jsplaceholder.ui.gallery;


import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.Photo;

public interface GalleryContract {

    public interface View{
        void showPhotos(List<Photo> photos);
        void showLoading();
        void showError(String errorMsg);
    }

    public interface Presenter{
        void setPhotos(int albumId);
    }

}
