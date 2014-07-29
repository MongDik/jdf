var app = angular.module('jdf', []);
app.config(['$routeProvider', function($routeProvider){
    $routeProvider.when('/', {
            controller : 'RootCtrl',
            templateUrl : "module/admin/main.html"
        }).when('/userList', {
            controller : 'UserListCtrl',
            templateUrl : 'module/admin/userList.html'
        }).when("/userDetails", {
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
    $http.post('/jdf/app/user/list', {}).success(function(response) {
    	$scope.userList = response;
    });
}]);

app.controller('UserDetailsCtrl', ['$scope', '$routeParams', '$http', function($scope, $routeParams, $http){
    $scope.title = "User Page";
}]);
