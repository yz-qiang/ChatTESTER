// Javascript Client Library for Fedora CloudSync.
// Requires jQuery 1.5+ and http://www.JSON.org/json2.js
//
// All calls are asynchronous by default but can made invoke synchronously
// via an optional parameter. In either case, the caller must provide a
// "success" callback function that will be invoked (possibly with pre-parsed
// JSON data) upon success.
//
// When an unexpected response (a non-20x, etc) occurs, the default behavior
// is to put up an alert explaining the problem, or in certain cases,
// reload the application. To override this on a per-method basis, the
// caller may provide an "error" callback to be used instead. The signature
// should match that of the private defaultErrorCallback method below.
//
// The constructor creates a CloudSyncClient, against which all future calls
// can be made. The serviceUri is the starting URI of the API and provides
// key information about the service and links to other resources. Upon
// construction, this URI will be dereferenced synchronously and the
// information about the service will be cached within the object
// in the ".info" field.
// 
// Example use:
//
// var serviceUri = document.location.href + "api/rest/service";
// var service = new CloudSyncClient(serviceUri);
// alert("This is CloudSync v" + service.info.version);
// service.getCurrentUser(function(data) {
//   alert("Hello, " + data.user.name); 
// });
//
function CloudSyncClient(serviceUri) {

  this.serviceUri = serviceUri;
  
  // CONSTANTS

  var OBJECTSET_JSON = "application/vnd.fcrepo-cloudsync.objectset+json";
  var OBJECTSETS_JSON = "application/vnd.fcrepo-cloudsync.objectsets+json";
  var OBJECTSTORE_JSON = "application/vnd.fcrepo-cloudsync.objectstore+json";
  var OBJECTSTORES_JSON = "application/vnd.fcrepo-cloudsync.objectstores+json";
  var PROVIDERACCOUNTS_JSON = "application/vnd.fcrepo-cloudsync.provideraccounts+json";
  var SERVICEINFO_JSON = "application/vnd.fcrepo-cloudsync.serviceinfo+json";
  var SERVICEINIT_JSON = "application/vnd.fcrepo-cloudsync.serviceinit+json";
  var SPACES_JSON = "application/vnd.fcrepo-cloudsync.spaces+json";
  var TASK_JSON = "application/vnd.fcrepo-cloudsync.task+json";
  var TASKLOG_JSON = "application/vnd.fcrepo-cloudsync.tasklog+json";
  var TASKLOGS_JSON = "application/vnd.fcrepo-cloudsync.tasklogs+json";
  var TASKS_JSON = "application/vnd.fcrepo-cloudsync.tasks+json";
  var USER_JSON = "application/vnd.fcrepo-cloudsync.user+json";
  var USERS_JSON = "application/vnd.fcrepo-cloudsync.users+json";
 
  //==========================================================================
  //                            PUBLIC METHODS
  //==========================================================================

  //--------------------------------------------------------------------------
  //                               Service
  //--------------------------------------------------------------------------

  this.getServiceInfo = function(success, async, error) {
    doGet(serviceUri, SERVICEINFO_JSON, success, async, error);
  };

  this.initialize = function(data, success, async, error) {
    doPost(serviceUri, SERVICEINIT_JSON, SERVICEINFO_JSON, data, success, async, error);
  };

  //--------------------------------------------------------------------------
  //                                Users
  //--------------------------------------------------------------------------

  this.createUser = function(data, success, async, error) {
    doPost(this.info.usersUri, USER_JSON, USER_JSON, data, success, async, error);
  };

  this.listUsers = function(success, async, error) {
    doGet(this.info.usersUri, USERS_JSON, success, async, error);
  };

  this.getUser = function(uri, success, async, error) {
    doGet(uri, USER_JSON, success, async, error);
  };

  this.getCurrentUser = function(success, async, error) {
    doGet(this.info.currentUserUri, USER_JSON, success, async, error);
  };

  this.updateUser = function(uri, data, success, async, error) {
    doPatch(uri, USER_JSON, data, success, async, error);
  };

  this.deleteUser = function(uri, success, async, error) {
    doDelete(uri, success, async, error);
  };

  //--------------------------------------------------------------------------
  //                                Tasks
  //--------------------------------------------------------------------------

  this.createTask = function(data, success, async, error) {
    doPost(this.info.tasksUri, TASK_JSON, TASK_JSON, data, success, async, error);
  };

  this.listTasks = function(success, async, async, error) {
    doGet(this.info.tasksUri, TASKS_JSON, success, async, error);
  };

  this.getTask = function(uri, success, async, error) {
    doGet(uri, TASK_JSON, success, async, error);
  };

  this.updateTask = function(uri, data, success, async, error) {
    doPatch(uri, TASK_JSON, data, success, async, error);
  };

  this.deleteTask = function(uri, success, async, error) {
    doDelete(uri, success, async, error);
  };

  //--------------------------------------------------------------------------
  //                              Object Sets
  //--------------------------------------------------------------------------

  this.createObjectSet = function(data, success, async, error) {
    doPost(this.info.objectSetsUri, OBJECTSET_JSON, OBJECTSET_JSON, data, success, async, error);
  };

  this.listObjectSets = function(success, async, error) {
    doGet(this.info.objectSetsUri, OBJECTSETS_JSON, success, async, error);
  };

  this.getObjectSet = function(uri, success, async, error) {
    doGet(uri, OBJECTSET_JSON, success, async, error);
  };

  this.updateObjectSet = function(uri, data, success, async, error) {
    doPatch(uri, OBJECTSET_JSON, data, success, async, error);
  };

  this.deleteObjectSet = function(uri, success, async, error) {
    doDelete(uri, success, async, error);
  };

  //--------------------------------------------------------------------------
  //                             Object Stores
  //--------------------------------------------------------------------------

  this.createObjectStore = function(data, success, async, error) {
    doPost(this.info.objectStoresUri, OBJECTSTORE_JSON, OBJECTSTORE_JSON, data, success, async, error);
  };

  this.listObjectStores = function(success, async, error) {
    doGet(this.info.objectStoresUri, OBJECTSTORES_JSON, success, async, error);
  };

  this.getObjectStore = function(uri, success, async, error) {
    doGet(uri, OBJECTSTORE_JSON, success, async, error);
  };

  this.deleteObjectStore = function(uri, success, async, error) {
    doDelete(uri, success, async, error);
  };

  //--------------------------------------------------------------------------
  //                              Task Logs
  //--------------------------------------------------------------------------

  this.listTaskLogs = function(success, async, error) {
    doGet(this.info.taskLogsUri, TASKLOGS_JSON, success, async, error);
  };

  this.getTaskLog = function(uri, success, async, error) {
    doGet(uri, TASKLOG_JSON, success, async, error);
  };

  this.deleteTaskLog = function(uri, success, async, error) {
    doDelete(uri, success, async, error);
  };

  //--------------------------------------------------------------------------
  //                              DuraCloud
  //--------------------------------------------------------------------------

  this.listProviderAccounts = function(url, username, password, success, async, error) {
    doGet(this.info.providerAccountsUri + "?url=" + url + "&username=" + username + "&password=" + password, PROVIDERACCOUNTS_JSON, success, async, error);
  };

  this.listSpaces = function(url, username, password, providerAccountId, success, async, error) {
    doGet(this.info.spacesUri + "?url=" + url + "&username=" + username + "&password=" + password + "&providerAccountId=" + providerAccountId, SPACES_JSON, success, async, error);
  };

  //==========================================================================
  //                           PRIVATE METHODS
  //==========================================================================

  function doGet(url, contentType, success, async, error) {
    doGetOrDelete("GET", "json", url, contentType, success, async, error);
  }

  function doPost(url, inputContentType, outputContentType, data, success, async, error) {
    doPostOrPatch("POST", url, inputContentType, outputContentType, data, success, async, error);
  }

  function doPatch(url, contentType, data, success, async, error) {
    doPostOrPatch("PATCH", url, contentType, contentType, data, success, async, error);
  }

  function doDelete(url, success, async, error) {
    doGetOrDelete("DELETE", "json", url, "*/*", success, async, error);
  }

  function doGetOrDelete(method, dataType, url, contentType, success, async, error) {
    var errorCallback = error;
    if (typeof error === 'undefined') {
      errorCallback = defaultErrorCallback;
    }
    var asyncRequest = async;
    if (typeof async === 'undefined') {
      asyncRequest = true;
    }
    $.ajax({
      type: method,
      url: url,
      headers: {
        Accept: contentType
      },
      dataType: dataType,
      success: success,
      async: asyncRequest,
      error: function(httpRequest, textStatus, errorThrown) {
        errorCallback(httpRequest, method, url, textStatus, errorThrown);
      }
    })
  }

  function doPostOrPatch(method, url, inputContentType, outputContentType, data, success, async, error) {
    var errorCallback = error;
    if (typeof error === 'undefined') {
      errorCallback = defaultErrorCallback;
    }
    var asyncRequest = async;
    if (typeof async === 'undefined') {
      asyncRequest = true;
    }
    $.ajax({
      type: method,
      url: url,
      headers: {
        Accept: outputContentType
      },
      contentType: inputContentType,
      data: JSON.stringify(data),
      dataType: "json",
      success: success,
      async: asyncRequest,
      error: function(httpRequest, textStatus, errorThrown) {
        errorCallback(httpRequest, method, url, textStatus, errorThrown);
      }
    })
  }

  function defaultErrorCallback(httpRequest, method, url, textStatus, errorThrown) {
    if (httpRequest.status == 0 || httpRequest.status == 503) {
      alert("[Service Unavailable]");
      window.location.reload();
    } else if (httpRequest.status == 200) {
      alert("Your session has expired.\n\nPlease login again.");
      window.location.reload();
    } else {
      alert("[Service Error]\n\nUnexpected HTTP response code ("
          + httpRequest.status + ") from request:\n\n" + method + " " + url);
    }
  }

  // CONSTRUCTION

  var data = "";
  this.getServiceInfo(function(result) {
      data = result.service;
  }, false);
  this.info = data;
}
