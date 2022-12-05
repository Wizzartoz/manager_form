'use strict'

const myApp = angular.module('myApp', [
    'ngRoute',
    'formTemplateApp',
    'notificationApp',
    'createPersonFormApp',
    'ui.router'
]).config(function ($stateProvider, $urlRouterProvider) {
    $stateProvider
        .state('home', {
            url: '',
            template: '<form-template></form-template>'
        })
        .state('home.person', {
            url: '/person/:id',
            template: '<person-form-template></person-form-template>',
        })
        .state('home.form', {
            url: '/forms',
            template: '<create-person></create-person>',
        });
    $urlRouterProvider.otherwise('/');
});

myApp.value('host', 'http://localhost:8080')

