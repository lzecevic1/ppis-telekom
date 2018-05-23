import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend(SweetAlertMixin, {
  _supplierService: service('suppliers-service'),
  session: Ember.inject.service(),

  model: function () {
    //returns an empty supplier model
    return this.get('_supplierService').createService();
  },

  beforeModel(transition)
  {
    if(!this.get('session.isAuthenticated')) {
      this.transitionTo('login');
    }
    else if(this.get('session.data.authenticated.user.role.name') == "SUPPLIER")
      this.transitionTo('homepage');
  },

  actions: {
    onNext: function () {
      let sweetalert = this.get('sweetAlert');
      this.get('_supplierService').addService(this.controller.get('model'))
        .then(()=> {
          sweetalert({
            title: 'Uspješno dodana usluga',
            confirmButtonText: 'OK',
            type: 'success'
          })
          .then((confirm)=>{
            this.transitionTo('all-services');
          });
        },
        function(reason){
          sweetalert({
            title: 'Došlo je do greške prilikom kreiranja usluge',
            confirmButtonText: 'Pokušajte ponovo',
            type: 'error'
          })
        })
      }
    }
});
