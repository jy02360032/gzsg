package net.webset.config;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import net.webset.entity.Menu;
import net.webset.mapper.MenuMapper;
import net.webset.service.IUserService;
import net.webset.valid.ValidateCodeSecurityConfig;

/**
 * spring_security配置
 * @author 梁雪峰
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	@Autowired
	private IUserService userService;

	@Autowired
	private DataSource dataSource;

	@Autowired
	SecurityProperties sp;

	@Autowired
	private ValidateCodeSecurityConfig validateCodeSecurityConfig;
	
	@Autowired
	private MenuMapper menuMapper;
	
	@Autowired
	protected AuthenticationFailureHandler authenticationFailureHandler;
	
	@Bean
	public PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		// tokenRepository.setCreateTableOnStartup(true);
		return tokenRepository;
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.apply(validateCodeSecurityConfig).and().headers().frameOptions().sameOrigin()
				// 权限控制
				.and().authorizeRequests().antMatchers(sp.getBrowser().getStaticSources()).permitAll()
				.and().authorizeRequests().antMatchers(getAllPrimission())
				.access("@rbacService.hasPrimission(request,authentication)")
				// 关闭跨站防护功能
				.and().csrf().disable()
				// 表单登录设置
				.formLogin().loginPage(sp.getBrowser().getLoginPage())
				.loginProcessingUrl(sp.getBrowser().getLoginProcess())
				// 设置默认登录成功跳转页面
				.defaultSuccessUrl(sp.getBrowser().getLoginProcess())
				.failureUrl(sp.getBrowser().getLoginPage() + "?error=true")
				.and().logout().logoutUrl("/logout.html").logoutSuccessUrl(sp.getBrowser().getLoginPage())
				// 开启cookie保存用户数据
				.and().rememberMe().tokenValiditySeconds(1209600)
				// 指定记住登录信息所使用的数据源
				.tokenRepository(tokenRepository()) // code4
				// 设置cookie有效期
				.tokenValiditySeconds(sp.getBrowser().getRememberMeSeconds())
				// 默认登出方法
				.and().logout().logoutUrl(sp.getBrowser().getLogOutPage())
				// 默认登出跳转页面
				.logoutSuccessUrl(sp.getBrowser().getLoginPage())
				// session控制
				.and().sessionManagement()
				.maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions())
				.maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin());
	}

	/**
	 * 获取所有需要校验的权限信息
	 * 
	 * @return String[] 系统的所有校验信息
	 */
	private String[] getAllPrimission() {
		QueryWrapper<Menu> mwapper = new QueryWrapper<Menu>();
		mwapper.isNotNull(Menu.AUTHSTR);
		mwapper.ne(Menu.AUTHSTR, "");
		List<Menu> menus = menuMapper.selectList(mwapper);
		String[] authStrs = new String[menus.size()];
		for (int i = 0; i < menus.size(); i++) {
			authStrs[i] = menus.get(i).getAuthstr();
		}

		return authStrs;
	}
}
