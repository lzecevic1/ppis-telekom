import Ember from 'ember';
import LoginRoute from './login';
const {
  inject: {
    service
  }
} = Ember;

export default LoginRoute.extend({
  _supplierService: service('suppliers-service'),
  _contractService: service('contract-service'),

  beforeModel(transition)
  {
    if(!this.get('session.isAuthenticated')) {
      this.transitionTo('login');
    }
  },
  model() {
    return this.get('_supplierService').getAllSuppliers() || {};
  },

  actions: {

  createContract: function(id) {
    this.get('_contractService').setCurrentSupplier(id);
    this.transitionTo('new-contract', id);
  }

  }
});


