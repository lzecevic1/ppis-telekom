import Ember from 'ember';

function randomIntFromInterval(min,max)
{
    return Math.floor(Math.random()*(max-min+1)+min);
}

export default Ember.Controller.extend({
    session: Ember.inject.service('session'),
  chartData:{
      labels: ['Usluge i korisnici'],
      datasets: [{
          label: 'Aktivni ugovori',
          data: [randomIntFromInterval(5000,8000)],
          backgroundColor:['rgba(255, 99, 132, 0.2)',],
          borderColor:['rgba(255,99,132,1)',],
          borderWidth:1,
      },
      {
          label:'Obnovljeni ugovori',
          data: [randomIntFromInterval(3000,6000)],
          backgroundColor:['rgba(54, 162, 235, 0.2)',],
          borderColor:['rgba(54, 162, 235, 1)',],
          borderWidth:1,
      },
      {
          label:'Raskinuti ugovori',
          data:[randomIntFromInterval(1000,2000)],
          backgroundColor:['rgba(75, 192, 192, 0.2)',],
          borderColor:['rgba(75, 192, 192, 1)'],
          borderWidth:1,
      }],
      scaleBeginAtZero : true,
    
  },
  barOptions: {
    scales: {
        yAxes: [{
            ticks: {
                beginAtZero: true
            }
        }]
    }
}
  });
