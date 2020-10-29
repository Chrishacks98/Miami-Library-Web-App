(function () {
    'use strict';

    var services = angular.module('hb');

    var baseUrl = 'api/books';

    services.factory('books', function ($resource) {
        return $resource(baseUrl, {}, {
            query: {method: 'GET', isArray: true},
            create: {method: 'POST'}
        });
    });

    services.factory('book', function ($resource) {
        return $resource(baseUrl + '/:id', {}, {
            show: {method: 'GET', params: {id: '@id'}},
            update: {method: 'PUT', params: {id: '@id'}},
            delete: {method: 'DELETE', params: {id: '@id'}}
        });
    });
}());