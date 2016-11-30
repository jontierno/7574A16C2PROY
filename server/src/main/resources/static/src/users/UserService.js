(function () {
    'use strict';

    angular.module('users')
        .service('userService', ['$q','$http', 'localStorageService', UserService]);

    function UserService($q, $http, localStorageService) {

        return {
            loadUser: function () {
                return $http.get("/user").then(function (response) {
                    return $q.resolve(response.data);
                });
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
