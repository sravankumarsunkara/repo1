<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="java.util.List"%>
<%@page import="com.slokam.ebank.pojo.TransactionPojo"%>
<%@page import="java.util.Collection"%>
<%@page import="com.slokam.ebank.pojo.UserPojo"%>
<html>
<head>
<title>SBI</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="css/sbi_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript" src="script/sbi.js"></script>
</head>

<body>
<form action="PersonDetailsServlet">
<table border="0" cellspacing="0" cellpadding="0" height="100%">
	<tr> <td class="logo">
		<table  border="0" cellpadding="0" cellspacing="0" class="table_width" align="right">
        <tr> 
        
          <td rowspan="2" class="info_welcome">Welcome:</td>
          <td height="12px"></td>
          <td ></td>
          <td></td>
          <td></td>
          <td></td>
          <td rowspan="2" class="info_logout" onMouseOver="this.className='info_logoutOver'" onMouseOut="this.className='info_logout'"onClick="logoff('login.jsp');">Logout</td>
        </tr>
        <tr> 
          <td class="info_data"></td>
          <td class="info">Role:</td>
          <td class="info_data">USER</td>
          <td class="info">Location:</td>
          <td class="info_data">Hyderabad</td>
        </tr>
      </table>
	
	</td></tr>
	<tr>
    <td class="top_nav_bg">
		<table cellpadding="0" cellspacing="0" border="0" class="table_width">
			<tr>
				<td class="top_tab_sel" onClick="MM_openBrWindow('search_geo_hierarchy.html','_parent','status=yes,scrollbars=yes,resizable=yes')">Home</td>
				<td class="top_tab_div"></td>
				<td class="top_tab" onMouseOver="this.className='top_tab_over'" onMouseOut="this.className='top_tab'" onClick="MM_openBrWindow('setup_geo_hierarchy.html','_parent','status=yes,scrollbars=yes,resizable=yes')">Setup Geo Hierarchy</td>
				<td class="top_tab_div"></td>
				<td class="top_tab" onMouseOver="this.className='top_tab_over'" onMouseOut="this.className='top_tab'"  onClick="MM_openBrWindow('setup_human_hierarchy.html','_parent','status=yes,scrollbars=yes,resizable=yes')">Setup Human Hierarchy</td>
				<td class="top_tab_div"></td>
				<td class="top_tab" onMouseOver="this.className='top_tab_over'" onMouseOut="this.className='top_tab'" onClick="MM_openBrWindow('contest.html','_parent','status=yes,scrollbars=yes,resizable=yes')">Contest</td>
          <td class="top_tab_div"></td>
			</tr>
		</table>
	</td>
  </tr>
	<tr>
    <td class="div_bg">&nbsp; </td>
  </tr>
  <tr><td class="con">
  	<table cellpadding="0" cellspacing="0" border="0" id="container" class="con_table">
		<tr>
			<td class="con_left">
				<table cellpadding="0" cellspacing="0" border="0" class="left_nav_table">
              <tr> 
                <td class="left_tab_sel" onClick="MM_openBrWindow('search_geo_hierarchy.html','_parent','status=yes,scrollbars=yes,resizable=yes')"> <span class="left_tab_sel_img">User Management</span> </td>
              </tr>
              <tr> 
                <td class="left_tab" onMouseOver="this.className='left_tab_over'" onMouseOut="this.className='left_tab'" onClick="MM_openBrWindow('view_hierarchy.html','_parent','status=yes,scrollbars=yes,resizable=yes')"> 
                  View Hierarchy </td>
              </tr>
            </table>
			
			</td>
			<td class="con_right">
				<table cellpadding="0" cellspacing="0" border="0">
					<tr>
                <td class="page_title">Person Management</td>
              </tr>
					
					<tr>
                <td class="datacell"> <table border="0" cellspacing="0" cellpadding="0" class="data_table">
                    <tr> 
                      <td width="10%">PersonName</td>
                      <td><input name="personName" type="text" class="text" onFocus="this.className='textover'" onBlur="this.className='text'"></td>
                      <td width="10%">PassportNumber</td>
                      <td><input name="passportNo" type="text" class="text" onFocus="this.className='textover'" onBlur="this.className='text'"></td>
                    </tr>
                    <tr> 
                      <td width="10%">PhoneNumber</td>
                      <td><input name="phoneNum" type="text" class="text" onFocus="this.className='textover'" onBlur="this.className='text'"></td>
                      <td width="10%">CourseName</td>
                      <td><input name="courseName" type="text" class="text" onFocus="this.className='textover'" onBlur="this.className='text'"></td>
                    </tr>
                    <td><input name="text" type="submit" class="text" onFocus="this.className='textover'" onBlur="this.className='text'" value="search"></td>
                    <tr>
                    </tr>
                 </table></td></tr>
                  <tr>
                   <td class="div_bg">&nbsp; </td>
                   
                 </tr>
                 <tr>
                   <td>
                    
                   </td>
                 </tr>
                 
                  
					<tr>
					<td class="section_head">Person Details</td></tr>
					<tr>
                <td class="dashboardcell"> <table cellpadding="0"  cellspacing="0" class="dashboard">
                    <tr>                      
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">Name</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">PassportNum</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">PhoneNo</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">Courses</td>
                    </tr>
                    
                      <%
                        List<Object[]> pesonDetails=(List<Object[]>)request.getAttribute("personDetails");
                      if(pesonDetails!=null && pesonDetails.size()>0)
                    	{
                        for(Object[] objects:pesonDetails)
                        	
                        {%>
                    <tr onMouseOver="this.className='tablecell_over'" onMouseOut="this.className=''"> 
                      <td class="tablecell"><%= objects[0]%></td>
                      <td class="tablecell"><%=objects[1]%></td>
                      <td class="tablecell"><%= objects[2]%></td>
                      <td class="tablecell"><%=objects[3]%></td> 
                    </tr>
                    <%} 
                    }%>
                    
                  </table></td></tr>
					<tr><td class="button_bottom">
					<table cellpadding="0" cellspacing="0" border="0">
						<tr><td>
					
                        &nbsp;
                        
                      </td>
					  <td class="button_right">
					  <table cellpadding="0" cellspacing="2" border="0" class="table_width">
					  			  </table>
				</table>
			
			</td>
		</tr>
	
	</table>
  			</td>
  		</tr>
  	</table>
  <tr><td class="footer">&nbsp;</td></tr>
  
</table>
</form>
</body>
</html>
