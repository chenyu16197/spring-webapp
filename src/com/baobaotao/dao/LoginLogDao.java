package com.baobaotao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.baobaotao.domain.LoginLog;

@Repository  //通过Spring注解定义一个DAO
public class LoginLogDao {
	/**
	 * 	springJDBC通过一个模板类(jdbcTemplate)封装了样板式的代码
	 *	，用户通过模板类就可以轻松的完成大部分的数据访问的操作.
	 */
	@Autowired//自动注入JdbcTemplate的Bean(将Spring容器中的Bean注入进来)
	private JdbcTemplate jdbcTemplate;
	
	public void insertLoginLog(LoginLog loginLog) {
		String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_datetime) "
				+ "VALUES(?,?,?)";
		Object[] args = { loginLog.getUserId(), loginLog.getIp(),
				          loginLog.getLoginDate() };
		jdbcTemplate.update(sqlStr, args);
	}
}