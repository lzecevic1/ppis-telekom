import Ember from 'ember';
import LoginRoute from './login';

const {
  inject: {
    service
  }
} = Ember;

export default LoginRoute.extend({
  _supplierService: service('suppliers-service'),

  model: function () {
    //returns an empty supplier model
    return this.get('_supplierService').createSupplier();
  },
  beforeModel(transition)
  {
    if(!this.get('session.isAuthenticated')) {
      this.transitionTo('login');
    }
    else if(this.get('session.data.authenticated.user.role.name') == "SERVICER")
      this.transitionTo('homepage');
  },
  actions: {
    onNext: function () {
     this.get('_supplierService').addSupplier(this.controller.get('model'))
      .then(()=> this.transitionTo('services'));
    },
  }
});
