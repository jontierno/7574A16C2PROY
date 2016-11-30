(function () {
    'use strict';

    angular.module('auth')
        .service('authService', ['$q', '$http', 'userService', 'localStorageService', AuthService]);

    function AuthService($q, $http, userService, localStorageService) {
        var authenticatedUser = null;

        // Promise-based API
        return {

            login: function (data) {
                return $http.post('/auth', {
                    username: data.username,
                    password: data.password
                }).then(function (response) {
                        localStorageService.set('id_token', response.data.token);
                        return userService.loadUser()
                            .then(function (userFound) {
                                authenticatedUser = userFound;
                                return $q.resolve();
                            });
                }).catch(function (response) {
                    return $q.reject("Usuario/Contraseña inválido");
                });
            },
            getCurrentUser: function () {
                if (authenticatedUser) {
                    var def = $q.defer();
                    def.resolve(authenticatedUser);
                    return def.promise;
                } else {
                    return userService.loadUser()
                        .then(function (userFound) {
                            authenticatedUser = userFound;
                            return $q.resolve(authenticatedUser);
                        });
                }

            },
            logout: function () {
                var deferred = $q.defer();
                authenticatedUser = null;
                localStorageService.remove('id_token');
                deferred.resolve();
                return deferred.promise;
            },
            getToken: function () {
                return localStorageService.get('id_token');
            }

        };
    }

})();
