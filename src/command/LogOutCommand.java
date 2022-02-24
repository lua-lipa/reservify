package src.command;

class LogOutCommand implements Command {
    Profile profile;

    public LogOutCommand(Profile profile) {
        this.profile = profile;
    }

    public void execute() {
        this.profile.logOut();
    }
}
