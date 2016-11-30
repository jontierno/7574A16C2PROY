angular
    .module('fiubaApp', ['ngMaterial', 'ui.router', 'login', 'auth', 'career', 'register', 'main', 'LocalStorageModule', 'angular-jwt'])
    .config(function ($mdThemingProvider, $mdIconProvider, $stateProvider, $urlRouterProvider, $httpProvider, jwtOptionsProvider) {

        jwtOptionsProvider.config({
            tokenGetter: ['authService',function (authService, options) {
                if (options && options.url.substr(options.url.length - 5) == '.html') {
                    return null;
                }
                return authService.getToken();
            }],
            unauthenticatedRedirector: ['$state', function ($state) {
                $state.go('login');
            }],
            authPrefix: ''
        });

        $httpProvider.interceptors.push('jwtInterceptor');
        $mdThemingProvider
            .theme('default')
            .primaryPalette('indigo')
            .accentPalette('pink')
            .warnPalette('red')
            .backgroundPalette('blue-grey');
        //
        // For any unmatched url, redirect to /state1
        $urlRouterProvider.otherwise("/home");
        //
        // Now set up the states
        $stateProvider
            .state('app', {
                templateUrl: "src/main/view/main.html",
                controller: 'MainController as main',
                abstract: true,
                /*  resolve: {

                 // A string value resolves to a service
                 authService: 'authService',

                 // A function value resolves to the return
                 // value of the function
                 authorization: function (authService, $q, $state, $log) {
                 var defer = $q.defer();
                 authService.getCurrentUser().then(function () {
                 defer.resolve();
                 }, function () {
                 $log.debug("Not user found");
                 $state.go("login");
                 })

                 return defer.promise;
                 }
                 },*/
                data: {
                    requiresLogin: true
                }
            })
            .state('app.wellcome', {
                url: "/home",
                templateUrl: "src/main/view/wellcome.html"
            })
            .state('login', {
                url: "/login",
                templateUrl: "src/login/view/login.html",
                controller: 'LoginController as login'
            })
            .state('app.career', {
                url: "/career",
                templateUrl: "src/career/view/userCareer.html",
                controller: 'UserCareerController as userCareer'
            }).state('app.inscription', {
            url: "/register",
            templateUrl: "src/register/view/register.html",
            controller: 'RegisterController as regCtrl'
        }).state('app.inscriptions', {
            url: "/viewregisters",
            templateUrl: "src/register/view/viewRegisters.html",
            controller: 'ViewRegistersController as regCtrl'
        });
        ;

    }).run(function (authManager) {
    authManager.checkAuthOnRefresh();
    authManager.redirectWhenUnauthenticated();
});