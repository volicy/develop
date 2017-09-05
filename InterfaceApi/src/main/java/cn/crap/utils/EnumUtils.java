package cn.crap.utils;

/**
 * 债券枚举类
 * @author admin
 *
 */
public class EnumUtils {
	
	/** 
	 * 根据索引获取 
	 * @param <T> 
	 * @param clazz 
	 * @param ordinal 
	 * @return 
	 */  
	public static <T extends Enum<T>> T valueOf(Class<T> clazz, int ordinal) {  
	    return (T)clazz.getEnumConstants()[ordinal];  
	}  
	  
	/** 
	 * 根据name获取 
	 * @param <T> 
	 * @param enumType 
	 * @param name 
	 * @return 
	 */  
	public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {  
	    return (T)Enum.valueOf(enumType, name);  
	}  
	
	/**
	 * 合同状态
	 * 	(1,"待签署"),(2,"已签署"),(3,"审核成功"),(4,"审核失败"),(5,"客户取消"),(6,"正常结清"),(7,"逾期结清"),
	 * 	(8,"提前结清（提前结清业务）"),(9,"展期结清");
	 */
	public enum ContractStatus{
		
		STATUS1(1,"待签署"),
		STATUS2(2,"已签署"),
		STATUS3(3,"审核成功"),
		STATUS4(4,"审核失败"),
		STATUS5(5,"客户取消"),
		STATUS6(6,"正常结清"),
		STATUS7(7,"逾期结清"),
		STATUS8(8,"提前结清"),
		STATUS9(9,"展期结清");
		
		private int status;
		private String statusName;
		
		
		private ContractStatus(int status, String statusName) {
			this.status = status;
			this.statusName = statusName;
		}
		
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		public String getStatusName() {
			return statusName;
		}
		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}
		
		
	}

	/**
	 * 还款状态
	 * 	(1,"初始状态"),(2,"正常未还"),(3,"提前结清（还款日前结清）"),(4,"提前结清（提前结清业务）"),
	 * 	(5,"正常结清（还款日当天结清）"),(6,"提前部分还款"),(7,"正常部分还款"),OVERDUE_NO(8,"逾期未还"),
	 * 	(9,"逾期部分还款"),(10,"逾期结清"),(11,"正常展期结清"),(12,"逾期展期结清");
	 */
	public enum RepayStatus {

		STATUS1(1,"提交申请"),
		
		STATUS2(2,"平台放款"),
		STATUS8(8,"平台放款"),
		
		STATUS6(6,"展期成功"),
		STATUS7(7,"展期成功"),
		STATUS9(9,"展期成功"),
		
		STATUS3(3,"还款成功"),
		STATUS4(4,"还款成功"),
		STATUS5(5,"还款成功"),
		STATUS10(10,"还款成功"),
		STATUS11(11,"还款成功"),
		STATUS12(12,"还款成功");
		
		private int status;
		private String statusName;
		
		private RepayStatus(int status, String statusName) {
			this.status = status;
			this.statusName = statusName;
		}

		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public String getStatusName() {
			return statusName;
		}

		public void setStatusName(String statusName) {
			this.statusName = statusName;
		}
		
	}

	/**
	 * (1,"现金贷"),(2,"信用卡"),(4,"现金贷分期"),(5,"信用卡分期")
	 * @author admin
	 *
	 */
	public enum DebtType{
		TYPE1(1,"现金贷"),
		TYPE2(2,"信用卡"),
		TYPE4(4,"现金贷分期"),
		TYPE5(5,"信用卡分期");
		
		private int debtType;
		private String debtTypeName;
		
		private DebtType(int debtType,String debtTypeName) {
			this.debtType=debtType;
			this.debtTypeName=debtTypeName;
		}
		
		

		public int getDebtType() {
			return debtType;
		}
		public void setDebtType(int debtType) {
			this.debtType = debtType;
		}
		public String getDebtTypeName() {
			return debtTypeName;
		}
		public void setDebtTypeName(String debtTypeName) {
			this.debtTypeName = debtTypeName;
		}
		
	}
	
	
	
	
}
