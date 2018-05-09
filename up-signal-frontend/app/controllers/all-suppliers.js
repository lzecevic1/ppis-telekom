import Ember from 'ember';

const {
    inject: {
      service
    }
  } = Ember;

export default Ember.Controller.extend({
     _supplierService: service('suppliers-service'),
    
     supplierId: null,

    actions: { 
        delete: function(supplierId) {
            this.get('_supplierService').deleteSupplier(supplierId).then(()=>{
                this.set('supplierId', null);      
                this.get('target.router').refresh();                      
            });
        },

        setSupplierToDelete: function(serviceId) {
            this.set('supplierId', serviceId);
        },
        
        cancelDeleting: function() {
            this.set('supplierId', null);
        }
    }
});
