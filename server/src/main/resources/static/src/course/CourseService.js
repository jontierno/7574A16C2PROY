
(function(){
  'use strict';

  angular.module('course')
         .service('courseService', ['$q', '$http', '$log','localStorageService', CourseService]);


  function CourseService($q, $http,$log, localStorageService){

    return {
      getCourses : function(subject) {
          return $http.get("/subject/"+subject+"/courses").then(function (response) {
              return $q.resolve(response.data);
          });
      },
      getUserCourses: function () {
          return $http.get("/user/courses").then(function (response) {
              return $q.resolve(response.data);
          });
      },
      register: function (course) {
          debugger;
          return $http.put("/register/" + course.code);

      },
      unregister: function (course) {
          for(var i in courses) {
            if(courses[i].subject == course.subject && courses[i].code == course.code) {
              courses[i].vacancy = courses[i].vacancy + 1;
              localStorageService.set("courses", courses);
            }
        }
      }
    };
  }

})();
