(function(){
  'use strict';

  angular.module('users')
         .service('userService', ['$q', 'localStorageService', UserService]);

  function UserService($q, localStorageService){

    var users = [
      {
        username: "user1",
        password  :"user1",
        name: "Jonathan Tierno",
        career: 10,
        registers: []
      },
      {
        username: "user2",
        password  :"user2",
        name: "Juan Perez",
        career: 13,
        registers: []
      }
    ];
    

    //localStorageService.set("users", users);

    users =  localStorageService.get("users");
    // Promise-based API
    function findUser(username) {
        for(var i in users) {
          if(users[i].username == username) {
            return i;
          }
        }
        return null;
    }
    return {
      loadAllUsers : function() {
        return $q.when(users);
      },
      loadUser:function (username) {
        var index = findUser(username);
        if(index != null) {
          return $q.when(angular.copy(users[index]))
        }
        return $q.reject();
      },
        save: function(user) {
          var i = findUser(user.username);
          if(i != null) {
            users[i] = angular.copy(user);
            localStorageService.set("users", users);
            return $q.when();
          }
          return $q.reject("User not found"); 
        }

    };
  }

})();
