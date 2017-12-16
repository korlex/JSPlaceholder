package comkorlex.httpsgithub.jsplaceholder.ui.users;

import java.util.List;

import comkorlex.httpsgithub.jsplaceholder.data.entity.User;

public interface UsersContract {

    public interface View{
        void showUsers(List<User> users);
        void showLoading();
        void showError(String infoMsg);
    }

    public interface Presenter{
        void setUsers();
    }

}
