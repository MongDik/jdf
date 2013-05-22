package com.mong.jdf.shiro;

import java.io.Serializable;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroDBRealm extends AuthorizingRealm {

	// @Override
	// protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection
	// arg0) {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// @Override
	// protected AuthenticationInfo doGetAuthenticationInfo(
	// AuthenticationToken arg0) throws AuthenticationException {
	// // TODO Auto-generated method stub
	// return null;
	// }

//	private AccountManager accountManager;
//	
//	@Autowired
//	public void setAccountManager(AccountManager accountManager) {
//		this.accountManager = accountManager;
//	}

	/**
	 * 认证回调函数, 登录时调用.
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
//		User user = accountManager.findUserByLoginName(token.getUsername());
//		if (user != null) {
		if(token.getUsername() != null){
//			return new SimpleAuthenticationInfo(new ShiroUser(
//					user.getLoginName(), user.getName()), user.getPassword(),
//					getName());
			
			String username = token.getUsername();
			return new SimpleAuthenticationInfo(new ShiroUser(
					username, "test"), "123456",
					getName());
		} else {
			return null;
		}
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.fromRealm(getName())
				.iterator().next();
//		User user = accountManager
//				.findUserByLoginName(shiroUser.getLoginName());
//		if (user != null) {
//			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			for (Group group : user.getGroupList()) {
//				// 基于Permission的权限信息
//				info.addStringPermissions(group.getPermissionList());
//			}
//			return info;
//		} else {
//			return null;
//		}
		
		
		if(shiroUser.getLoginName() != null){
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			return info;
		} else {
			return null;
		}
	}

	/**
	 * 更新用户授权信息缓存.
	 */
	public void clearCachedAuthorizationInfo(String principal) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principal, getName());
		clearCachedAuthorizationInfo(principals);
	}

	/**
	 * 清除所有用户授权信息缓存.
	 */
	public void clearAllCachedAuthorizationInfo() {
		Cache<Object, AuthorizationInfo> cache = getAuthorizationCache();
		if (cache != null) {
			for (Object key : cache.keys()) {
				cache.remove(key);
			}
		}
	}

	/**
	 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息.
	 */
	public static class ShiroUser implements Serializable {
		private static final long serialVersionUID = -1748602382963711884L;
		private String loginName;
		private String name;

		public ShiroUser(String loginName, String name) {
			this.loginName = loginName;
			this.name = name;
		}

		public String getLoginName() {
			return loginName;
		}

		/**
		 * 本函数输出将作为默认的<shiro:principal/>输出.
		 */
		@Override
		public String toString() {
			return loginName;
		}

		public String getName() {
			return name;
		}
	}
}
