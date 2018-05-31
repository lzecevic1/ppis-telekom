import Ember from 'ember';

export default Ember.Service.extend({
  error(message) {
    sweetAlert({
      title: message,
      confirmButtonText: 'Try again',
      confirmButtonColor: '#DC5154',
      type: 'error'
    });
  },
  success(title, callback) {
    sweetAlert({
      title: title,
      confirmButtonText: 'OK',
      confirmButtonColor: '#DC5154',
      type: 'success'
    })
    .then(callback);
  },
  confirm(title, message, callback) {
    swal({
      title: title,
      text: message,
      cancelButtonText: 'Ne',
      confirmButtonText: 'Da',
      showCancelButton: true,
      confirmButtonColor: '#DC5154',
      type: 'warning',
      dangerMode: true,
    }).then(callback);
  }
});
