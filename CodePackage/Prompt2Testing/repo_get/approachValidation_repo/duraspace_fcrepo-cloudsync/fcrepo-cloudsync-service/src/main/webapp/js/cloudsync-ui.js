// depends on cloudsync-client.js, json2.js, jquery, and md5-min.js

var serviceUri = document.location.href + "api/rest/service";
var service = new CloudSyncClient(serviceUri);

refreshSets(refreshStores(refreshTasks()));

var numActiveTasks = 0;
var secondsSinceTaskRefresh = 0;
var secondsSinceSetRefresh = 0;
var secondsSinceStoreRefresh = 0;
var secondsSinceUserRefresh = 0;

var tasks = [ ];
var taskLogs = [ ];
var objectSets = [ ];
var objectStores = [ ];
var users = [ ];

function esc(value) {
  return value.replace(/&/g, "&amp;")
              .replace(/</g, "&lt;")
              .replace(/>/g, "&gt;")
              .replace(/'/g, "&apos;")
              .replace(/"/g, "&quot;")
              .replace(/\n/g, "<br/>")
              .replace(/&lt;code&gt;/g, "<nobr><code>")
              .replace(/&lt;\/code&gt;/g, "<\/code></nobr>")
              .replace(/&lt;strong&gt;/g, "<strong>")
              .replace(/&lt;\/strong&gt;/g, "<\/strong>");
}

function refreshTasks() {
  service.listTasks(function(data) {
    tasks = data.tasks;
    service.listTaskLogs(function(data2) {
      taskLogs = data2.taskLogs;
      numActiveTasks = doSection(tasks, "tasks-active", getActiveTaskHtml);
      doSection(tasks, "tasks-idle", getIdleTaskHtml);
      doSection(taskLogs, "tasks-completed", getTaskLogHtml);
      secondsSinceTaskRefresh = 0;
    }, true, handleServiceError);
  }, true, handleServiceError);
}

function refreshSets(callback) {
  service.listObjectSets(function(data) {
    objectSets = data.objectSets;
    doSection(objectSets, "sets-pidpatterns", getPidPatternSetHtml);
    doSection(objectSets, "sets-pidlists", getPidListSetHtml);
    doSection(objectSets, "sets-queries", getQuerySetHtml);
    secondsSinceSetRefresh = 0;
    if (typeof callback != 'undefined') callback();
  }, true, handleServiceError);
}

function refreshStores(callback) {
  service.listObjectStores(function(data) {
    objectStores = data.objectStores;
    doSection(objectStores, "stores-duracloud", getDuraCloudStoreHtml);
    doSection(objectStores, "stores-fedora", getFedoraStoreHtml);
    doSection(objectStores, "stores-filesystem", getFilesystemStoreHtml);
    secondsSinceStoreRefresh = 0;
    if (typeof callback != 'undefined') callback();
  }, true, handleServiceError);
}

function refreshUsers() {
  service.listUsers(function(data) {
    users = data.users;
    doSection(users, "users-all", getUserHtml);
  }, true, handleServiceError);
  secondsSinceUserRefresh = 0;
}

function doSetTaskState(uri, state) {
  var data = { task: {
    "state" : state
  }};
  service.updateTask(uri, data, function() {
    refreshTasks();
  }, true, handleServiceError);
}

function doDeleteTask(uri, name) {
  doConfirm("Delete Task <strong>" + esc(name) + "</strong>?", function() {
      service.deleteTask(uri,
        function() {
          refreshTasks();
        },
        true,
        function(httpRequest, method, url) {
          if (httpRequest.status == 409) {
            showError("Can't delete Task; it is currently active or being referenced by a task log.");
          } else {
            handleServiceError(httpRequest, method, url);
          }
        }
      );
  });
}

function doViewTaskLog(taskLogUri) {
  service.getTaskLog(taskLogUri, function(data) {
    window.open(data.taskLog.contentUri, "taskLogContent");
  }, true, handleServiceError);
}

function doConfirm(message, callback, customTitle) {
  $("#dialog-confirm").html("<span class=\"ui-icon ui-icon-alert\" style=\"float:left; margin:0 7px 20px 0;\"/>" + esc(message));
  var title = customTitle;
  if (typeof customTitle === 'undefined') {
    title = "Are you sure?";
  }
  $("#dialog-confirm").dialog({ title: title });
  $("#dialog-confirm").dialog("option", "buttons", {
    "No": function() {
      $(this).dialog("close");
    },
    "Yes": function() {
      $(this).dialog("close");
      if (typeof callback != 'undefined') callback();
    }
  });
  $("#dialog-confirm").dialog("open");
}

function showError(message, customTitle, callback) {
  $("#dialog-error").html("<span class=\"ui-icon ui-icon-error\" style=\"float:left; margin:0 7px 20px 0;\"/>" + esc(message));
  var title = customTitle;
  if (typeof customTitle === 'undefined') {
    title = "Error";
  }
  $("#dialog-error").dialog({ title: title });
  $("#dialog-error").dialog("option", "buttons", {
    "Ok": function() {
      $(this).dialog("close");
      if (typeof callback != 'undefined') callback();
    }
  }).addClass("ui-state-error");
  $("#dialog-error").dialog("open");
}

function doDeleteTaskLog(uri, name) {
  doConfirm("Delete Task Log <strong>" + esc(name) + "</strong>?", function() {
      service.deleteTaskLog(uri, function() {
        refreshTasks();
      }, true, handleServiceError);
  });
}

function getActiveTaskHtml(item) {
  var html = "";
  if (item.state != 'Idle') {
    html += "<div class='item-actions'>";
    if (item.state != 'Starting') {
      html += "  <button onclick='doViewTaskLog(\"" + item.activeLogUri + "\")'>View Log</button>";
      if (item.state != 'Paused' && item.state != 'Pausing' && item.state != 'Canceling') {
        html += "  <button onclick='doSetTaskState(\"" + item.uri + "\", \"Pausing\");'>Pause</button>";
      }
      if (item.state == 'Paused') {
        html += "  <button onclick='doSetTaskState(\"" + item.uri + "\", \"Resuming\");'>Resume</button>";
      }
      if (item.state != 'Canceling') {
        html += "  <button onclick='doSetTaskState(\"" + item.uri + "\", \"Canceling\");'>Cancel</button>";
      }
    }
    html += "</div>";
    html += "<div><table>";
    if (item.activeLogUri) {
      var taskLog = getByUri(taskLogs, item.activeLogUri);
      html += "  <tr><td><strong>Started at:</strong></td><td>" + esc(taskLog.startDate) + "</td></tr>";
    }
    html += getTaskRows(item);
    html += "</table></div>";
  }
  return html;
}

function getIdleTaskHtml(item) {
  var html = "";
  if (item.state == 'Idle') {
    html += "<div class='item-actions'>";
    html += "  <button onClick='doSetTaskState(\"" + item.uri + "\", \"Starting\");'>Run</button>";
    html += "  <button onClick='doDeleteTask(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Delete</button>";
    html += "</div>";
    html += "<div><table>";
    html += getTaskRows(item);
    html += "</table></div>";
  }
  return html;
}

function getTaskRows(item) {
  var html = "";
  var data = JSON.parse(item.data);
  html += "<tr><td><strong>Type:</strong></td><td>";
  if (item.type == 'list') {
    html += "List</td></tr>";
    var setName = getByUri(objectSets, data.setUri).name;
    var storeName = getByUri(objectStores, data.storeUri).name;
    html += "<tr><td><strong>Set:</strong></td><td>" + esc(setName) + "</td></tr>";
    html += "<tr><td><strong>Query Store:</strong></td><td>" + esc(storeName) + "</td></tr>";
  } else if (item.type == 'copy') {
    html += "Copy</td></tr>";
    var setName = getByUri(objectSets, data.setUri).name;
    var queryStoreName = getByUri(objectStores, data.queryStoreUri).name;
    var sourceStoreName = getByUri(objectStores, data.sourceStoreUri).name;
    var destStoreName = getByUri(objectStores, data.destStoreUri).name;
    html += "<tr><td><strong>Set:</strong></td><td>" + esc(setName) + "</td></tr>";
    html += "<tr><td><strong>Query Store:</strong></td><td>" + esc(queryStoreName) + "</td></tr>";
    html += "<tr><td><strong>Source Store:</strong></td><td>" + esc(sourceStoreName) + "</td></tr>";
    html += "<tr><td><strong>Destination Store:</strong></td><td>" + esc(destStoreName) + "</td></tr>";
    html += "<tr><td><strong>Overwrite:</strong></td><td>" + yesOrNo(data.overwrite) + "</td></tr>";
    html += "<tr><td><strong>Include Objects with Managed Content:</strong></td><td>" + yesOrNo(data.includeManaged) + "</td></tr>";
    html += "<tr><td><strong>Copy External Datastream Content (convert to Managed):</strong></td><td>" + yesOrNo(data.copyExternal) + "</td></tr>";
    html += "<tr><td><strong>Copy Redirect Datastream Content (convert to Managed):</strong></td><td>" + yesOrNo(data.copyRedirect) + "</td></tr>";

  }
  return html;
}

function getTaskLogHtml(item) {
  var html = "";
  if (item.resultType != 'Incomplete') {
    html += "<div class='item-actions'>";
    html += "  <button onclick='doViewTaskLog(\"" + item.uri + "\")'>View Log</button>";
    html += "  <button onclick='doDeleteTaskLog(\"" + item.uri + "\", \"" + item.finishDate + "\")'>Delete</button>";
    html += "</div>";
    html += "<div><table>";
    html += "  <tr><td><strong>Started at:</strong></td><td>" + esc(item.startDate) + "</td></tr>";
    html += "  <tr><td><strong>Finished at:</strong></td><td>" + esc(item.finishDate) + "</td></tr>";
    html += "</table></div>";
  }
  return html;
}

function doDeleteObjectSet(uri, name) {
  doConfirm("Delete Set <strong>" + esc(name) + "</strong>?", function() {
      service.deleteObjectSet(uri,
        function() {
          refreshSets();
        },
        true,
        function(httpRequest, method, url) {
          if (httpRequest.status == 409) {
            showError("Can't delete Set; it is being used by one or more Tasks.");
          } else {
            handleServiceError(httpRequest, method, url);
          }
        }
      );
  });
}

function doEditObjectSet(uri, name) {
  service.getObjectSet(uri,
    function(response) {
      var set = response.objectSet;
      if (set.type == "pidPattern") {
        $("#EditPidPattern-uri").val(uri);
        $("#EditPidPattern-name").val(set.name);
        $("#EditPidPattern-data").val(set.data);
        $("#dialog-EditPidPattern").dialog("open");
      } else if (set.type == "pidList") {
        $("#EditPidList-uri").val(uri);
        $("#EditPidList-name").val(set.name);
        $("#EditPidList-data").val(set.data);
        $("#dialog-EditPidList").dialog("open");
      } else if (set.type == "query") {
        $("#EditQuery-uri").val(uri);
        $("#EditQuery-name").val(set.name);
        var data = $.parseJSON(set.data);
        $("#EditQuery-queryType").change(data.queryType);
        $("#EditQuery-queryText").val(data.queryText);
        $("#dialog-EditQuery").dialog("open");
      } else {
        showError("Unrecognized Set type: " + set.type);
      }
    },
    true,
    function(httpRequest, method, url) {
        handleServiceError(httpRequest, method, url);
    });
}

function getPidPatternSetHtml(item) {
  var html = "";
  if (item.type == "pidPattern") {
    html += "<div class='item-actions'>";
    html += "  <button onClick='doEditObjectSet(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Edit</button>";
    html += "  <button onClick='doDeleteObjectSet(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Delete</button>";
    html += "</div>";
    html += "<div><table>";
    html += "  <tr><td><strong>Pattern:</strong></td><td>" + esc(item.data) + "</td></tr>";
    html += "</table></div>";
  }
  return html;
}

function getPidListSetHtml(item) {
  var html = "";
  if (item.type == "pidList") {
    html += "<div class='item-actions'>";
    html += "  <button onClick='doEditObjectSet(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Edit</button>";
    html += "  <button onClick='doDeleteObjectSet(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Delete</button>";
    html += "</div>";
    html += "<div><table>";
    html += "  <tr><td><strong>PIDs:</strong></td><td>" + esc(item.data) + "</td></tr>";
    html += "</table></div>";
  }
  return html;
}

function getQuerySetHtml(item) {
  var html = "";
  if (item.type == "query") {
    var data = $.parseJSON(item.data);
    html += "<div class='item-actions'>";
    html += "  <button onClick='doEditObjectSet(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Edit</button>";
    html += "  <button onClick='doDeleteObjectSet(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Delete</button>";
    html += "</div>";
    html += "<div><table>";
    html += "  <tr><td><strong>Query Language:</strong></td><td>" + esc(data.queryType) + "</td></tr>";
    html += "  <tr><td><strong>Query Text:</strong></td><td><pre>" + esc(data.queryText) + "</pre></td></tr>";
    html += "</table></div>";
  }
  return html;
}

function doForgetObjectStore(uri, name) {
  doConfirm("Forget Store <strong>" + esc(name) + "</strong>?", function() {
      service.deleteObjectStore(uri,
        function() {
          refreshStores();
        },
        true,
        function(httpRequest, method, url) {
          if (httpRequest.status == 409) {
            showError("Can't forget Store; it is being used by one or more Tasks.");
          } else {
            handleServiceError(httpRequest, method, url);
          }
        }
      );
  });
}

function doChangePassword(uri, name) {
  $("#account-uri").html(uri);
  $("#account-username").html(name);
  $("#account-password1").val("");
  $("#account-password2").val("");
  $("#dialog-account").dialog("open");
}

function doDemoteUser(uri) {
  doUpdateUser(uri, { user: { "admin" : "false" } });
}

function doPromoteUser(uri) {
  doUpdateUser(uri, { user: { "admin" : "true" } });
}

function doDisableUser(uri) {
  doUpdateUser(uri, { user: { "enabled" : "false" } });
}

function doEnableUser(uri) {
  doUpdateUser(uri, { user: { "enabled" : "true" } });
}

function doUpdateUser(uri, data) {
  service.updateUser(uri, data, function() {
      refreshUsers();
  }, true, handleServiceError);
}

function doDeleteUser(uri, name) {
  doConfirm("Delete User <strong>" + esc(name) + "</strong>?", function() {
      service.deleteUser(uri,
        function() {
          refreshUsers();
        }, true, handleServiceError);
  });
}

function getDuraCloudStoreHtml(item) {
  var html = "";
  if (item.type == "duracloud") {
    var data = $.parseJSON(item.data);
    html += "<div class='item-actions'>";
    html += "  <button onClick='doForgetObjectStore(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Forget</button>";
    html += "</div>";
    html += "<div><table>";
    html += "  <tr><td><strong>DuraStore URL:</strong></td><td>" + esc(data.url) + "</td></tr>";
    html += "  <tr><td><strong>Username:</strong></td><td>" + esc(data.username) + "</td></tr>";
    html += "  <tr><td><strong>Storage Provider:</strong></td><td>" + esc(data.providerName) + "</td></tr>";
    html += "  <tr><td><strong>Space:</strong></td><td>" + esc(data.space) + "</td></tr>";
    var prefix = data.prefix;
    if (prefix == "") {
      prefix = "(None)";
    }
    html += "  <tr><td><strong>Content Id Prefix:</strong></td><td>" + esc(prefix) + "</td></tr>";
    html += "</table></div>";
  }
  return html;
}

function getFedoraStoreHtml(item) {
    var html = "";
    if (item.type == "fedora") {
        var data = $.parseJSON(item.data);
        html += "<div class='item-actions'>";
        html += "  <button onClick='doForgetObjectStore(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Forget</button>";
        html += "</div>";
        html += "<div><table>";
        html += "  <tr><td><strong>Base URL:</strong></td><td>" + esc(data.url) + "</td></tr>";
        html += "  <tr><td><strong>Username:</strong></td><td>" + esc(data.username) + "</td></tr>";
        html += "</table></div>";
    }
    return html;
}

function getFilesystemStoreHtml(item) {
  var html = "";
  if (item.type == "filesystem") {
    var data = $.parseJSON(item.data);
    html += "<div class='item-actions'>";
    html += "  <button onClick='doForgetObjectStore(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Forget</button>";
    html += "</div>";
    html += "<div><table>";
    html += "  <tr><td><strong>Path:</strong></td><td>" + esc(data.path) + "</td></tr>";
    html += "</table></div>";
  }
  return html;
}

function getUserHtml(item) {
  var html = "";
  html += "<div class='item-actions'>";
  html += "  <button onClick='doChangePassword(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Change Password</button>";
  if (item.admin && item.uri != $("#userid").text()) {
    html += "  <button onClick='doDemoteUser(\"" + item.uri + "\");'>Demote</button>";
  } else if (!item.admin) {
    html += "  <button onClick='doPromoteUser(\"" + item.uri + "\");'>Promote</button>";
  }
  if (item.enabled && item.uri != $("#userid").text()) {
    html += "  <button onClick='doDisableUser(\"" + item.uri + "\");'>Disable</button>";
  } else if (!item.enabled) {
    html += "  <button onClick='doEnableUser(\"" + item.uri + "\");'>Enable</button>";
  }
  if (item.uri != $("#userid").text()) {
    html += "  <button onClick='doDeleteUser(\"" + item.uri + "\", \"" + esc(item.name) + "\");'>Delete</button>";
  }
  html += "</div>";
  html += "<div><table>";
  var isAdmin = yesOrNo(item.admin);
  var isEnabled = yesOrNo(item.enabled);
  html += "  <tr><td><strong>Administrator:</strong></td><td>" + isAdmin + "</td></tr>";
  html += "  <tr><td><strong>Enabled:</strong></td><td>" + isEnabled + "</td></tr>";
  html += "</table></div>";
  return html;
}

function yesOrNo(value) {
  if (value === 'true' || value === true) {
    return "Yes";
  } else {
    return "No";
  }
}

function getByUri(items, uri) {
  for (var i = 0; i < items.length; i++) {
    if (items[i].uri === uri) {
        return items[i];
    }
  }
  return null;
}

function doSection(items, sectionName, itemHtmlGetter) {
  var html = "";
  var count = 0;
  $.each(items, function(index, item) {
    var body = itemHtmlGetter(item);
    if (body) {
      count++;
      var name;
      if (sectionName == 'tasks-completed') {
        var task = getByUri(tasks, item.taskUri);
        name = item.resultType + " - " + task.name;
      } else {
        name = item.name;
      }
      if (sectionName == 'tasks-active') {
        name = item.state + " - " + item.name;
      }
      html += getExpandable(name, body, hex_md5(sectionName + item.uri));
    }
  });
  if (count > 0) {
    $("#" + sectionName).html(html);
    $("#" + sectionName + " .item-actions button").button();
    $("#" + sectionName + " .expandable-collapsed").accordion({collapsible: true, active: false});
    $("#" + sectionName + " .expandable-expanded").accordion({collapsible: true, active: 0});
  } else {
    $("#" + sectionName).html("None.");
  }
  return count;
}

function isExpanded(cssid) {
  return $("#" + cssid).accordion("option", "active") === 0;
}

function getExpandable(title, bodyHtml, cssid) {
  var html = "";
  var suffix = "collapsed";
  if (isExpanded(cssid)) {
    suffix = "expanded";
  }
  html += "<div id='" + cssid + "' class='expandable-" + suffix + "'>";
  html += "  <h3><a href='#'>" + esc(title) + "</a></h3>";
  html += "  <div class='expandable-body'>" + bodyHtml + "</div>";
  html += "</div>";
  return html;
}

var loadedUsers = false;
var loadedSets = false;
var loadedStores = false;

$(function() {

  // initialize ui elements

// manual refresh disabled
//  $(".button-Refresh").button({
//    icons: { primary: "ui-icon-arrowrefresh-1-e" }//,
//  });
//  $("#tasks .button-Refresh").click(function() { refreshTasks(); });
//  $("#sets .button-Refresh").click(function() { refreshSets(); });
//  $("#stores .button-Refresh").click(function() { refreshStores(); });

  $("#button-Logout").button({
    icons: { primary: "ui-icon-power" }
  });

  $("#button-Logout").click(
    function() {
      document.location = 'j_spring_security_logout';
    }
  );

  $("#button-Account").click(function() {
      doChangePassword($("#userid").text(), $("#button-Account").text());
  });

  $("#tabs").tabs({
    show: function(event, ui) {
      if (ui.index == 1 && !loadedSets) {
        loadedSets = true;
        refreshSets();
      } else if (ui.index == 2 && !loadedStores) {
        loadedStores = true;
        refreshStores();
      } else if (ui.index == 3 && !loadedUsers) {
        loadedUsers = true;
        refreshUsers();
      }
    }
  });

  // Show user-specific UI elements
  service.getCurrentUser(function(data, status, x) {
    $("#button-Account").html(data.user.name);
    $("#button-Account").button({
      icons: { primary: "ui-icon-gear" }
    });
    $("#userid").text(data.user.uri);
    if (data.user.admin) {
      $("#tabs").tabs("add", "#users", "Users");
    }
  }, true, handleServiceError);


  $("#button-NewTask").button({
    icons: { primary: "ui-icon-plus" }
  });

  $("#button-NewTask").click(
    function() {
      $("#dialog-NewTask").dialog("open");
    }
  );

  $("#button-NewSet").button({
    icons: { primary: "ui-icon-plus" }
  });

  $("#button-NewSet").click(
    function() {
      $("#dialog-NewSet").dialog("open");
    }
  );

  $("#button-NewStore").button({
    icons: { primary: "ui-icon-plus" }
  });

  $("#button-NewStore").click(
    function() {
      $("#dialog-NewStore").dialog("open");
    }
  );

  $("#button-NewUser").button({
    icons: { primary: "ui-icon-plus" }
  });

  $("#button-NewUser").click(
    function() {
      $("#NewUser-username").val("");
      $("#NewUser-password1").val("");
      $("#NewUser-password2").val("");
      $("#dialog-NewUser").dialog("open");
    }
  );

  $("#dialog-NewUser").dialog({                                              
      autoOpen: false,                                                          
      modal: true,                                                              
      width: 'auto',                                                            
      show: 'fade',                                                             
      hide: 'fade',
      buttons: {
        "Create Account": function() {
          var username = $("#NewUser-username").val();
          var pass1 = $("#NewUser-password1").val();
          var pass2 = $("#NewUser-password2").val();
          if (username != "" && pass1 != "" && pass1 == pass2) {
            var admin = $("#NewUser-admin").is(":checked");
            var data = { user: {
              "name" : username,
              "password" : pass1,
              "enabled" : true,
              "admin" : admin
            }};
            service.createUser(data,
              function() {
                $("#dialog-NewUser").dialog("close");
                refreshUsers();
              },
              true,
              handleNameCollision
            );
          } else if (username == "") {
              showError("Username cannot be blank!");
          } else if (pass1 == "") {
              showError("Password cannot be blank!");
          } else {
              showError("Passwords do not match!");
          }
        }
      }
    }
  );

  $("#dialog-account").dialog({                                              
      autoOpen: false,                                                          
      modal: true,                                                              
      width: 'auto',                                                            
      show: 'fade',                                                             
      hide: 'fade',
      buttons: {
        "Save Changes": function() {
          var pass1 = $("#account-password1").val();
          var pass2 = $("#account-password2").val();
          var uri = $("#account-uri").text();
          if (pass1 != "" && pass1 == pass2) {
            var data = { user: {                                        
              "password" : pass1
            }};                                                                   
            service.updateUser(uri, data,
              function() {                                                      
                $("#dialog-account").dialog("close");                              
                if (uri == $("#userid").html()) {
                  document.location = 'j_spring_security_logout';
                }
              },
              true,
              handleServiceError);
          } else if (pass1 == "") {                                                 
              showError("Password cannot be blank!");                                   
          } else {                                                                  
              showError("Passwords do not match!");                                     
          }
        }
      }
  });                                                                           


  $("#dialog-confirm").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });

  $("#dialog-error").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });

  $("#dialog-about").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });

  $("#dialog-NewTask").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });

  $("#dialog-NewSet").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });

  $("#dialog-NewPidPattern").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var data = { objectSet: {
          "name": $("#NewPidPattern-name").val(),
          "type": "pidPattern",
          "data": $("#NewPidPattern-data").val()
        }};
        service.createObjectSet(data,
          function() {
            $("#dialog-NewPidPattern").dialog("close");
            refreshSets();
          },
          true,
          handleNameCollision);
      }
    }
  });

  $("#dialog-NewPidList").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var data = { objectSet: {
          "name": $("#NewPidList-name").val(),
          "type": "pidList",
          "data": $("#NewPidList-data").val()
        }};
        service.createObjectSet(data, function() {
          $("#dialog-NewPidList").dialog("close");
          refreshSets();
        },
        true,
        handleNameCollision);
      }
    }
  });

  $("#dialog-NewQuery").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var typeSpecificData = {
          "queryType": $("#NewQuery-queryType").val(),
          "queryText": $("#NewQuery-queryText").val()
        };
        var data = { objectSet: {
          "name": $("#NewQuery-name").val(),
          "type": "query",
          "data": JSON.stringify(typeSpecificData)
        }};
        service.createObjectSet(data, function() {
          $("#dialog-NewQuery").dialog("close");
          refreshSets();
        },
        true,
        handleNameCollision);
      }
    }
  });

  $("#dialog-EditPidPattern").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var uri = $("#EditPidPattern-uri").val();
        var data = { objectSet: {
          "name": $("#EditPidPattern-name").val(),
          "type": "pidPattern",
          "data": $("#EditPidPattern-data").val()
        }};
        service.updateObjectSet(uri, data,
          function() {
            $("#dialog-EditPidPattern").dialog("close");
            refreshSets();
          },
          true,
          handleNameCollision);
      }
    }
  });

  $("#dialog-EditPidList").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var uri = $("#EditPidList-uri").val();
        var data = { objectSet: {
          "name": $("#EditPidList-name").val(),
          "type": "pidList",
          "data": $("#EditPidList-data").val()
        }};
        service.updateObjectSet(uri, data, function() {
          $("#dialog-EditPidList").dialog("close");
          refreshSets();
        },
        true,
        handleNameCollision);
      }
    }
  });

  $("#dialog-EditQuery").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var uri = $("#EditQuery-uri").val();
        var typeSpecificData = {
          "queryType": $("#EditQuery-queryType").val(),
          "queryText": $("#EditQuery-queryText").val()
        };
        var data = { objectSet: {
          "name": $("#EditQuery-name").val(),
          "type": "query",
          "data": JSON.stringify(typeSpecificData)
        }};
        service.updateObjectSet(uri, data, function() {
          $("#dialog-EditQuery").dialog("close");
          refreshSets();
        },
        true,
        handleNameCollision);
      }
    }
  });


  $("#dialog-NewStore").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade'
  });

  $("#NewDuraCloudStore-providerId").change(function() {
    showSpacesForProvider($("#NewDuraCloudStore-providerId").val());
  });

  $("#dialog-NewDuraCloudStore").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Next: function() {
        var h = $("#NewDuraCloudStore-url").val();
        if (h.indexOf("/") == -1) {
          $("#NewDuraCloudStore-url").val("https://" + h + "/durastore");
        }
        service.listProviderAccounts(
          $("#NewDuraCloudStore-url").val(),
          $("#NewDuraCloudStore-username").val(),
          $("#NewDuraCloudStore-password").val(),
          function(data) {
            // success -- close dialog, then construct and show the next one
            $("#dialog-NewDuraCloudStore").dialog("close");
            var html = "";
            $.each(data.providerAccounts, function(index, account) {
              html += "<option value='" + account.id + "'>";
              html += account.type;
              html += "</option>";
            });
            $("#NewDuraCloudStore-providerId").html(html);
            showSpacesForProvider($("#NewDuraCloudStore-providerId").val());
            $("#dialog-NewDuraCloudStoreStep2").dialog("open");
          },
          true,
          function() {
            // failure -- alert and keep dialog open
            showError("Error connecting to DuraCloud instance.\nWrong URL, Username, or Password?");
          }
        );
      }
    }
  });

  $("#dialog-NewDuraCloudStoreStep2").dialog({
    autoOpen: false,
    modal: true,
    show: 'fade',
    hide: 'fade',
    buttons: {
      Next: function() {
        $(this).dialog("close");
        $("#NewDuraCloudStoreStep3-url").html($("#NewDuraCloudStore-url").val());
        $("#NewDuraCloudStoreStep3-username").html($("#NewDuraCloudStore-username").val());
        var providerName = $("#NewDuraCloudStore-providerId option:selected").text();
        $("#NewDuraCloudStoreStep3-providerName").html(providerName);
        $("#NewDuraCloudStoreStep3-space").html($("#NewDuraCloudStore-space").val());
        $("#NewDuraCloudStoreStep3-prefix").html($("#NewDuraCloudStore-prefix").val());
        var prefix = $("#NewDuraCloudStore-prefix").val();
        if (prefix != "") {
          prefix = "/" + prefix;
        }
        $("#NewDuraCloudStoreStep3-name").val(
            "DuraCloud Space "
            + $("#NewDuraCloudStore-space").val() + prefix + " at "
            + $("#NewDuraCloudStore-url").val().split("/")[2]
            + " (" + providerName + ") ");
        $("#dialog-NewDuraCloudStoreStep3").dialog("open");
      }
    }
  });

  $("#dialog-NewDuraCloudStoreStep3").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var typeSpecificData = {
          "url": $("#NewDuraCloudStore-url").val(),
          "username": $("#NewDuraCloudStore-username").val(),
          "password": $("#NewDuraCloudStore-password").val(),
          "providerId": $("#NewDuraCloudStore-providerId").val(),
          "providerName": $("#NewDuraCloudStore-providerId option:selected").text(),
          "space": $("#NewDuraCloudStore-space").val(),
          "prefix": $("#NewDuraCloudStore-prefix").val()
        };
        var data = { objectStore: {
          "name": $("#NewDuraCloudStoreStep3-name").val(),
          "type": "duracloud",
          "data": JSON.stringify(typeSpecificData)
        }};
        service.createObjectStore(data,
            function() {
              $("#dialog-NewDuraCloudStoreStep3").dialog("close");
              refreshStores();
            },
            true,
            handleNameCollision);
      }
    }
  });

  $("#dialog-NewFedoraStore").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Next: function() {
        $(this).dialog("close");
        $("#NewFedoraStoreStep2-url").html($("#NewFedoraStore-url").val());
        $("#NewFedoraStoreStep2-username").html($("#NewFedoraStore-username").val());
        $("#NewFedoraStoreStep2-name").val(
            "Fedora Repository at " +
            $("#NewFedoraStore-url").val().split("/")[2]);
        $("#dialog-NewFedoraStoreStep2").dialog("open");
      }
    }
  });

    $("#dialog-NewFedoraStoreStep2").dialog({
      autoOpen: false,
      modal: true,
      width: 'auto',
      show: 'fade',
      hide: 'fade',
      buttons: {
        Save: function() {
          var typeSpecificData = {
            "url": $("#NewFedoraStore-url").val(),
            "username": $("#NewFedoraStore-username").val(),
            "password": $("#NewFedoraStore-password").val()
          };
          var data = { objectStore: {
            "name": $("#NewFedoraStoreStep2-name").val(),
            "type": "fedora",
            "data": JSON.stringify(typeSpecificData)
          }};
          service.createObjectStore(data,
              function() {
                $("#dialog-NewFedoraStoreStep2").dialog("close");
                refreshStores();
              },
              true,
              handleNameCollision);
        }
      }
    });

  $("#dialog-NewFilesystemStore").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Next: function() {
        $(this).dialog("close");
        $("#NewFilesystemStoreStep2-path").html($("#NewFilesystemStore-path").val());
        $("#NewFilesystemStoreStep2-name").val(
            "Local Directory " + $("#NewFilesystemStore-path").val());
        $("#dialog-NewFilesystemStoreStep2").dialog("open");
      }
    }
  });

  $("#dialog-NewFilesystemStoreStep2").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        var typeSpecificData = {
          "path": $("#NewFilesystemStore-path").val()
        };
        var data = { objectStore: {
          "name": $("#NewFilesystemStoreStep2-name").val(),
          "type": "filesystem",
          "data": JSON.stringify(typeSpecificData)
        }};
        service.createObjectStore(data,
            function() {
              $("#dialog-NewFilesystemStoreStep2").dialog("close");
              refreshStores();
            },
            true,
            handleNameCollision);
      }
    }
  });

  $("#dialog-NewStore button").button();

  $("#button-NewDuraCloudStore").click(
      function() {
        $("#dialog-NewStore").dialog("close");
        $("#dialog-NewDuraCloudStore").dialog("open");
      }
  );

  $("#button-NewFedoraStore").click(
    function() {
      $("#dialog-NewStore").dialog("close");
      $("#dialog-NewFedoraStore").dialog("open");
    }
  );

  $("#button-NewFilesystemStore").click(
    function() {
      $("#dialog-NewStore").dialog("close");
      $("#dialog-NewFilesystemStore").dialog("open");
    }
  );

  $("#dialog-NewSet button").button();

  $("#button-NewPidPattern").click(
      function() {
        $("#dialog-NewSet").dialog("close");
        $("#dialog-NewPidPattern").dialog("open");
      }
  );

  $("#button-NewPidList").click(
      function() {
        $("#dialog-NewSet").dialog("close");
        $("#dialog-NewPidList").dialog("open");
      }
  );

  $("#button-NewQuery").click(
      function() {
        $("#dialog-NewSet").dialog("close");
        $("#dialog-NewQuery").dialog("open");
      }
  );

  $("#dialog-NewTask button").button();

  $("#button-NewListTask").click(
    function() {
      $("#dialog-NewTask").dialog("close");
      if (objectStores.length == 0) {
        showError("You must define at least one Store before creating a List Task.", "No Stores Defined");
      } else if (objectSets.length == 0) {
        showError("You must define at least one Set before creating a List Task.", "No Sets Defined");
      } else {
        // populate selects for new list task
        service.listObjectSets(function(sets) {
          // populate sets in dialog, then get stores
          var setOptions = "";
          $.each(sets.objectSets, function(index, set) {
            setOptions += "<option value=\"" + set.uri + "\">"
            setOptions += set.name;
            setOptions += "</option>";
          });
          $("#NewListTask-setUri").html(setOptions);
          $("#NewListTask-setUri").change(showNewListTaskName);
          service.listObjectStores(function(stores) {
            // populate stores in dialog, then show dialog
            var storeOptions = "";
            $.each(stores.objectStores, function(index, store) {
              storeOptions += "<option value=\"" + store.uri + "\">"
              storeOptions += store.name;
              storeOptions += "</option>";
            });
            $("#NewListTask-storeUri").html(storeOptions);
            $("#NewListTask-storeUri").change(showNewListTaskName);
            $("#NewListTask-name").attr("size", 60);
            showNewListTaskName();
            $("#dialog-NewListTask").dialog("open");
          }, true, handleServiceError);
        }, true, handleServiceError);
      }
    }
  );

  $("#button-NewCopyTask").click(
    function() {
      $("#dialog-NewTask").dialog("close");
      if (objectStores.length < 2) {
        showError("You must define at least two Stores before creating a Copy Task.", "Too Few Stores");
      } else if (objectSets.length == 0) {
        showError("You must define at least one Set before creating a Copy Task.", "No Sets Defined");
      } else {
        // populate selects for new copy task
        service.listObjectSets(function(sets) {
          // populate sets in dialog, then get stores
          var setOptions = "";
          $.each(sets.objectSets, function(index, set) {
            setOptions += "<option value=\"" + set.uri + "\">"
            setOptions += set.name;
            setOptions += "</option>";
          });
          $("#NewCopyTask-setUri").html(setOptions);
          $("#NewCopyTask-setUri").change(showNewCopyTaskName);
          service.listObjectStores(function(stores) {
            // populate stores in dialog, then show dialog
            var storeOptions = "";
            $.each(stores.objectStores, function(index, store) {
              storeOptions += "<option value=\"" + store.uri + "\">"
              storeOptions += store.name;
              storeOptions += "</option>";
            });
            $("#NewCopyTask-name").attr("size", 60);
            $("#NewCopyTask-queryStoreUri").html(storeOptions);
            $("#NewCopyTask-queryStoreUri").change(showNewCopyTaskName);
            $("#NewCopyTask-sourceStoreUri").html(storeOptions);
            $("#NewCopyTask-sourceStoreUri").change(showNewCopyTaskName);
            $("#NewCopyTask-destStoreUri").html(storeOptions);
            $("#NewCopyTask-destStoreUri").change(showNewCopyTaskName);
            showNewCopyTaskName();

            $("#dialog-NewCopyTask").dialog("open");
          }, true, handleServiceError);
        }, true, handleServiceError);
      }
    }
  );

  $("#dialog-NewListTask").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        // attempt to save it
        var typeSpecificData = {
          "setUri"  : $("#NewListTask-setUri").val(),
          "storeUri": $("#NewListTask-storeUri").val()
        };
        var state = "Idle";
        if ($("#NewListTask-runNow").is(":checked")) {
          state = "Starting";
        }
        var data = { task: {
          "name" : $("#NewListTask-name").val(),
          "type" : "list",
          "state": state,
          "data" : JSON.stringify(typeSpecificData)
        }};
        service.createTask(data,
          function() {
            $("#dialog-NewListTask").dialog("close");
            refreshTasks();
          },
          true,
          handleNameCollision);
      }
    }
  });

  $("#dialog-NewCopyTask").dialog({
    autoOpen: false,
    modal: true,
    width: 'auto',
    show: 'fade',
    hide: 'fade',
    buttons: {
      Save: function() {
        // attempt to save it
        var overwrite = "false";
        if ($("#NewCopyTask-overwrite").is(":checked")) {
          overwrite = "true";
        }
        var includeManaged = "false";
        if ($("#NewCopyTask-includeManaged").is(":checked")) {
          includeManaged = "true";
        }
        var copyExternal = "false";
        if ($("#NewCopyTask-copyExternal").is(":checked")) {
          copyExternal = "true";
        }
        var copyRedirect = "false";
        if ($("#NewCopyTask-copyRedirect").is(":checked")) {
          copyRedirect = "true";
        }
        var typeSpecificData = {
          "setUri"         : $("#NewCopyTask-setUri").val(),
          "queryStoreUri"  : $("#NewCopyTask-queryStoreUri").val(),
          "sourceStoreUri" : $("#NewCopyTask-sourceStoreUri").val(),
          "destStoreUri"   : $("#NewCopyTask-destStoreUri").val(),
          "overwrite"      : overwrite,
          "includeManaged" : includeManaged,
          "copyExternal"   : copyExternal,
          "copyRedirect"   : copyRedirect
        };
        var state = "Idle";
        if ($("#NewCopyTask-runNow").is(":checked")) {
          state = "Starting";
        }
        var data = { task: {
          "name" : $("#NewCopyTask-name").val(),
          "type" : "copy",
          "state": state,
          "data" : JSON.stringify(typeSpecificData)
        }};
        service.createTask(data,
          function() {
            $("#dialog-NewCopyTask").dialog("close");
            refreshTasks();
          },
          true,
          handleNameCollision);
      }
    }
  });

  // refresh content of selected tab every 60 seconds,
  // or every 5 seconds for tasks if any are active
  setInterval(function() {
    var selectedTab = $("#tabs").tabs("option", "selected");
    secondsSinceTaskRefresh += 5;
    if (selectedTab === 0 && (numActiveTasks > 0 || secondsSinceTaskRefresh >= 60)) {
      refreshTasks();
    }
    secondsSinceSetRefresh += 5;
    if (selectedTab === 1 && secondsSinceSetRefresh >= 60) {
      refreshSets();
    }
    secondsSinceStoreRefresh += 5;
    if (selectedTab === 2 && secondsSinceStoreRefresh >= 60) {
      refreshStores();
    }
    secondsSinceUserRefresh += 5;
    if (selectedTab === 3 && secondsSinceUserRefresh >= 60) {
      refreshUsers();
    }
  }, 5000);

});

function handleNameCollision(httpRequest, method, url) {
  if (httpRequest.status == 409) {
    showError("Please use a different name; that one is already used.");
  } else {
    handleServiceError(httpRequest, method, url);
  }
}

function showNewListTaskName() {
  var name = "List " + $("#NewListTask-setUri option:selected").text()
      + " in " + $("#NewListTask-storeUri option:selected").text();
  $("#NewListTask-name").val(name);
}

function showNewCopyTaskName() {
  var name = "Copy " + $("#NewCopyTask-setUri option:selected").text()
      + " from " + $("#NewCopyTask-sourceStoreUri option:selected").text()
      + " to " + $("#NewCopyTask-destStoreUri option:selected").text();
  $("#NewCopyTask-name").val(name);
}

function showAbout() {
  $("#dialog-about").dialog("option", "buttons", {
    "Ok": function() {
      $(this).dialog("close");
    }
  });
  $("#version").text(service.info.version);
  $("#builddate").text(service.info.buildDate);
  $("#dialog-about").dialog("open");
}

function showSpacesForProvider(id) {
  service.listSpaces(
    $("#NewDuraCloudStore-url").val(),
    $("#NewDuraCloudStore-username").val(),
    $("#NewDuraCloudStore-password").val(),
    id,
    function(data) {
      var html = "";
      $.each(data.spaces, function(index, space) {
        html += "<option value='" + space.id + "'>";
        html += space.id;
        html += "</option>";
      });
      $("#NewDuraCloudStore-space").html(html);
    }, true, handleServiceError);
}

function handleServiceError(httpRequest, method, url) {
  if (httpRequest.status == 0 || httpRequest.status == 503) {                                                  
    showError("The CloudSync Service appears to be down.\n\nPress Ok to try reloading.", "Service Unavailable", doReload);
  } else if (httpRequest.status == 200) {                                                         
    showError("Your session has expired.\n\nPress Ok to log in again.", "Session Expired", doReload);
  } else {
    showError("Unexpected HTTP response code ("
      + httpRequest.status + ") from request:\n\n<code>" + method + " " + url + "</code>", "Service Error");
  }
}

function doReload() {
  window.location.reload();
}
