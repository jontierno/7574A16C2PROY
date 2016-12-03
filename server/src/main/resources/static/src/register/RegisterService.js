(function(){
  'use strict';

  angular.module('register')
         .service('registerService', ['$q', '$http','userService','courseService', RegisterService]);

  function RegisterService($q,$http, userService, courseService){
  
    return {
      markSelecteds : function(user, courses) {
        return $http.get("/registration").then(function (response) {
          var registrations = response.data;
            for (var i in registrations){
                for(var j in courses) {
                    if(registrations[i] == courses[j].code) {
                        courses[j].selected = true;
                        break;
                    }
                }
            }
        })
      },
      register: function (user, course){
            return $http.put("/registration",{code: course.code});
      },
      unregister: function (user, course){
          return $http.put("/unregistration",{code: course.code});
      }
    };
  }

})();
