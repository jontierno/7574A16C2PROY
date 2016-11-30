(function(){
  'use strict';

  angular.module('career')
         .service('careerService', ['$q','localStorageService', CareerService]);

  function CareerService($q, localStorageService){
    
    var careers = [
      {
        code: 10,
        description: "Ingeniería Informática",
        subjects: [{
          code: "61.03",
          description: "Analisis Matemático II"
        },{
          code: "75.40",
          description: "Algoritmos y programación I"
        }]
      },{
        code: 13,
        description: "Ingeniería Química",
        subjects: [{
          code: "61.03",
          description: "Analisis Matemático II"
        },{
          code: "65.03",
          description: "Química Analítica"
        }]
      }

    ];
    //localStorageService.set("careers", careers);

    careers =  localStorageService.get("careers");

    // Promise-based API
    return {
      loadCareer : function(code) {
          for(var i in careers) {
            if(careers[i].code == code) {
              return $q.when(angular.copy(careers[i]));
            }
  
          }
          return $q.reject("Carrera no encontrada");
      }
    };
  }

})();
