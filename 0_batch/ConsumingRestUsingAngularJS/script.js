angular.module('company-app', [])
.controller('Company', function($scope, $http) {
    $http.get('http://localhost:8080/company').
        then(function(response) {
            $scope.company = response.data;
        });
});
