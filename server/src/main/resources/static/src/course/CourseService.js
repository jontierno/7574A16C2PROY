
(function(){
  'use strict';

  angular.module('course')
         .service('courseService', ['$q', '$log','localStorageService', CourseService]);


  function CourseService($q, $log, localStorageService){
    var courses = [
      {
        code: "11A",
        subject: '61.03',
        professors: ['Sirne', 'Fiorante', 'Oliva'],
        vacancy: 30,
        classes: [{day: "Martes",type: "Práctica Obligatoria",from: '14:00',to: "16:00",place: "PC-302"}
        ,{day: "Martes",type: "Teórica Obligatoria",from: '16:00',to: "18:00",place: "PC-500"}
        ,{day: "Jueves",type: "Práctica Obligatoria",from: '14:00',to: "16:00",place: "PC-302"}
        ,{day: "Jueves",type: "Teórica Obligatoria",from: '16:00',to: "18:00",place: "PC-500"}]
      }, {
        code: "11B",
        subject: '61.03',
        professors: ['Sirne', 'Martins', 'Lopez'],
        vacancy: 30,
        classes: [{day: "Martes",type: "Práctica Obligatoria",from: '14:00',to: "16:00",place: "PC-310"}
        ,{day: "Martes",type: "Teórica Obligatoria",from: '16:00',to: "18:00",place: "PC-500"}
        ,{day: "Jueves",type: "Práctica Obligatoria",from: '14:00',to: "16:00",place: "PC-310"}
        ,{day: "Jueves",type: "Teórica Obligatoria",from: '16:00',to: "18:00",place: "PC-500"}]
      }, {
        code: "20B",
        subject: '61.03',
        professors: ['Seminara','Lucuy Suarez','Galvan'],
        vacancy: 30,
        classes: [{day: "Lunes",type: "Práctica Obligatoria",from: '17:00',to: "19:00",place: "PC-302"}
        ,{day: "Lunes",type: "Teórica Obligatoria",from: '19:00',to: "21:00",place: "PC-500"}
        ,{day: "Jueves",type: "Práctica Obligatoria",from: '17:00',to: "19:00",place: "PC-302"}
        ,{day: "Jueves",type: "Teórica Obligatoria",from: '19:00',to: "21:00",place: "PC-500"}]
      },{
        code: "1",
        subject: '75.40',
        professors: ['Guarna','Bianchi','Gonzalez Busquin','Juarez','Soriano Bouissou'],
        vacancy: 30,
        classes: [{day: "Martes",type: "Teórico Práctica Obligatoria ",from: '19:00',to: "22:00",place: "PC-302"}
        ,{day: "Jueves",type: "Teórico Práctica Obligatoria ",from: '19:00',to: "22:00",place: "PC-302"}]
      },{
        code: "2",
        subject: '75.40',
        professors: ['Azcurra','Bianchi','Salvia-Otero'],
        vacancy: 30,
        classes: [{day: "Lunes",type: "Teórico Práctica Obligatoria ",from: '19:00',to: "22:00",place: "PC-302"}
        ,{day: "Miercoles",type: "Teórico Práctica Obligatoria ",from: '19:00',to: "22:00",place: "PC-302"}]
      },{
        code: "01",
        subject: '65.03',
        professors: [ 'Boeykens','Gobbi Miñones','Piol','Casaburi'],
        vacancy: 20,
        classes: [{day: "Lunes",type: "Teórico Obligatoria ",from: '16:00',to: "18:00",place: "PC-502"}
        ,{day: "Martes",type: "Laboratorio Obligatoria ",from: '12:00',to: "18:00",place: "PC-502"}
        ,{day: "Martes",type: "Clases de problemas Obligatoria ",from: '18:00',to: "20:00",place: "PC-502"}]
      }
    ];

    //localStorageService.set("courses", courses);

    courses =  localStorageService.get("courses");


    return {
      getCourses : function(subject) {
        var result = [];
        for(var i in courses) {
            if(courses[i].subject == subject) {
              result.push(angular.copy(courses[i]));
            }
        }
        
        return $q.when(result);
      },
      getCourse: function (subject, code) {
        for(var i in courses) {
            if(courses[i].subject == subject && courses[i].code == code) {
              return $q.when(angular.copy(courses[i]));
            }
        }
        
        return $q.reject("Course not found");
      },
      register: function (course) {
          for(var i in courses) {
            if(courses[i].subject == course.subject && courses[i].code == course.code) {
              courses[i].vacancy = courses[i].vacancy -1;
              localStorageService.set("courses", courses);
            }
        }
      },
      unregister: function (course) {
          for(var i in courses) {
            if(courses[i].subject == course.subject && courses[i].code == course.code) {
              courses[i].vacancy = courses[i].vacancy + 1;
              localStorageService.set("courses", courses);
            }
        }
      }
    };
  }

})();
