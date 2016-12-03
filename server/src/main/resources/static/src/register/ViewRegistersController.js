(function () {
    'use strict'
    angular
        .module('register')
        .controller('ViewRegistersController', [
            'courseService', '$log', '$q', '$scope',
            ViewRegistersController
        ]);

    function ViewRegistersController(courseService, $log, $q, $scope) {
        var self = this;
        self.selectedCourses = [];
        var coursesFound = []
        courseService.getUserCourses().then(function (courses) {
            self.selectedCourses = courses;
        })

    }

})();
