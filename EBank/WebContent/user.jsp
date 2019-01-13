<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
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
<%UserPojo userInfo=(UserPojo)session.getAttribute("users"); %>
<%UserPojo userPojo=(UserPojo)request.getAttribute("userDetails");%>

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
          <td class="info_data"><%=userInfo.getUserName() %></td>
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
                <td class="page_title">User Management</td>
              </tr>
					<tr><td class="button_top"><input type="button" class="butt" value="Clear Search" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'">&nbsp;<input type="button" class="butt" value="Save Search" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'">
                  <input name="button3" type="button" class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'" value="Search"></td></tr>
					<tr>
                <td class="datacell"> <table border="0" cellspacing="0" cellpadding="0" class="data_table">
                    <tr> 
                      <td width="10%">Name</td>
                      <td><input name="text" type="text" class="text" onFocus="this.className='textover'" onBlur="this.className='text'"value=
                      "<%=userPojo.getUserName()%> "></td>
                      
                    </tr>
                    <tr> 
                      <td>Balance</td>
                      <td><input name="text" type="text" class="text" onFocus="this.className='textover'" onBlur="this.className='text'"value="<%=userPojo.getBalance() %>"></td>
                                          </tr>
                  </table></td></tr>
                  <tr>
                   <td class="div_bg">&nbsp; </td>
                   
                 </tr>
                 <tr>
                 <td>
                   <form action="UserDetailsServlet">
                   <input type="hidden" name="id" value="<%=userPojo.getId() %>">
                   
                    <input type="submit" align="left" value="updateInfo">
                    
                    <a href="DeleteUserServlet?id=<%=userPojo.getId() %>">
                    
                    <input type="button" align="left" value="delete"></a>
                    </form>
                   </td>
                 </tr>
                  
                  
					<tr><td class="section_head">Search Result</td></tr>
					<tr>
                <td class="dashboardcell"> <table cellpadding="0"  cellspacing="0" class="dashboard">
                    <tr>                      
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">Id</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">BankName</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">BankAccNo</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">Amount</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">tDate</td>
                      <td nowrap class="table_bar" onMouseOver="this.className='table_bar_over'" onMouseOut="this.className='table_bar'">type</td>
                    </tr>
                    
                      <%
                      Collection<TransactionPojo> txcol=userPojo.getTxCol(); 
                      int i=1;
                      
                      for(TransactionPojo tpojo:txcol)                    	  
                      { 
                    	  if(tpojo.getBankName()==null)
                    		  break;
                    	  %>
                    <tr onMouseOver="this.className='tablecell_over'" onMouseOut="this.className=''"> 
                      <td class="tablecell"><%=i %></td>
                      <td class="tablecell"><%=tpojo.getBankName() %></td>
                      <td class="tablecell"><%=tpojo.getBankAccNo() %></td>
                      <td class="tablecell"><%=tpojo.getAmount() %></td>
                      <td class="tablecell"><%=tpojo.getDate() %></td>
                      <td class="tablecell"><%=tpojo.getType() %></td>
                    </tr>
                    <%i++;} %>
                    
                  </table></td></tr>
					<tr><td class="button_bottom">
					<table cellpadding="0" cellspacing="0" border="0">
						<tr><td>
					<input name="button" type="button" class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'" value="View">
                    <input name="button2" type="button" class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'" value="Update" onClick="MM_openBrWindow('update/basic_details.html','_blank','status=yes,scrollbars=yes,resizable=yes,channelmode=yes,menubar=no,location=no')">
                        &nbsp;
                        <select name="select2" id="action">
                          <option>Select Action</option>
                          <option>Re-allocate</option>
                          <option>De-activate</option>
                        </select>
                        <input name="button22" type="button" class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'" value="Ok" onClick="if(document.getElementById('action').selectedIndex==1){MM_openBrWindow('action/realocate.html','_blank','status=yes,scrollbars=yes,resizable=yes,channelmode=yes,menubar=no,location=no')}
						else if(document.getElementById('action').selectedIndex==2){MM_openBrWindow('action/deactive.html','_blank','status=yes,scrollbars=yes,resizable=yes,channelmode=yes,menubar=no,location=no')}">
                      </td>
					  <td class="button_right">
					  <table cellpadding="0" cellspacing="2" border="0" class="table_width">
					  <tr><td>
					  <button class="butt2" onMouseOver="this.className='buttOver2'" onMouseOut="this.className='butt2'"><img src="../images/btn_first.gif" width="25px" height="14px"></button>
					  </td><td>
					  <button class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'"><img src="../images/btn_pri.gif" width="12px" height="12px"></button>
					  </td>
					        <td>(2 of 2)</td>
					  <td>
					  <button class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'"><img src="../images/btn_next.gif" width="12px" height="12px"></button> 
						</td>
						<td>
					  <button class="butt2" onMouseOver="this.className='buttOver2'" onMouseOut="this.className='butt2'"><img src="../images/btn_last.gif" width="25px" height="14px"></button>
					  
					  </td>
					  </tr>
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

</body>
</html>
