angular.module('sportsStore', ["customFilters"])
  .controller('sportsStoreCtrl', applyController)
    .constant("dataUrl", "http://localhost:8080/product")
function applyController ($scope, $http, dataUrl) {

    $scope.data = {};

    $http.get(dataUrl)
        .success(function (data) {
            $scope.data.products = data;
        })
        .error(function (error) {
            $scope.data.error = error;
        });
};