(function () {
    'use strict';

    angular.module('users')
        .service('userService', ['$q','$http', 'localStorageService', UserService]);

    function UserService($q, $http, localStorageService) {

        return {
            loadUser: function (username) {
                return $http.get("/user");
            },
            save: function (user) {
                var i = findUser(user.username);
                if (i != null) {
                    users[i] = angular.copy(user);
                    localStorageService.set("users", users);
                    return $q.when();
                }
                return $q.reject("User not found");
            }

        };
    }

})();
