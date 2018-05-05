import Ember from 'ember';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend({
  _supplierService: service('suppliers-service'),

  model() {
    return this.get('_supplierService').getAllServices() || {};
  },

  actions: {
    delete: function (id) {
      this.get('_supplierService').deleteService(id).then(()=>this.refresh())
    }
  }

});
