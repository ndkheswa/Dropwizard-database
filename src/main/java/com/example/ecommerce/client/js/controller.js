angular.module('app', [])
    .controller('AppCtrl', ApplyController)
function ApplyController($scope) {
    $scope.name = "World";
}
