(function(){

  angular
       .module('login', [ 'ngMessages', 'auth'])
       .controller('LoginController', [
          'authService', '$log', '$state',
          LoginController
       ]);

  function LoginController( authService,  $log, $state ) {
    var self = this;
    self.user        = {};
    self.status="";
    self.login = login;
    self.change = change;

    function login(){
    	self.status="";
    	authService.login(self.user)
    	.then(function () {
    		$state.go("app.wellcome");
    	}, function(message) {
    		$log.debug(message);
    		self.status=message;
    	})
    }
    function change() {
    	self.status="";
    }
  }

})();
