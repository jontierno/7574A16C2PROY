(function(){

  angular
       .module('career')
       .controller('UserCareerController', [
          'careerService', '$log', '$state','$scope','authService',
          UserCareerController
       ]);

  function UserCareerController ( careerService,  $log, $state,$scope,authService ) {
    var self = this;
    self.career = {};
        authService.getCurrentUser().then(function (user) {
            careerService.loadCareer(user.career).then(function (career) {
                self.career = career;
            })
        });
  }

})();
