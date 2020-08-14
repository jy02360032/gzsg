/**
 * 
 */
package net.webset.valid;

import org.springframework.web.context.request.ServletWebRequest;

public interface ValidateCodeGenerator {

	ValidateCode generate(ServletWebRequest request);
	
}
