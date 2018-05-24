import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';
const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend(SweetAlertMixin, {
  _contractService: service('contract-service'),
  session: Ember.inject.service('session'),
  id: null,

  model: function (transition) {
    console.log(transition.id)
    //returns an empty supplier model
    this.set('id',transition.id);
    return this.get('_contractService').createContract();
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
      let sweetAlert = this.get('sweetAlert');
      this.controller.set('model.supplierId',this.get('id'));
      this.get('_contractService').addContract(this.controller.get('model'))
         .then(()=>{
           sweetAlert({
             title: 'Uspješno kreiran novi ugovor',
             confirmButtonText: 'OK',
             type: 'success'
           }).then((confirm)=>this.transitionTo('all-suppliers'));
         })
    },
  }
});