package net.webset.valid;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import net.webset.config.SecurityConstants;


@RestController
@RequestMapping(SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX)
public class ValidCodeController {

	@Autowired
	private ValidateCodeProcessorHolder validateCodeProcessorHolder;
	
	@GetMapping("/{type}")
	public void getImageCode(HttpServletRequest request, HttpServletResponse response
			,@PathVariable String type) throws Exception {
		
		validateCodeProcessorHolder.findValidateCodeProcessor(type)
			.create(new ServletWebRequest(request, response));
	}
}
