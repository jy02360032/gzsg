package net.webset.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import net.webset.config.SecurityConstants;
import net.webset.entity.Menu;
import net.webset.entity.Msg;
import net.webset.entity.RoleMenu;
import net.webset.entity.User;
import net.webset.entity.UserRole;
import net.webset.service.IMenuService;

@RestController
@RequestMapping("/admin/")
public class AdminController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private IMenuService menuService;
		
	@GetMapping("login.html")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("index/login.html");
		return mav;
	}
	
	@GetMapping("mlogin.html")
	public ModelAndView mlogin(ModelAndView mav) {
		mav.setViewName("index/mlogin.html");
		return mav;
	}
	
	@PostMapping("menu.json")
	public List<Menu> menu(){
		List<Menu> results = new ArrayList<>();
		User user = (User) session.getAttribute("user");
		List<UserRole> urs = user.getUserRoles();
		for (UserRole ur : urs) {
			List<RoleMenu> rms = ur.getRole().getRoleMenus();
			for (RoleMenu rm : rms) {
				if(!StringUtils.startsWith(rm.getMenu().getHref(), SecurityConstants.AUTH_NODE)) {
					results.add(rm.getMenu());
				}
			}
		}
		List<Menu> userMenus = new ArrayList<>();
//		results.stream().distinct().forEach(b -> userMenus.add(b));
		/*modify start*/
		for (int i = 0; i < results.size() - 1; i++) {
			for (int j = results.size() - 1; j > i; j--) {
				if (results.get(j).getId().equals(results.get(i).getId())) {
					results.remove(j);
				}
			}
		}
		userMenus.addAll(results);
		/*modify end*/
		
		return getfatherNode(userMenus);
		
	}
	
	@GetMapping("index.html")
	public ModelAndView index(ModelAndView mav) {
		User user = (User) session.getAttribute("user");
		if(user == null) {
			mav.setViewName("error/.html");
		}
		mav.setViewName("index/main.html");
		Msg msg = new Msg("测试标题","测试内容","额外信息,只对管理员显示");
		mav.addObject("msg",msg);
		return mav;
	}
	
	@PostMapping("rms.json")
	public List<Menu> rms(){
		List<Menu> userMenus = menuService.list();
		return getfatherNode(userMenus);
	}
	
	/**
	 * 方法描述: 父节点
	 * @param treeDataList 菜单集合
	 * @return List<Menu> 菜单列表
	 */
    public final static List<Menu> getfatherNode(List<Menu> treeDataList) {
        List<Menu> newTreeDataList = new ArrayList<Menu>();
        for (Menu jsonTreeData : treeDataList) {
            if(jsonTreeData.getFatherid() == null) {
                //获取父节点下的子节点
            	List<Menu> children = getChildrenNode(jsonTreeData.getId(),treeDataList);
            	if(children.size() == 0) {
            		jsonTreeData.setNodes(null);
            	}else {
            		jsonTreeData.setNodes(children);
            	}
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }
     
    private final static List<Menu> getChildrenNode(Integer pid , List<Menu> treeDataList) {
        List<Menu> newTreeDataList = new ArrayList<Menu>();
        for (Menu jsonTreeData : treeDataList) {
            if(jsonTreeData.getFatherid() == null)  continue;
            //这是一个子节点
            if(jsonTreeData.getFatherid().equals(pid)){
                //递归获取子节点下的子节点
            	List<Menu> childs = getChildrenNode(jsonTreeData.getId() , treeDataList);
            	if(childs.size() == 0) {
            		jsonTreeData.setNodes(null);
            		jsonTreeData.setTags(0);
            	}else {
            		jsonTreeData.setNodes(childs);
            		jsonTreeData.setTags(childs.size());
            	}
                newTreeDataList.add(jsonTreeData);
            }
        }
        return newTreeDataList;
    }
    
    @GetMapping("fordLogin.html")
    public ModelAndView fordLogin(ModelAndView mav) {
    	mav.setViewName("/main/login.html");
    	return mav;
    }
}
