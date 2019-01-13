<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@page import="com.slokam.ebank.pojo.UserPojo"%>
<html>
<head>
<title>SBI</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="css/sbi_css.css" rel="stylesheet" type="text/css">
<script type="text/javascript" language="JavaScript" src="script/sbi.js"></script>
</head>

 <body>
<%String str=(String)request.getAttribute("error"); 
  if(str!=null)
  out.print(str); 
  UserPojo userPojo=(UserPojo)request.getAttribute("userData");
 %>
<form action="RegistrationServlet">
<table border="0" cellspacing="0" cellpadding="0" height="70%">
  <tr> 
    <td class="logo">&nbsp; </td>
  </tr>
  <tr> 
    <td align="center"><table cellpadding="0" cellspacing="0" border="0" class="login_table">
        <tr> 
          <td class="login_bar" align="center">RegistrationForm</td>
        </tr>
        
        <tr> 
          <td class="login_con"> <table cellpadding="0" cellspacing="0" border="0" height="100%">
              <tr> 
                <td class="login_bg_left"><img src="../images/dot.gif" width="1px"></td>
                <td class="login_bg_right"><img src="../images/dot.gif" width="1px"></td>
              </tr>
              <tr> 
                <td class="login_left_bg_con">
					<table cellpadding="0" cellspacing="3" border="0" class="login_container">
                    <tr> 
                      <td>UserName</td>
                      <input type="hidden" name="userid" value="<%=userPojo.getId() %>"/>
                      <td><input id="user" type="text" value="<%=userPojo.getUserName() %>" name="userName" class="text" onFocus="this.className='textover'" onBlur="this.className='text'" title="Enter Login ID">
                      </td>
                    </tr>
                    <tr> 
                      <td>Password</td>
                      <td><input type="password" value="<%=userPojo.getPassword() %>" name="password" class="text" onFocus="this.className='textover'" onBlur="this.className='text'" title="Enter Password">
                      </td>
                    </tr>
                    <tr> 
                      <td>Status</td>
                      <td><input type="text" value="<%=userPojo.getStatus() %>" name="status" class="text" onFocus="this.className='textover'" onBlur="this.className='text'" title="Enter Password">
                      </td>
                    </tr>
                    <tr> 
                      <td>Balance</td>
                      <td><input type="text" value="<%=userPojo.getBalance() %>" name="balance" class="text" onFocus="this.className='textover'" onBlur="this.className='text'" title="Enter Password">
                      </td>
                      </tr> 
                      
                    
                    <tr> 
                      <td>&nbsp;</td>
                      <td class="login_button"><input name="button" type="submit" class="butt" onMouseOver="this.className='buttOver'" onMouseOut="this.className='butt'" value="save" title="Cancel" align="center" > 
                    </tr>
                    </table>
				
				</td>
                <td class="login_bg_right_mid">&nbsp;</td>
              </tr>
              <tr>
                <td class="login_left_bg"><img src="../images/dot.gif" width="1px"></td>
                <td class="login_bg_right_dw"><img src="../images/dot.gif" width="1px"></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
</body>
</html>
