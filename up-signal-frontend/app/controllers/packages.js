import Ember from 'ember';
const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Controller.extend({
  _supplierService: service('suppliers-service'),
  session: Ember.inject.service('session')
});
