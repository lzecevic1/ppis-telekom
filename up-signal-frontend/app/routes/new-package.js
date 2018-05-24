import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';
const {
  inject: {
    service
  }
} = Ember;

export default Ember.Route.extend(SweetAlertMixin, {
    _packageService: service('package-service'),
    _supplierService: service('suppliers-service'),
    session: Ember.inject.service('session'),
    id: null,
  
    model: function (transition) {
      console.log(transition.id)
      //returns an empty package model
      this.set('id',transition.id);
      return Ember.RSVP.hash({
        package: this.get('_packageService').createPackage(),
        service: this.get('_supplierService').getAllServices() || {}
      });
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
         // this.controller.set('model.packageId',this.get('id'));
         // let supplierId = this.get('_contractService').get('supplierId');
         // console.log("SUPPLIER ID : " + supplierId);
        //  this.controller.set('model.supplierId', supplierId);
          console.log(this.controller.get('model'));
          this.get('_packageService').addPackage(this.controller.get('model.package'))
             .then(()=>{
               sweetAlert({
                 title: 'Uspješno kreiran novi paket',
                 confirmButtonText: 'OK',
                 type: 'success'
               }).then((confirm)=>this.transitionTo('packages'));
             },
             function(reason){
               sweetAlert({
                 title: 'Niste unijeli sve potrebne podatke',
                 confirmButtonText: 'OK',
                 type: 'error'
               })
            })
        },
      }
});
