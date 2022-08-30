package pl.coderslab.utils;
import pl.coderslab.model.Admin;
import javax.servlet.http.HttpServletRequest;

public class UserUtil {
    public Admin getCurrentUser(HttpServletRequest request) {
        return (Admin) request.getAttribute("User");
    }
}
