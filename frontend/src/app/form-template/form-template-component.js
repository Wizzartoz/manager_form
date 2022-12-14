'use strict'

const form = angular.module('formTemplateApp', [
    'personFormTemplateApp',
    'createPersonFormApp'
])
form.component('formTemplate', {
    templateUrl: 'form-template.html',
    controller: ['$scope', '$http', '$route', '$window', '$state', 'host',
        function FormTemplateController($scope, $http, $route, $window, $state, host) {
            $scope.persons = [];
            $scope.isOpenForm = false;

            $http.get(host + '/forms').then(function (response) {
                $scope.persons = response.data;
            }, function () {

            });

            $scope.$on('onAdd', function (evt, data) {
                $scope.persons.unshift(data);
            });

            $scope.$on('onEdit', function (evt, data) {
                $scope.persons.forEach((person, index) => {
                    if (person.id === data.id) {
                        $scope.persons[index] = data;
                    }
                });
            });

            $scope.editForm = function (id) {
                $scope.isOpenForm = true;
                $state.go('home.person', {id: id});
            };

            $scope.createForm = function () {
                $scope.isOpenForm = true;
                $state.go('home.form');
            };

            $scope.deleteForm = function (id) {
                $http.delete(host + '/forms/' + id).then(function () {
                }, function () {
                    console.log('Error when deleting form');
                })
                $scope.persons = $scope.persons.filter(person => person.id !== id);
            };
        }]
});
