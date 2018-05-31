import Ember from 'ember';

export default Ember.Service.extend({
  generateReport(path) {
    Ember.$.ajax({
      url: path,
      method: 'GET',
      responseType: 'arraybuffer'
    }).then( response => {
      let linkElement = document.createElement('a');
      linkElement.setAttribute('href', 'http://localhost:8080' + path);
      linkElement.click();
    }).catch(error => {
      console.log('Error occured during pdf download: ' + error);
    });
  },
});
