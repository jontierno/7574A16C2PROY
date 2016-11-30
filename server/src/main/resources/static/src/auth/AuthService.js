(function(){
  'use strict';

  angular.module('auth')
         .service('authService', ['$q','userService', AuthService]);

  /**
   * Users DataService
   * Uses embedded, hard-coded data model; acts asynchronously to simulate
   * remote data service call(s).
   *
   * @returns {{loadAll: Function}}
   * @constructor
   */
  function AuthService($q, userService){
    var authenticatedUser =  null;

    // Promise-based API
    return {
      login : function(user) {
        var deferred = $q.defer();
        return userService.loadUser(user.username)
          .then(function (userFound) {

              if(userFound.password == user.password) {
                authenticatedUser = userFound;
                return $q.resolve();
              } else {
                return $q.reject('Username/Pasword inválido');
              }

          }).catch(function (err){
              return $q.reject('Username/Pasword inválido');
          });
        
      },
      getCurrentUser: function () {
          var def = $q.defer();
          if(authenticatedUser) {
            def.resolve(authenticatedUser)
          } else {
            def.reject();
          }
         return def.promise;
      },
      logout: function () {
        
        var deferred = $q.defer();
        authenticatedUser = null;
        deferred.resolve();
        return deferred.promise;
      }

    };
  }

})();
