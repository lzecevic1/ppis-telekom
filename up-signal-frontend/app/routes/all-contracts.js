import Ember from 'ember';
import LoginRoute from './login';

const {
  inject: {
    service
  }
} = Ember;

export default LoginRoute.extend({
  _contractService: service('contract-service'),
  _swalService: service('swal-service'),

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
      this.get('_swalService').confirm("Jeste li sigurni?", "Da li želite da deaktivirate ugovor sa odabranim dobavljačem?", (isConfirm) => {
        if (isConfirm) {
          this.get('_contractService').deactivateContract(id).then(() => this.refresh());
        } else {

        }
      });

    },
    deleteContract: function(id) {
      this.get('_contractService').deleteContract(id).then(() => this.refresh());
    },
    renewContract(id) {
      this.get('_contractService').renewContract(id).then(() => this.refresh());
    }
   }
});
