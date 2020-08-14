package net.webset.wapper.api.conditions;

public class RoleApi {

	/**
	 * 权限ID
	 */
	private Integer id;

    /**
     * 权限名称
     */
    private String name;

    /**
     * 权限说明
     */
    private String text;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
    
}
