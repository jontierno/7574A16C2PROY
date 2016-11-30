(function(){
  'use strict';

  angular.module('main')
         .service('mainService', ['$q', 'authService', '$state', MainService]);


  function MainService($q, authService){
    authService.getCurrentUser().then(function(user){
      self.currentUser = user;
      if(!user) {

      }
    });
    var menues = [
      {
        name: 'Inscribir',
        avatar: 'create',
        state: 'app.inscription'
      },
      {
        name: 'Ver Inscripciones',
        avatar: 'done_all',
        state: 'app.inscriptions'
      },
      {
        name: 'Ver Carrera',
        avatar: 'visibility',
        state: 'app.career'
      }
    ];

    return {
      loadMenu : function() {
        
        return $q.when(menues);
      }
    };
  }

})();
