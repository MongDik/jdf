var app = angular.module('jdf', []);
app.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/', {
            controller : 'RootCtrl',
            templateUrl : "module/admin/main.html"
        }).when('/userList', {
            controller : 'UserListCtrl',
            templateUrl : 'module/admin/userList.html'
        }).when("/userDetails:userId", {
        	controller : "UserDetailsCtrl",
        	templateUrl : "module/admin/userDetails.html"
        }).otherwise({
            redirectTo : '/'
        });
}]);

app.controller('RootCtrl', ['$scope', function($scope){
    $scope.title = "首页";
}]);

app.controller('UserListCtrl', ['$scope', '$http', function($scope, $http){
    $scope.title = "用户列表";
    $http.post($ctx + '/app/user/list', {}).success(function(response) {
    	$scope.userList = response.data;
    });
}]);

app.controller('UserDetailsCtrl', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http){
    $scope.title = "User Page";
    $http.post($ctx + '/app/user/get', {id:$routeParams.userId }).success(function(response) {
    	$scope.userList = response.data;
    });
}]);
