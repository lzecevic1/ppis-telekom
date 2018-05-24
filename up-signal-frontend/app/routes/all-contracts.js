import Ember from 'ember';
import LoginRoute from './login';

const {
  inject: {
    service
  }
} = Ember;

export default LoginRoute.extend({
  _contractService: service('contract-service'),
  id: null,

  model: function (transition) {
    return this.get('_contractService').getAllContracts() || {};
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
    deactivateContract: function(id) {
      this.get('_contractService').deactivateContract(id).then(() => this.refresh());
    },
    deleteContract: function(id) {
      this.get('_contractService').deleteContract(id).then(() => this.refresh());
    }
   }
});
