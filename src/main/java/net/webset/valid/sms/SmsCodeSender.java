/**
 * 
 */
package net.webset.valid.sms;

/**
 * @author 梁雪峰
 *
 */
public interface SmsCodeSender {
	
	void send(String mobile, String code);

}
