(function () {
    'use strict';

    angular.module('register')
        .service('registerService', ['$q', '$http', 'userService', 'courseService', RegisterService]);

    function RegisterService($q, $http, userService, courseService) {

        return {
            markSelecteds: function (user, courses) {
                return $http.get("/registration").then(function (response) {
                    var registrations = response.data;

                    for (var j in courses) {
                        if (registrations.indexOf(courses[j].code) > -1) {
                            courses[j].selected = true;
                        } else {
                            courses[j].selected = false;
                        }

                    }

                    return $q.resolve(courses);
                })
            },
            register: function (user, course) {
                return $http.put("/registration", {code: course.code});
            },
            unregister: function (user, course) {
                return $http.put("/unregistration", {code: course.code});
            }
        };
    }

})();
