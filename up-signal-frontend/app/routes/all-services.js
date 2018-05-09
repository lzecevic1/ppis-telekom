import Ember from 'ember';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend({
  _supplierService: service('suppliers-service'),
  model() {
      console.log("get all suppliers");
    return this.get('_supplierService').getAllServices() || {};
  },

  actions: {

  }
});
