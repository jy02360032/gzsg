/**
 * 
 */
package net.webset.social.qq.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;

import net.webset.config.QQProperties;
import net.webset.config.SecurityProperties;
import net.webset.social.qq.connect.QQConnectionFactory;

/**
 * @author 梁雪峰
 *
 */
@Configuration
@ConditionalOnProperty(prefix = "config.social.qq", name = "app-id")
public class QQAutoConfig extends SocialConfigurerAdapter {

	@Autowired
	private SecurityProperties securityProperties;

	/**
	 * 第三方登录【QQ方式】
	 */
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment environment) {
		QQProperties qqConfig = securityProperties.getSocial().getQq();
		super.addConnectionFactories(connectionFactoryConfigurer, environment);
		connectionFactoryConfigurer.addConnectionFactory(new QQConnectionFactory(
				qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret()));
	}

}
