import Ember from 'ember';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Controller.extend({
     _supplierService: service('suppliers-service'),
    
     serviceId: null,
     session: Ember.inject.service('session'),
    actions: { 
        delete: function(serviceId) {
            this.get('_supplierService').deleteService(serviceId).then(()=>{
                this.set('serviceId', null);      
                this.get('target.router').refresh();                      
            });
        },

        setServiceToDelete: function(serviceId) {
            this.set('serviceId', serviceId);
        },
        
        cancelDeleting: function() {
            this.set('serviceId', null);
        }
    }
});
