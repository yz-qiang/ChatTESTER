<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<title>Fedora CloudSync: Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="shortcut icon" href="images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/Aristo/Aristo.css"/>
<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/cloudsync-client.js"></script>
<script type="text/javascript"><!--

var serviceUri = document.location.href + "/../api/rest/service";
var service = new CloudSyncClient(serviceUri);

$(function() {
  $("#button-login").button();
  $("#dialog-error").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });
  document.f.j_username.focus();

  $("#versionInfo").html("<a style=\"color: #666\" href=\"https://wiki.duraspace.org/display/CLOUDSYNC\">CloudSync v" + service.info.version + "</a>");
  if (service.info.initialized == false) {

    $("#dialog-initialize").dialog({
        autoOpen: false,
        modal: true,
        width: 'auto',
        show: 'fade',
        hide: 'fade'
    });

    $("#dialog-initialize").dialog("option", "buttons", {
      "Create Account": function() {
        var username = $("#Initialize-username").val();
        var pass1 = $("#Initialize-password1").val();
        var pass2 = $("#Initialize-password2").val();
        if (username != "" && pass1 != "" && pass1 == pass2) {
          var initData = { serviceInit: {
            "initialAdminUsername" : username,
            "initialAdminPassword" : pass1
          }};
          service.initialize(initData,
            function() {
              $("#dialog-initialize").dialog("close");
              document.f.j_username.focus();
            },
            function(httpRequest, method, url, textStatus) {
              alert("Account Creation Failed: " + textStatus);
            }
          );
        } else if (username == "") {
            showError("Username cannot be blank!");
        } else if (pass1 == "") {
            showError("Password cannot be blank!");
        } else {
            showError("Passwords do not match!");
        }
      }
    });
    $("#dialog-initialize").dialog("open");
  }
});

function showError(message) {
  $("#dialog-error").html("<span class=\"ui-icon ui-icon-error\" style=\"float:left; margin:0 7px 20px 0;\"/>" + message);
  $("#dialog-error").dialog("option", "buttons", {
    "Ok": function() {
      $(this).dialog("close");
    }
  }).addClass("ui-state-error");
  $("#dialog-error").dialog("open");
}

//--></script>
</head>

<body bgcolor="#333333">

<form name='f' action='j_spring_security_check' method='POST'>
<center>
<table border="0" cellpadding="0" cellspacing="15"><tr><td bgcolor="#ffffff" style="padding: 15px;">
<div id="login">
  <table bgcolor="#ffffff" cellpadding="10">
    <tr><td align="middle">
    <img src="images/logo.png"/>
    </td></tr>
    <tr><td align="middle">
      <table cellpadding="5" style="font-size: 16px;">
        <tr><td>Username</td><td><input type='text' name='j_username' value=''></td></tr>
        <tr><td>Password</td><td><input type='password' name='j_password'/></td></tr>
      </table>
    </td></tr>
    <tr><td align="middle">
      <button id="button-login" onclick="document.f.submit();">Login &gt;</button>
    </td></tr>
  </table>
</div>
</center>
</form>

<div class="ui-helper-hidden" id="dialog-initialize" title="Welcome!">
  <table>
    <tr>
      <td colspan="2">
        Before anyone can login, you'll need to create<br/>
        an administrative account.
        <p/>
      </td>
    </tr>
    <tr>
      <td>Username</td>
      <td><input id="Initialize-username" type="text" value=""/></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input id="Initialize-password1" type="password"/></td>
    </tr>
    <tr>
      <td>Password (again)</td>
      <td><input id="Initialize-password2" type="password"/></td>
    </tr>
  </table>
</div>

</td></tr></table>
  <p id="versionInfo">
    ..
  </p>

<div class="ui-helper-hidden" id="dialog-error" title="Error">
  ...
</div>

</body>
</html>
