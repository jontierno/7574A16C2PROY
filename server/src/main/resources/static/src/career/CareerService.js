(function () {
    'use strict';

    angular.module('career')
        .service('careerService', ['$q', '$http', 'localStorageService', CareerService]);

    function CareerService($q, $http, localStorageService) {

        // Promise-based API
        return {
            loadCareer: function (code) {
                return $http.get("/career/" + code).then(function (response) {
                    return $q.resolve(response.data);
                });
            },
            loadCourses: function (subjectCode) {
                return $http.get("/subject/" + code + "/courses").then(function (response) {
                    return $q.resolve(response.data);
                });
            }
        };
    }

})();
