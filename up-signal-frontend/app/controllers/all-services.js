import Ember from 'ember';
import SweetAlertMixin from 'ember-sweetalert/mixins/sweetalert-mixin';
const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Controller.extend(SweetAlertMixin, {
     _supplierService: service('suppliers-service'),
     serviceId: null,
     session: Ember.inject.service('session'),
    actions: { 
        delete: function(serviceId) {
            let sweetAlert = this.get('sweetAlert');
            sweetAlert({
                    title: 'Jeste li sigurni da želite deaktivirati uslugu',
                    confirmButtonText: 'Da',
                    showCancelButton: true,
                    cancelButtonText: 'Ne',
                    type: 'warning'
                }).then((confirm)=>{
                    sweetAlert({
                        title: 'Uspješno deaktivirana usluga',
                        confirmButtonText: 'OK',
                        type: 'success'
                    }).then((confirm)=>{
                        this.get('_supplierService').deleteService(serviceId).then(()=>{                        
                        this.set('serviceId', null);      
                        this.get('target.router').refresh();
                        });                              
                    })
                })
        },
        deactivateService: function(serviceId) {
            this.get('_supplierService').deactivateService(serviceId)
              .then(()=>  this.get('target.router').refresh());
          },       
    }
});
