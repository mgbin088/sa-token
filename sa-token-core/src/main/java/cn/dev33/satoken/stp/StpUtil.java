package cn.dev33.satoken.stp;

import java.util.List;

import cn.dev33.satoken.session.SaSession;

/**
 * 一个默认的实现 
 * @author kong 
 */
public class StpUtil {

	/**
	 * 底层的 StpLogic 对象  
	 */
	public static StpLogic stpLogic = new StpLogic("login"); 
	
	
	// =================== 获取token 相关 ===================

	/**
	 * 返回token名称 
	 * @return 此StpLogic的token名称
	 */
	public static String getTokenName() {
 		return stpLogic.getTokenName();
 	}

	/**
	 *  获取当前tokenValue
	 * @return 当前tokenValue
	 */
	public static String getTokenValue() {
		return stpLogic.getTokenValue();
	}

	/**
	 * 获取当前StpLogin的loginKey
	 * @return 当前StpLogin的loginKey
	 */
	public static String getLoginKey(){
		return stpLogic.getLoginKey();
	}

	/**
	 * 获取当前会话的token信息 
	 * @return token信息 
	 */
	public static SaTokenInfo getTokenInfo() {
		return stpLogic.getTokenInfo();
	}

	
	// =================== 登录相关操作 ===================

	/**
	 * 在当前会话上登录id 
	 * @param loginId 登录id，建议的类型：（long | int | String）
	 */
	public static void setLoginId(Object loginId) {
		stpLogic.setLoginId(loginId);
	}

	/** 
	 * 当前会话注销登录
	 */
	public static void logout() {
		stpLogic.logout();
	}

	/**
	 * 指定token的会话注销登录 
	 * @param tokenValue 指定token
	 */
	public static void logoutByTokenValue(String tokenValue) {
		stpLogic.logoutByTokenValue(tokenValue);
	}
	
	/**
	 * 指定loginId的会话注销登录（踢人下线）
	 * <p> 当对方再次访问系统时，会抛出NotLoginException异常，场景值=-2
	 * @param loginId 账号id 
	 */
	public static void logoutByLoginId(Object loginId) {
		stpLogic.logoutByLoginId(loginId);
	}

	
	// 查询相关

 	/** 
 	 * 获取当前会话是否已经登录 
 	 * @return 是否已登录 
 	 */
	public static boolean isLogin() {
		return stpLogic.isLogin();
	}

 	/** 
 	 * 检验当前会话是否已经登录，如未登录，则抛出异常 
 	 */
 	public static void checkLogin() {
 		stpLogic.checkLogin();
 	}

 	/** 
 	 * 获取当前会话账号id, 如果未登录，则抛出异常 
 	 * @return 账号id
 	 */
	public static Object getLoginId() {
		return stpLogic.getLoginId();
	}

	/** 
	 * 获取当前会话登录id, 如果未登录，则返回默认值 
	 * @param <T> 返回类型 
	 * @param defaultValue 默认值
	 * @return 登录id 
	 */
	public static <T> T getLoginId(T defaultValue) {
		return stpLogic.getLoginId(defaultValue);
	}

	/** 
	 * 获取当前会话登录id, 如果未登录，则返回null 
	 * @return 账号id 
	 */
	public static Object getLoginIdDefaultNull() {
		return stpLogic.getLoginIdDefaultNull();
 	}

	/** 
	 * 获取当前会话登录id, 并转换为String
	 * @return 账号id 
	 */
	public static String getLoginIdAsString() {
		return stpLogic.getLoginIdAsString();
	}

	/** 
	 * 获取当前会话登录id, 并转换为int
	 * @return 账号id 
	 */
	public static int getLoginIdAsInt() {
		return stpLogic.getLoginIdAsInt();
	}

	/**
	 * 获取当前会话登录id, 并转换为long
	 * @return 账号id 
	 */
	public static long getLoginIdAsLong() {
		return stpLogic.getLoginIdAsLong();
	}

 	/** 
 	 * 获取指定token对应的登录id，如果未登录，则返回 null 
 	 * @param tokenValue token
 	 * @return 登录id
 	 */
 	public static Object getLoginIdByToken(String tokenValue) {
 		return stpLogic.getLoginIdByToken(tokenValue);
 	}
	
 	
	// =================== session相关 ===================

	/** 
	 * 获取指定loginId的session, 如果session尚未创建，isCreate=是否新建并返回
	 * @param loginId 账号id
	 * @param isCreate 是否新建
	 * @return SaSession
	 */
	public static SaSession getSessionByLoginId(Object loginId, boolean isCreate) {
		return stpLogic.getSessionByLoginId(loginId, isCreate);
	}

	/** 
	 * 获取指定loginId的session，如果session尚未创建，则新建并返回 
	 * @param loginId 账号id 
	 * @return session会话 
	 */
	public static SaSession getSessionByLoginId(Object loginId) {
		return stpLogic.getSessionByLoginId(loginId);
	}

	/** 
	 * 获取当前会话的session, 如果session尚未创建，isCreate=是否新建并返回 
	 * @param isCreate 是否新建 
	 * @return 当前会话的session 
	 */
	public static SaSession getSession(boolean isCreate) {
		return stpLogic.getSession(isCreate);
	}

	/** 
	 * 获取当前会话的session，如果session尚未创建，则新建并返回 
	 * @return 当前会话的session 
	 */
	public static SaSession getSession() {
		return stpLogic.getSession();
	}

	
	// =================== token专属session ===================  
	
	/** 
	 * 获取指定token的专属session，如果session尚未创建，则新建并返回 
	 * @param tokenValue token值
	 * @return session会话 
	 */
	public static SaSession getTokenSessionByToken(String tokenValue) {
		return stpLogic.getTokenSessionByToken(tokenValue);
	}
	
	/** 
	 * 获取当前token的专属-session，如果session尚未创建，则新建并返回 
	 * @return session会话 
	 */
	public static SaSession getTokenSession() {
		return stpLogic.getTokenSession();
	}


	// =================== [临时过期] 验证相关 ===================  

 	/**
 	 * 检查当前token 是否已经[临时过期]，如果已经过期则抛出异常  
 	 */
 	public static void checkActivityTimeout() {
 		stpLogic.checkActivityTimeout();
 	}

 	/**
 	 * 续签当前token：(将 [最后操作时间] 更新为当前时间戳) 
 	 * <h1>请注意: 即时token已经 [临时过期] 也可续签成功，
 	 * 如果此场景下需要提示续签失败，可在此之前调用 checkActivityTimeout() 强制检查是否过期即可 </h1>
 	 */
 	public static void updateLastActivityToNow() {
 		stpLogic.updateLastActivityToNow();
 	}
 	

	// =================== 过期时间相关 ===================  

 	/**
 	 * 获取当前登录者的token剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public static long getTokenTimeout() {
 		return stpLogic.getTokenTimeout();
 	}
 	
 	/**
 	 * 获取当前登录者的Session剩余有效时间 (单位: 秒)
 	 * @return token剩余有效时间
 	 */
 	public static long getSessionTimeout() {
 		return stpLogic.getSessionTimeout();
 	}

 	/**
 	 * 获取当前token的专属Session剩余有效时间 (单位: 秒) 
 	 * @return token剩余有效时间
 	 */
 	public static long getTokenSessionTimeout() {
 		return stpLogic.getTokenSessionTimeout();
 	}
 	
 	/**
 	 * 获取当前token[临时过期]剩余有效时间 (单位: 秒)
 	 * @return token[临时过期]剩余有效时间
 	 */
 	public static long getTokenActivityTimeout() {
 		return stpLogic.getTokenActivityTimeout();
 	}
 	

 	
	// =================== 角色验证操作 ===================  

 	/** 
 	 * 指定账号id是否含有角色标识 
 	 * @param loginId 账号id
 	 * @param role 角色标识
 	 * @return 是否含有指定角色标识
 	 */
 	public static boolean hasRole(Object loginId, String role) {
 		return stpLogic.hasRole(loginId, role);
 	}
 	
 	/** 
 	 * 当前账号id是否含有指定角色标识
 	 * @param role 角色标识
 	 * @return 是否含有指定角色标识
 	 */
 	public static boolean hasRole(String role) {
 		return stpLogic.hasRole(role);
 	}
	
 	/** 
 	 * 当前账号是否含有指定角色标识，没有就抛出异常
 	 * @param role 角色标识
 	 */
 	public static void checkRole(String role) {
 		stpLogic.checkRole(role);
 	}

 	/** 
 	 * 当前账号是否含有指定角色标识, [指定多个，必须全都有]
 	 * @param roleArray 角色标识数组
 	 */
 	public static void checkRoleAnd(String... roleArray){
 		stpLogic.checkRoleAnd(roleArray);
 	}

 	/** 
 	 * 当前账号是否含有指定角色标识, [指定多个，有一个就可以通过]
 	 * @param roleArray 角色标识数组
 	 */
 	public static void checkRoleOr(String... roleArray){
 		stpLogic.checkRoleOr(roleArray);
 	}
 	
	
	// =================== 权限验证操作 ===================

 	/** 
 	 * 指定账号id是否含有指定权限 
 	 * @param loginId 账号id
 	 * @param permissionCode 权限码
 	 * @return 是否含有指定权限
 	 */
	public static boolean hasPermission(Object loginId, String permissionCode) {
		return stpLogic.hasPermission(loginId, permissionCode);
	}

 	/** 
 	 * 当前账号id是否含有指定权限 
 	 * @param permissionCode 权限码
 	 * @return 是否含有指定权限
 	 */
	public static boolean hasPermission(String permissionCode) {
		return stpLogic.hasPermission(permissionCode);
	}

 	/** 
 	 * 当前账号是否含有指定权限， 没有就抛出异常 
 	 * @param permissionCode 权限码
 	 */
	public static void checkPermission(String permissionCode) {
		stpLogic.checkPermission(permissionCode);
	}

 	/** 
 	 * 当前账号是否含有指定权限, [指定多个，必须全都有] 
 	 * @param permissionCodeArray 权限码数组
 	 */
	public static void checkPermissionAnd(String... permissionCodeArray) {
		stpLogic.checkPermissionAnd(permissionCodeArray);
	}

 	/** 
 	 * 当前账号是否含有指定权限, [指定多个，有一个就可以通过] 
 	 * @param permissionCodeArray 权限码数组
 	 */
	public static void checkPermissionOr(String... permissionCodeArray) {
		stpLogic.checkPermissionOr(permissionCodeArray);
	}


	// =================== id 反查token 相关操作 ===================  
	
	/** 
	 * 获取指定loginId的tokenValue 
	 * <p> 在配置为允许并发登录时，此方法只会返回队列的最后一个token，
	 * 如果你需要返回此账号id的所有token，请调用 getTokenValueListByLoginId 
	 * @param loginId 账号id
	 * @return token值 
	 */
	public static String getTokenValueByLoginId(Object loginId) {
		return stpLogic.getTokenValueByLoginId(loginId);
	}
	
 	/** 
	 * 获取指定loginId的tokenValue 
	 * @param loginId 账号id 
	 * @return 此loginId的所有相关token 
 	 */
	public static List<String> getTokenValueListByLoginId(Object loginId) {
		return stpLogic.getTokenValueListByLoginId(loginId);
	}
	
	
}
