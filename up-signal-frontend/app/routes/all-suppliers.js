import Ember from 'ember';
import LoginRoute from './login';
const {
  inject: {
    service
  }
} = Ember;

export default LoginRoute.extend({
  _supplierService: service('suppliers-service'),

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
  
  }
});


