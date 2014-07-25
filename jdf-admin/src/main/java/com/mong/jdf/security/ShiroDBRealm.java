package com.mong.jdf.security;

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

import com.mong.jdf.admin.dao.UserDao;
import com.mong.jdf.admin.model.User;

public class ShiroDBRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /**
     * 认证回调函数, 登录时调用.
     */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = token.getUsername();
		if( username != null&& !"".equals(username) ){
		    User user = userDao.getUser(username);
		    if (user != null) {
	            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
	        }
		}
		return null;
	}

	/**
	 * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection principals) {
		User authUser = (User) principals.fromRealm(getName()).iterator().next();
		
		User user = userDao.getUser(authUser.getUsername());
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//			for (Group group : user.getGroupList()) {
//				// 基于Permission的权限信息
//				info.addStringPermissions(group.getPermissionList());
//			}
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
}
