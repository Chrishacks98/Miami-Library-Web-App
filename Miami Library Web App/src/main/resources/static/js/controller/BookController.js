(function(){
    'use strict';

    var app = angular.module('hb');

    app.controller('BookCtrl', ['$scope', 'books', 'book', function($scope, books, book){
        $scope.editing = false;

        $scope.createInit = function(){
            $scope.editing = true;
            $scope.creating = true;
        };

        $scope.updateInit = function(currBook){
            $scope.editing = true;
            $scope.updating = true;
            $scope.book = currBook;
        };

        var crudFinally = function() {
            $scope.editing = false;
            $scope.creating = false;
            $scope.updating = false;
            $scope.book = {};
        };

        var onCreateSuccess = function(){
            getBooks();
        };

        var onCreateError = function(reason){
            console.log(reason);
        };

        var createBook = function(){
            books.create($scope.book).$promise
                .then(onCreateSuccess, onCreateError)
                .finally(crudFinally);
        };

        var updateBook = function(){
            book.update({id: $scope.book.bookCode}, $scope.book)
                .$promise
                .finally(crudFinally);
        };

        $scope.createUpdateBook = function(){
            var storedBook = book.show({id: $scope.book.bookCode})
                .$promise
                .then(updateBook, createBook);
        };

        var getBooks = function(){
            $scope.books = books.query();
        };

        $scope.deleteBook = function(currBook){
            book.delete({id: currBook.bookCode})
                .$promise
                .finally(function(){
                    getBooks();
                });
        };

        getBooks();
    }]);

}());