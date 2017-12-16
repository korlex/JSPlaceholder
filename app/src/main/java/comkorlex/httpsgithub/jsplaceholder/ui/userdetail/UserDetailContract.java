package comkorlex.httpsgithub.jsplaceholder.ui.userdetail;


import comkorlex.httpsgithub.jsplaceholder.data.entity.UserWithAlbums;

public interface UserDetailContract {

    public interface View{
        void showUserDetails(UserWithAlbums userWithAlbums);
        void showError(String errorMsg);
        void showLoading();
    }

    public interface Presenter{
        void setUserInfo(int id);
    }

}
