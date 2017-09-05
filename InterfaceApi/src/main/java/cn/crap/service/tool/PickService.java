package cn.crap.service.tool;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.crap.dto.LoginInfoDto;
import cn.crap.dto.PickDto;
import cn.crap.enumeration.InterfaceStatus;
import cn.crap.enumeration.MonitorType;
import cn.crap.enumeration.RequestMethod;
import cn.crap.enumeration.TrueOrFalse;
import cn.crap.framework.MyException;
import cn.crap.inter.service.table.IArticleService;
import cn.crap.inter.service.table.IErrorService;
import cn.crap.inter.service.table.IMenuService;
import cn.crap.inter.service.table.IModuleService;
import cn.crap.inter.service.table.IProjectService;
import cn.crap.inter.service.table.IRoleService;
import cn.crap.inter.service.table.IUserService;
import cn.crap.inter.service.tool.ICacheService;
import cn.crap.inter.service.tool.IPickService;
import cn.crap.model.Error;
import cn.crap.service.tool.AdminPickService.op;
import cn.crap.utils.Tools;

/**
 * 下拉选着
 * @author Ehsan
 *
 */
@Service("pickService")
public class PickService implements IPickService{
	@Autowired
	IMenuService menuService;
	@Autowired
	private ICacheService cacheService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IProjectService projectService;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private IModuleService moduleService;
	@Autowired
	private IArticleService articleService;
	@Autowired
	private IErrorService errorService;

	
	public enum op{ 
		REQUESTMETHOD(1,"REQUESTMETHOD"),
		INTERFACESTATUS(2,"INTERFACESTATUS"),
		TRUEORFALSE(3,"TRUEORFALSE"),
		MONITORTYPE(4,"MONITORTYPE"),
		ERRORCODE(5,"ERRORCODE");
		
		private int value;
		private String name;
		 op(int value,String name){
			this.name=name;
			this.value=value;
		}
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
	}
	
	//@Override
	public void getPickList(List<PickDto> picks, String code, String key, LoginInfoDto user) throws MyException {
		PickDto pick = null;
		/*op c=cn.crap.utils.EnumUtils.valueOf(op.class,code);
		switch (c) {*/
//			case "RECOMMENDPROJECT": // 推荐的模块
//				for (Project p : projectService.findByMap(Tools.getMap("type", ProjectType.RECOMMEND.getType() ), null, null)) {
//					pick = new PickDto(p.getId(), p.getName());
//					picks.add(pick);
//				}
//				return;
		if("REQUESTMETHOD".equals(code)){
			//case REQUESTMETHOD: // 枚举 请求方式 post get
				for (RequestMethod status : RequestMethod.values()) {
					pick = new PickDto(status.name(), status.getName(), status.getName());
					picks.add(pick);
				}
				return;
		}else if("INTERFACESTATUS".equals(code)){
				// 枚举 接口状态
				//case INTERFACESTATUS:
				for (InterfaceStatus status : InterfaceStatus.values()) {
					pick = new PickDto(status.getName(), status.name());
					picks.add(pick);
				}
				return;
		}else if("TRUEORFALSE".equals(code)){
				//case TRUEORFALSE:// 枚举true or false
				for (TrueOrFalse status : TrueOrFalse.values()) {
					pick = new PickDto(status.getName(), status.name());
					picks.add(pick);
				}
				return;
		}else if("MONITORTYPE".equals(code)){
				//case MONITORTYPE:// 监控类型
				for (MonitorType monitorType : MonitorType.values()) {
					pick = new PickDto(monitorType.name(), monitorType.getValue()+"", monitorType.getName());
					picks.add(pick);
				}
				return;
		}else if("ERRORCODE".equals(code)){
				//case ERRORCODE:// 错误码
				for (Error error : errorService.findByMap(
						Tools.getMap("moduleId", key), null, "errorCode asc")) {
					pick = new PickDto(error.getErrorCode(), error.getErrorCode() + "--" + error.getErrorMsg());
					picks.add(pick);
				}
				return;
		}
	}

}
