package src.Command;

class LogInCommand implements Command {
    Profile profile;

    public LogInCommand(Profile profile) {
        this.profile = profile;
    }

    public void execute() {
        this.profile.logIn();
    }
}