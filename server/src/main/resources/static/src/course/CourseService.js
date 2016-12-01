
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
      getCourse: function (subject, code) {
        for(var i in courses) {
            if(courses[i].subject == subject && courses[i].code == code) {
              return $q.when(angular.copy(courses[i]));
            }
        }
        
        return $q.reject("Course not found");
      },
      register: function (course) {
          for(var i in courses) {
            if(courses[i].subject == course.subject && courses[i].code == course.code) {
              courses[i].vacancy = courses[i].vacancy -1;
              localStorageService.set("courses", courses);
            }
        }
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
