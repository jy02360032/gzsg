/*! author panjun | 2017 03 28 */
function tabChange(obj,id) 
{ 
 var arrayli = obj.parentNode.getElementsByTagName("li"); //��ȡli���� 
 var arrayul = document.getElementById(id).getElementsByTagName("ul"); //��ȡul���� 
 for(i=0;i<arrayul.length;i++) 
 { 
  if(obj==arrayli[i]) 
  { 
   arrayli[i].className = "tab_hover"; 
   arrayul[i].className = ""; 
  } 
  else 
  { 
   arrayli[i].className = ""; 
   arrayul[i].className = "hidden"; 
  } 
 } 
} 
