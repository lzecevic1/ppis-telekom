import Ember from 'ember';

const {
  inject: {
    service
  }
} = Ember;

export default Ember.Controller.extend({
 _supplierService: service('suppliers-service'),

 supplierId: null,
 session: Ember.inject.service('session'),
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
  },

  rateSupplier: function(supplierId) {
    this.get('_supplierService').addRating(supplierId).then(()=>{
      this.get('target.router').refresh();
    })
  },
  readRatingsSupplier: function(supplierId) {
    this.get('_supplierService').getAvgRating(supplierId);
  },
}
});
