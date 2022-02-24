package src.command;

public class Profile {
    private String status;
    private int id;

    public Profile() {
        System.out.println("Profile");
        this.id = 1;
    }

    public void logIn() {
        this.status = "signed in";
        System.out.println(status);
        System.out.println(id);

    }

    public void logOut() {
        this.status = "signed out";
        System.out.println(status);
        System.out.println(id);
    }
}
