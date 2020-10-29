(function(){
    'use strict';

    var app = angular.module('hb', ['ngRoute', 'ngResource']);

    app.config(function($routeProvider){
        $routeProvider
            .when('/', {
                templateUrl: 'html/home.html',
                controller: ''
            })
            .when('/book-manager', {
                templateUrl: 'html/books.html',
                controller: 'BookCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    });

}());