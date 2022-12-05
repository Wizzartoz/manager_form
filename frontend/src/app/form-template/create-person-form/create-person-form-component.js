"use strict"

angular.module("createPersonFormApp", [])
    .component('createPerson', {
        templateUrl: 'create-person-form-template.html',
        controller: ['$scope', '$http', function CreatePerson($scope, $http) {

            $scope.genderHobbies = [];
            $scope.selectHobbies = [];

            let host = 'http://localhost:8080';

            $scope.person = {
                name: '',
                surname: '',
                patronymic: '',
                dob: '',
                gender: 'FEMALE' ?? $scope.gender,
                hobby: ''
            };

            $http.get(host + '/hobbies/' + $scope.person.gender).then(function (response) {
                $scope.genderHobbies = response.data;
            }, function () {
                console.log("Error")
            });

            $scope.addHobby = function () {
                $scope.genderHobbies = $scope.genderHobbies.filter(tag => {
                    if (tag.name === $scope.person.hobby) {
                        if (!$scope.selectHobbies.includes(tag)) {
                            $scope.selectHobbies.push(tag);
                        }
                    }
                    return tag !== $scope.person.hobby;
                });
            };

            $scope.setGender = function () {
                $http.get(host + '/hobbies/' + $scope.person.gender).then(function (response) {
                    $scope.genderHobbies = response.data;
                    $scope.selectHobbies = [];
                }, function () {
                    console.log("Error")
                });
            }

            $scope.deleteTag = function (name) {
                $scope.selectHobbies = $scope.selectHobbies.filter(tag => {
                    return tag.name !== name
                });
            }

            $scope.addForm = function () {
                let obj = {
                    name: $scope.person.name,
                    surname: $scope.person.surname,
                    patronymic: $scope.person.patronymic,
                    dob: $scope.person.dob,
                    gender: $scope.person.gender,
                    hobbies: $scope.selectHobbies.map(hobby => {
                        return {
                            $ref: 'hobby',
                            id: hobby.id
                        }
                    })
                };
                $http.post(host + '/forms', obj).then(function (response) {
                    $scope.$emit('onAdd', response.data)
                    $scope.person = {};
                    $scope.addNotification(false, 'cool')
                }, function () {
                    $scope.addNotification(true, 'some error')
                });
            }
        }]
    });
