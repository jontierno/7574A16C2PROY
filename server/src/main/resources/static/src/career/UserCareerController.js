(function(){

  angular
       .module('career')
       .controller('UserCareerController', [
          'careerService', '$log', '$state','$scope',
          UserCareerController
       ]);

  function UserCareerController ( careerService,  $log, $state,$scope ) {
    var self = this;
    self.career = {};

        careerService.loadCareer($scope.currentUser.career)
            .then(function(career){
                self.career = career;
            });


    
  }

})();
