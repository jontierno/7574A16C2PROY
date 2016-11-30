(function(){
  'use strict'
  angular
       .module('register')
       .controller('ViewRegistersController', [
          'courseService', '$log', '$q','$scope',
          ViewRegistersController
       ]);

  function ViewRegistersController (courseService, $log, $q,$scope ) {
    var self = this;
    self.selectedCourses = [];
    var coursesFound = []
    $q.all($scope.currentUser.registers.map(function(item) {
        return courseService.getCourse(item.subject, item.code).then(function(found){
            coursesFound.push(found);
        });
    })).then(function(){
      self.selectedCourses = coursesFound;
    });    
  }

})();
