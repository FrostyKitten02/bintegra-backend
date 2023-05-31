package si.bintegra.sp.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;

public class RoleChecker {

    private final static String ADMINISTRATOR_ROLE = "Administrator";
    private final static String GUEST_ROLE = "Guest";


    public static boolean isUserAdministrator(User user) {
        return userHasRole(user, ADMINISTRATOR_ROLE);
    }

    public static boolean isUserGuest(User user) {
        return userHasRole(user, GUEST_ROLE);
    }

    private static boolean userHasRole(User user, String role) {
        for(Role r : user.getRoles()) {
            if (r.getName().equals(role)) {
                return true;
            }
        }
        return false;
    }

    public static void isUserAdministratorStrict(User user) throws PrincipalException {
        if (!isUserAdministrator(user)) {
            throw new PrincipalException("userDoesNotHavePermission");
        }
    }

    public static void isUserGuestStrict(User user) throws PrincipalException {
        if(isUserGuest(user)) {
            throw new PrincipalException("userDoesNotHavePermission");
        }
    }

}
