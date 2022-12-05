const notification = angular.module('notificationApp', [])
    .component('notification', {
            bindings: {msg: '@', isError: '<'},
            templateUrl: 'notification-component.html',
            controller: [() => {

        }]}
    )


