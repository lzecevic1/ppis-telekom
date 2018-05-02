import Ember from 'ember';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend({
  _supplierService: service('suppliers-service'),


  model() {
    return Ember.RSVP.hash({
      services: (this.get('_supplierService').getAllServices() || {}),
      suppliers: (this.get('_supplierService').getAllSuppliers() || {})
    });
  },


});
