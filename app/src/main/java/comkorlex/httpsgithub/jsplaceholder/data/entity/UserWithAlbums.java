package comkorlex.httpsgithub.jsplaceholder.data.entity;


import java.util.List;

public class UserWithAlbums {

    private User user;
    private List<Album> albums;

    public UserWithAlbums(User user, List<Album> albums) {
        this.user = user;
        this.albums = albums;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }
}
