package si.bintegra.sp.util;

import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;

public class RoleChecker {

    private final static String ADMINISTRATOR_ROLE = "Administrator";


    public static boolean isUserAdministrator(User user) {
        for(Role r : user.getRoles()) {
            if (r.getName().equals(ADMINISTRATOR_ROLE)) {
                return true;
            }
        }
        return false;
    }

    public static void isUserAdministratorStrict(User user) throws IllegalAccessException {
        if (isUserAdministrator(user)) {
            throw new IllegalAccessException("userDoesNotHavePermission");
        }
    }

}
