package Activities;

public interface objectRepository {
	public static String img="//*[@id='divLogo']//following::img[1]";
	public static String srcAttr="src";
	public static String loginUser="txtUsername";
	public static String loginPassword="txtPassword";
	public static String submitBtn="Submit";
	public static String dashbord="//*[@class='head']";
	public static String pim="//*[@id='menu_pim_viewPimModule']";
	public static String addEmployee="//*[@id='menu_pim_addEmployee']";
	public static String firstName="firstName";
	public static String lastName="lastName";
	public static String saveBtn="btnSave";
	public static String employeeList="menu_pim_viewEmployeeList";
	public static String empName="empsearch_employee_name_empName";
	public static String searchBtn="searchBtn";
	public static String tblRw="//*[@id='resultTable']/tbody/tr";
	public static String myInfo="menu_pim_viewMyDetails";
	public static String editFirstName="personal[txtEmpFirstName]";
	public static String editLastName="personal[txtEmpLastName]";
	public static String editGender="personal_optGender_1";
	public static String nationality="personal_cmbNation";
	public static String calCol="//*[@class='ui-datepicker-calendar']/tbody/tr[1]/td";
	public static String calRow="//*[@class='ui-datepicker-calendar']/tbody/tr";
	public static String calMonth="//*[@class='ui-datepicker-month']";
	public static String calYear="//*[@class='ui-datepicker-year']";
	public static String dob="personal[DOB]";
	public static String menu="//*[@class='menu']/ul";
	public static String infoList="sidenav";
	public static String addWork="addWorkExperience";
	public static String company="experience_employer";
	public static String jobTitle="experience_jobtitle";
	public static String fromDate="experience_from_date";
	public static String toDate="experience_to_date";
	public static String saveExpBtn="btnWorkExpSave";
	public static String applyLeave="//*[contains(text(),'Apply Leave')]";
	public static String leaveType="applyleave_txtLeaveType";
	public static String leaveFrom="applyleave_txtFromDate";
	public static String leaveTo="applyleave_txtToDate";
	public static String applyBtn="applyBtn";
	public static String search="btnSearch";
	public static String cFrom="calFromDate";
	public static String cTo="calToDate";
	public static String myleaves="menu_leave_viewMyLeaveList";
	public static String emerRw="//table[@id='emgcontact_list']/tbody/tr";
	public static String emerCl="//table[@id='emgcontact_list']/tbody/tr[1]/td";
			
	
			

}
