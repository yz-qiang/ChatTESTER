<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">

<head>
<title>Fedora CloudSync</title>
<meta charset="UTF-8"/>
<meta name="application-name" content="Fedora CloudSync"/>
<link rel="shortcut icon" href="images/favicon.ico"/>
<link rel="stylesheet" type="text/css" href="css/style.css"/>
<link rel="stylesheet" type="text/css" href="css/Aristo/Aristo.css"/>
<script type="text/javascript" src="js/jquery-1.6.4.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.16.custom.min.js"></script>
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/md5-min.js"></script>
<script type="text/javascript" src="js/cloudsync-client.js"></script>
<script type="text/javascript" src="js/cloudsync-ui.js"></script>
</head>

<body bgcolor="#333333">
<table border="0" cellpadding="0" cellspacing="15" width="100%">
<tr><td bgcolor="#ffffff" style="padding: 15px;">
<div id="title">
  <img src="images/logo.png" onClick="showAbout();" alt="Fedora CloudSync"/>
</div>

<div id="logout">
  <span id="userid" style="color: #ffffff"></span>
  <button id="button-Account">...</button>
  <button id="button-Logout">Logout</button>
</div>

<!-- Tabs -->

<div id="tabs">

  <ul>
    <li><a href="#tasks">Tasks</a></li>
    <li><a href="#sets">Sets</a></li>
    <li><a href="#stores">Stores</a></li>
  </ul>

  <div id="tasks" class="tab">
    <div class="tab-header">
      <button id="button-NewTask">Add</button>
<!--      <button class="button-Refresh">Refresh</button> -->
    </div>
    <div class="tab-body">
      <div class="tab-section">
        <h2>Active</h2>
        <div id="tasks-active" class="tab-section-body">
          ...
        </div>
      </div>
      <div class="tab-section">
        <h2>Idle</h2>
        <div id="tasks-idle" class="tab-section-body">
          ...
        </div>
      </div>
      <div class="tab-section">
        <h2>Completed</h2>
        <div id="tasks-completed" class="tab-section-body">
          ...
        </div>
      </div>
    </div>
  </div>

  <div id="sets" class="tab">
    <div class="tab-header">
      <button id="button-NewSet">Add</button>
    </div>
    <div class="tab-body">
      <div class="tab-section">
        <h2>PID Patterns</h2>
        <div id="sets-pidpatterns" class="tab-section-body">
          ...
        </div>
      </div>
      <div class="tab-section">
        <h2>PID Lists</h2>
        <div id="sets-pidlists" class="tab-section-body">
          ...
        </div>
      </div>
      <div class="tab-section">
        <h2>Queries</h2>
        <div id="sets-queries" class="tab-section-body">
          ...
        </div>
      </div>
    </div>
  </div>

  <div id="stores" class="tab">
    <div class="tab-header">
      <button id="button-NewStore">Add</button>
    </div>
    <div class="tab-body">
      <div class="tab-section">
        <h2>DuraCloud-based</h2>
        <div id="stores-duracloud" class="tab-section-body">
          ...
        </div>
      </div>
        <div class="tab-section">
            <h2>Fedora-based</h2>
            <div id="stores-fedora" class="tab-section-body">
                ...
            </div>
        </div>
      <div class="tab-section">
        <h2>Directory-based</h2>
        <div id="stores-filesystem" class="tab-section-body">
          ...
        </div>
      </div>
    </div>
  </div>

  <div id="users" class="tab ui-helper-hidden">
    <div class="tab-header">
      <button id="button-NewUser">Add</button>
    </div>
    <div class="tab-body">
      <div class="tab-section">
        <h2>All Users</h2>
        <div id="users-all" class="tab-section-body">
          ...
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Tasks -->

<div class="ui-helper-hidden" id="dialog-NewTask" title="New Task">
  <p>
    <button id="button-NewListTask">List Objects</button>
  </p>
  <p>
    <button id="button-NewCopyTask">Copy Objects</button>
  </p>
</div>

<div class="ui-helper-hidden" id="dialog-NewListTask" title="New List Task">
  <table>
    <tr>
      <td>List</td>
      <td><select id="NewListTask-setUri">
        ...
      </select></td>
    </tr>
    <tr>
      <td>in</td>
      <td><select id="NewListTask-storeUri">
        ...
      </select></td>
    </tr>
    <tr>
      <td>Task Name</td>
      <td>
        <input id="NewListTask-name" type="text"/>
      </td>
    </tr>
    <tr>
      <td>Run Now</td>
      <td>
        <input type="checkbox" id="NewListTask-runNow" checked="checked"/>
      </td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewCopyTask" title="New Copy Task">
  <table>
    <tr>
      <td>Copy</td>
      <td><select id="NewCopyTask-setUri">
        ...
      </select></td>
    </tr>
    <tr>
      <td>in</td>
      <td><select id="NewCopyTask-queryStoreUri">
        ...
      </select></td>
    </tr>
    <tr>
      <td>from</td>
      <td><select id="NewCopyTask-sourceStoreUri">
        ...
      </select></td>
    <tr>
      <td>to</td>
      <td><select id="NewCopyTask-destStoreUri">
        ...
      </select></td>
    </tr>
    <tr>
      <td>Task Name</td>
      <td>
        <input id="NewCopyTask-name" type="text"/>
      </td>
    </tr>
    <tr>
      <td>Overwrite</td>
      <td>
        <input type="checkbox" id="NewCopyTask-overwrite" checked="checked"/>
      </td>
    </tr>
    <tr>
      <td>Include Objects with Managed Content</td>
      <td>
        <input type="checkbox" id="NewCopyTask-includeManaged" checked="checked"/>
      </td>
    </tr>
    <tr>
      <td>Copy External Datastream Content (convert to Managed)</td>
      <td>
        <input type="checkbox" id="NewCopyTask-copyExternal"/>
      </td>
    </tr>
    <tr>
      <td>Copy Redirect Datastream Content (convert to Managed)</td>
      <td>
        <input type="checkbox" id="NewCopyTask-copyRedirect"/>
      </td>
    </tr>
    <tr>
      <td>Run Now</td>
      <td>
        <input type="checkbox" id="NewCopyTask-runNow" checked="checked"/>
      </td>
    </tr>
  </table>
</div>

<!-- Sets -->

<div class="ui-helper-hidden" id="dialog-NewSet" title="New Set">
  <p>
    <button id="button-NewPidPattern">PID Pattern</button>
  </p>
  <p>
    <button id="button-NewPidList">PID List</button>
  </p>
  <p>
    <button id="button-NewQuery">Query</button>
  </p>
</div>

<div class="ui-helper-hidden" id="dialog-NewPidPattern" title="New PID Pattern">
  <table>
    <tr>
      <td>Name</td>
      <td><input id="NewPidPattern-name" type="text" value=""/></td>
    </tr>
    <tr>
      <td>Pattern (* is wildcard)</td>
      <td><input id="NewPidPattern-data" type="text" value=""/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewPidList" title="New PID List">
  <table>
    <tr>
      <td>Name</td>
      <td><input id="NewPidList-name" type="text" value=""/></td>
    </tr>
    <tr>
      <td>PIDs (one per line)</td>
      <td>
        <textarea id="NewPidList-data" rows="10" cols="20"></textarea>
      </td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewQuery" title="New Query">
  <table>
    <tr>
      <td>Name</td>
      <td><input id="NewQuery-name" type="text" value=""/></td>
    </tr>
    <tr>
      <td>Query Type</td>
      <td><select id="NewQuery-queryType">
        <option>iTQL</option>
        <option selected="selected">SPARQL</option>
      </select></td>
    </tr>
    <tr>
      <td>Query Text</td>
      <td>
        <textarea id="NewQuery-queryText" rows="10" cols="40"></textarea>
      </td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-EditPidPattern" title="Edit PID Pattern">
  <input type="hidden" id="EditPidPattern-uri"/>
  <table>
    <tr>
      <td>Name</td>
      <td><input id="EditPidPattern-name" type="text" value=""/></td>
    </tr>
    <tr>
      <td>Pattern (* is wildcard)</td>
      <td><input id="EditPidPattern-data" type="text" value=""/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-EditPidList" title="Edit PID List">
  <input type="hidden" id="EditPidList-uri"/>
  <table>
    <tr>
      <td>Name</td>
      <td><input id="EditPidList-name" type="text" value=""/></td>
    </tr>
    <tr>
      <td>PIDs (one per line)</td>
      <td>
        <textarea id="EditPidList-data" rows="10" cols="20"></textarea>
      </td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-EditQuery" title="Edit Query">
  <input type="hidden" id="EditQuery-uri"/>
  <table>
    <tr>
      <td>Name</td>
      <td><input id="EditQuery-name" type="text" value=""/></td>
    </tr>
    <tr>
      <td>Query Type</td>
      <td><select id="EditQuery-queryType">
        <option>iTQL</option>
        <option selected="selected">SPARQL</option>
      </select></td>
    </tr>
    <tr>
      <td>Query Text</td>
      <td>
        <textarea id="EditQuery-queryText" rows="10" cols="40"></textarea>
      </td>
    </tr>
  </table>
</div>

<!-- Stores -->

<div class="ui-helper-hidden" id="dialog-NewStore" title="New Store">
  <p>
    <button id="button-NewDuraCloudStore">DuraCloud-based</button>
  </p>
  <p>
    <button id="button-NewFedoraStore">Fedora-based</button>
  </p>
  <p>
    <button id="button-NewFilesystemStore">Directory-based</button>
  </p>
</div>

<div class="ui-helper-hidden" id="dialog-NewDuraCloudStore" title="New DuraCloud-based Store">
  <table>
    <tr>
      <td>Hostname or URL</td>
      <td><input id="NewDuraCloudStore-url" type="text"/></td>
    </tr>
    <tr>
      <td>DuraCloud Username</td>
      <td><input id="NewDuraCloudStore-username" type="text"/></td>
    </tr>
    <tr>
      <td>DuraCloud Password</td>
      <td><input id="NewDuraCloudStore-password" type="password"/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewDuraCloudStoreStep2" title="New DuraCloud-based Store">
  <p style="text-align: center">
    Storage Provider:<br/>
    <select id="NewDuraCloudStore-providerId">
      <option>...</option>
    </select>
  </p>
  <p style="text-align: center">
    Space:<br/>
    <select id="NewDuraCloudStore-space">
      <option>...</option>
    </select>
  </p>
  <p style="text-align: center">
    Content Id Prefix (Optional):<br/>
    <input id="NewDuraCloudStore-prefix" type="text"/>
  </p>
</div>

<div class="ui-helper-hidden" id="dialog-NewDuraCloudStoreStep3" title="New DuraCloud-based Store">
  <table>
    <tr>
      <td>URL</td>
      <td id="NewDuraCloudStoreStep3-url">...</td>
    </tr>
    <tr>
      <td>Username</td>
      <td id="NewDuraCloudStoreStep3-username">...</td>
    </tr>
    <tr>
      <td>Password</td>
      <td>(Not shown)</td>
    </tr>
    <tr>
      <td>Storage Provider</td>
      <td id="NewDuraCloudStoreStep3-providerName">...</td>
    </tr>
    <tr>
      <td>Space</td>
      <td id="NewDuraCloudStoreStep3-space">...</td>
    </tr>
    <tr>
      <td>Content Id Prefix</td>
      <td id="NewDuraCloudStoreStep3-prefix">...</td>
    </tr>
    <tr>
      <td>Store Name</td>
      <td><input id="NewDuraCloudStoreStep3-name" type="text" size="40" value="..."/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewFedoraStore" title="New Fedora-based Store">
  <table>
    <tr>
      <td>Base URL</td>
      <td><input id="NewFedoraStore-url" type="text" value=""/></td>
    </tr>
    <tr>
      <td>Fedora Username</td>
      <td><input id="NewFedoraStore-username" type="text"/></td>
    </tr>
    <tr>
      <td>Fedora Password</td>
      <td><input id="NewFedoraStore-password" type="password"/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewFedoraStoreStep2" title="New Fedora-based Store">
  <table>
    <tr>
      <td>URL</td>
      <td id="NewFedoraStoreStep2-url">...</td>
    </tr>
    <tr>
      <td>Username</td>
      <td id="NewFedoraStoreStep2-username">...</td>
    </tr>
    <tr>
      <td>Password</td>
      <td>(Not shown)</td>
    </tr>
    <tr>
      <td>Store Name</td>
      <td><input id="NewFedoraStoreStep2-name" type="text" size="40" value="..."/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewFilesystemStore" title="New Directory-based Store">
  <table>
    <tr>
      <td>Path</td>
      <td><input id="NewFilesystemStore-path" type="text" value=""/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-NewFilesystemStoreStep2" title="New Directory-based Store">
  <table>
    <tr>
      <td>Path</td>
      <td id="NewFilesystemStoreStep2-path">...</td>
    </tr>
    <tr>
      <td>Store Name</td>
      <td><input id="NewFilesystemStoreStep2-name" type="text" size="40" value="..."/></td>
    </tr>
  </table>
</div>

<!-- Misc -->

<div class="ui-helper-hidden" id="dialog-NewUser" title="New User">
  <table>
    <tr>
      <td>Username</td>
      <td><input id="NewUser-username" type="text" size="20"/></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input id="NewUser-password1" type="password" size="20"/></td>
    </tr>
    <tr>
      <td>Password (again)</td>
      <td><input id="NewUser-password2" type="password" size="20"/></td>
    </tr>
    <tr>
      <td>Administrator</td>
      <td><input id="NewUser-admin" type="checkbox"/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-account" title="Change Password">
  <table>
    <tr>
      <td>Username<span id="account-uri" class="ui-helper-hidden"></span></td>
      <td id="account-username">...</td>
    </tr>
    <tr>
      <td>New Password</td>
      <td><input id="account-password1" type="password" size="20"/></td>
    </tr>
    <tr>
      <td>New Password (again)</td>
      <td><input id="account-password2" type="password" size="20"/></td>
    </tr>
  </table>
</div>

<div class="ui-helper-hidden" id="dialog-confirm" title="Are you sure?">
  ...
</div>

<div class="ui-helper-hidden" id="dialog-error" title="Error">
  ...
</div>

<div class="ui-helper-hidden" id="dialog-about" title="About CloudSync">
  <p>
    <strong>Version:</strong> <span id="version">..</span><br/>
    <strong>Build Date:</strong> <span id="builddate">..</span>
  </p>
  <p>
    <a href="https://wiki.duraspace.org/display/CLOUDSYNC" target="cloudsync-website">More Information</a>
  </p>
</div>

</td></tr></table>
</body>
</html>
