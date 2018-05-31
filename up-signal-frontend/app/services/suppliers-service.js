import Ember from 'ember';
import BaseHttpService from './base-http-service';

export default BaseHttpService.extend({

	currentSupplier: null,
  currentService: null,
  currentRating: null,

  createSupplier() {
    let newSupplier = Ember.Object.create({
      name: '',
      address: '',
      category: '0',
      avgRating: 0.0,
      i: 1
    });
    this.set('currentSupplier', newSupplier);
    return this.get('currentSupplier');
  },


  createService() {
    let newService = Ember.Object.create({
      serviceId: '',
      name: '',
      price: '',
      type: '0',
      priority: '0',
      description:'',
      responsiblePerson: ''
    });
    this.set('currentService', newService);
    return this.get('currentService');
  },

  createRating(ratingValue) {
    let newRating = Ember.Object.create({
      ratingType: '0',
      rating: ratingValue,
      description: '',
    });
    this.set('currentRating', newRating);
    return this.get('currentRating');
  },

  getAllSuppliers() {
    return this.ajax('GET', '/suppliers');
  },

  getService(id) {
    return this.ajax('GET', `/telekom-services/${id}`);
  },

  getAllServices() {
    return this.ajax('GET', '/telekom-services');
  },

  addService: function (service) {
    return this.ajax('POST', '/telekom-services', service);
  },

  addSupplier: function (supplier) {
    return this.ajax('POST', '/suppliers', supplier);
  },

  deleteService: function (id) {
    return this.ajax('DELETE', `/telekom-services/${id}`);
  },

  deleteSupplier: function (id) {
    return this.ajax('DELETE', `/suppliers/${id}`);
  },

  addRating: function(id, ratingValue) {
    console.log(this.ratingValue);
    this.createRating(ratingValue);
    console.log(this.currentRating);
    return this.ajax('POST', `/suppliers/${id}/ratings`, this.currentRating);
  },

  getAvgRating: function(id,ratingType) {
    return this.ajax('GET', `/suppliers/${id}/average-rating/${ratingType}`);
  },
  deactivateSupplier(id) {
    return this.ajax('POST', `/suppliers/${id}/deactivate`);
  },
  deactivateService(id) {
    return this.ajax('POST', `/telekom-services/${id}/deactivate`);
  },
  getSuppliers(status) {
    return this.ajax('GET', '/suppliers/filter/by-status?status=' + status);
  },
  getSortedSuppliers(ratingType, supplierCategory, filterActive) {
    return this.ajax('GET', '/suppliers/sort/by-rating?ratingType=' + ratingType + '&supplierCategory=' + supplierCategory
        + '&filterActive=' + filterActive);
  }

});
