fupApp.factory('dataFromServer', function($resource) {
  return $resource('http://www.w3schools.com/angular/customers.php', {}, {
    query: { method: "GET", isArray: false }
  });
});

fupApp.controller('testController', function($scope, dataFromServer) {
	var tc = this;
    dataFromServer.query(function(data) {
        tc.names = data.records;
    });
});


	//request example what using $http
	/*$http.get("http://www.w3schools.com/angular/customers.php").then(
		function(response) {
			tc.names = response.data.records;
		}
	);*/
