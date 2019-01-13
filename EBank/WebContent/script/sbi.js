function MM_goToURL() {
  var i, args=MM_goToURL.arguments; document.MM_returnValue = false;
  for (i=0; i<(args.length-1); i+=2) eval(args[i]+".location='"+args[i+1]+"'");
}

function MM_openBrWindow(theURL,winName,features) { //v2.0
  window.open(theURL,winName,features);
}
function showme2(e)
{
el=document.getElementById(e);
el.style.display="block";
}
function hideme2(e)
{
el=document.getElementById(e);
el.style.display="none";
}

function login(){
	var user=document.getElementById('user').value;
	var pwd=document.getElementById('pwd').value;
	if(user==''||pwd=='')
	{
		alert('Please enter correct User Name and Password!')
	}
	else{
		if(user=="dataentry")
		{	
			MM_openBrWindow('data_entry_operator/search_agent.html','_parent','');
		}
		else if(user=="supervisor")
		{	
			MM_openBrWindow('supervisor/search_agent.html','_parent','');
		}
		else if(user=="admin")
		{	
			MM_openBrWindow('administrator/search_geo_hierarchy.html','_parent','');
		}
		else
		{
			alert('Please enter correct User Name and Password!')
		}
	}
}
function logoff(url) {
	MM_openBrWindow(url,'_parent','');
}
function showme(e){
	document.getElementById(e).style.display='block';
}
function hideme(e){
	document.getElementById(e).style.display='none';
}

function editCol(obj)
{
document.getElementById(obj).style.display = 'none';
obj=obj+"_1";
document.getElementById(obj).style.display = 'block';
}