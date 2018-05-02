import Ember from 'ember';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend({
  _supplierService: service('suppliers-service'),

  model: function () {
    //returns an empty supplier model
    return this.get('_supplierService').createSupplier();
  },

  actions: {
    onNext: function () {
     this.get('_supplierService').addSupplier(this.controller.get('model'))
      .then(()=> this.transitionTo('services'));
    },

  }
});
