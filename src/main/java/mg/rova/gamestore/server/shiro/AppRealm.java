package mg.rova.gamestore.server.shiro;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import mg.rova.gamestore.server.domain.User;

public class AppRealm extends AuthorizingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		return newSimpleAuthenticationInfo(usernamePasswordToken.getUsername(), String.valueOf(usernamePasswordToken.getPassword()), this.getClass().getName());
	}

	protected SimpleAuthenticationInfo newSimpleAuthenticationInfo(Object principal, Object credentials, String realmName) {
		return new SimpleAuthenticationInfo(principal, credentials, realmName);
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

		@SuppressWarnings("unchecked")
		final Collection<String> principalsList = principals.asList();

		if (principalsList.isEmpty()) {
			throw new AuthorizationException("Empty principals list!");
		}

		final SimpleAuthorizationInfo simpleAuthorizationInfo = newSimpleAuthorizationInfo();

		Set<String> userRoles = new HashSet<String>();
		for (String username : principalsList) {
			User user = findUserBy(username);
			userRoles.add(getRoleFor(user));
		}
		simpleAuthorizationInfo.setRoles(userRoles);

		return simpleAuthorizationInfo;
	}

	protected User findUserBy(String username) {
		/*return GuiceFactory.getInstance(UserDao.class).findByUsername(username);*/
		return null;
	}

	protected String getRoleFor(User user) {
		/*return user.getIsAdmin() ? Roles.ADMIN : Roles.EDITOR;*/
		return null;
	}

	protected SimpleAuthorizationInfo newSimpleAuthorizationInfo() {
		return new SimpleAuthorizationInfo();
	}
}
