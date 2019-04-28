package cn.practice.BZhan._04_Reflection.Neixing;

public class Config {
    private String username;
    private String passward;
    private String url;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Config{" +
                "username='" + username + '\'' +
                ", passward='" + passward + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
