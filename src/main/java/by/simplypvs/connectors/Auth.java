package by.simplypvs.connectors;

import javax.servlet.http.HttpSession;
import static java.util.Objects.nonNull;

public  class Auth {
    public static boolean checkAuth(final HttpSession session, final String... roles) {
        String sessionRole = (String) session.getAttribute("role");
        if (nonNull(sessionRole)) {
            for (String role : roles
            ) {
                if (sessionRole.equals(role)) return true;

            }
        }
        return false;

    }
}
