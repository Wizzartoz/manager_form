'use strict'

const personForm = angular.module('personFormTemplateApp', [])
personForm.component('personFormTemplate', {
    templateUrl: 'person-form-template.html',
    controller: ['$scope', '$http', '$state', 'host', function PersonFormController($scope, $http, $state, host) {

        $scope.genderHobbies = [];

        $scope.person = {
            name: '',
            surname: '',
            patronymic: '',
            gender: '',
            dob: '',
            hobbies: []
        };

        $http.get(host + '/forms/' + $state.params['id']).then(function (response) {
            $scope.person = response.data;
            $http.get(host + '/hobbies/' + $scope.person.gender).then(function (response) {
                $scope.genderHobbies = response.data;
            })
        }, function () {
            alert("Form doesn't exist");
        });


        $scope.editForm = function () {
            $http.post(host + '/forms', $scope.person).then(function (response) {
                $scope.person = response.data;
                $scope.$emit('onEdit', response.data);
            }, function () {
                alert('Incorrect values of fields');
            });
        };

        $scope.deleteTag = function (name) {
            $scope.person.hobbies = $scope.person.hobbies.filter(hobby => hobby.name !== name);
        };


        $scope.addTag = function (name) {
            $scope.genderHobbies.forEach(hobby => {
                if (hobby.name === name) {
                    if (!$scope.person.hobbies.find(tag => tag.name === name)) {
                        $scope.person.hobbies.push(hobby);
                    }
                }
            })
        };
    }]
});
