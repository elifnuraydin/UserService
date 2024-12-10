package camping.user.CampingUser.bussines.Exception;

public class UserProblemException {
    private  String messages ;

    public UserProblemException(String messages) {
        this.messages = messages;
    }

    public UserProblemException() {
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
