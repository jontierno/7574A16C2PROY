(function () {
    'use strict';

    angular.module('auth')
        .service('authService', ['$q', '$http', 'userService', 'localStorageService', AuthService]);

    function AuthService($q, $http, userService, localStorageService) {
        var authenticatedUser = null;

        // Promise-based API
        return {
            /*     login: function (user) {
             return userService.loadUser(user.username)
             .then(function (userFound) {

             if (userFound.password == user.password) {
             authenticatedUser = userFound;
             return $q.resolve();
             } else {
             return $q.reject('Username/Pasword inválido');
             }

             }).catch(function (err) {
             return $q.reject('Username/Pasword inválido');
             });

             },*/

            login: function (data) {
                return $http.post('/auth', {
                    username: data.username,
                    password: data.password
                }).then(function (response) {
                        localStorageService.set('id_token', response.data.token);
                        return userService.loadUser(data.username)
                            .then(function (userFound) {
                                authenticatedUser = userFound;
                                return $q.resolve();
                            });
                }).catch(function (response) {
                    return $q.reject("Usuario/Contraseña inválido");
                });
            },
            getCurrentUser: function () {
                var def = $q.defer();
                if (authenticatedUser) {
                    def.resolve(authenticatedUser)
                } else {
                    def.reject();
                }
                return def.promise;
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
