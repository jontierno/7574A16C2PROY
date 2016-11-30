(function(){
  'use strict';

  angular.module('register')
         .service('registerService', ['$q', 'userService','courseService', RegisterService]);

  function RegisterService($q, userService, courseService){
  
    return {
      markSelecteds : function(user, courses) {
      
        for (var i in user.registers){
          for(var j in courses) {
            if(user.registers[i].subject == courses[j].subject &&
              user.registers[i].code == courses[j].code) {
              courses[j].selected = true;
              break;
            }

          }
        }
        return $q.when();

      },
      register: function (user, course){
          courseService.register(course);
          user.registers.push({code: course.code, subject: course.subject});
          return userService.save(user);
      },
      unregister: function (user, course){  
          courseService.unregister(course);
          for(var i in user.registers) {
            if(user.registers[i].code == course.code && user.registers[i].subject == course.subject) {
              user.registers.splice(i, 1);
            }
          }
          return userService.save(user);
      }
    };
  }

})();
