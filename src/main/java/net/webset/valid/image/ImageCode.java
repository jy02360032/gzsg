package net.webset.valid.image;

import java.awt.image.BufferedImage;
import java.io.Serializable;
import java.time.LocalDateTime;

import net.webset.valid.ValidateCode;

public class ImageCode extends ValidateCode implements Serializable {

	private static final long serialVersionUID = 1L;
	private BufferedImage image; 
	
	public ImageCode(BufferedImage image, String code, int expireIn){
		super(code, expireIn);
		this.image = image;
	}
	
	public ImageCode(BufferedImage image, String code, LocalDateTime expireTime){
		super(code, expireTime);
		this.image = image;
	}
	
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
}
