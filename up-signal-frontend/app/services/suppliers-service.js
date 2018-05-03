import Ember from 'ember';
import BaseHttpService from './base-http-service';

export default BaseHttpService.extend({

	currentSupplier: null,
  currentService: null,


  createSupplier() {
    let newSupplier = Ember.Object.create({
      name: '',
      address: '',
      category: '0'
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


  getAllSuppliers() {
    return this.ajax('GET', 'http://localhost:8080/suppliers');
  },

  getAllServices() {
    return this.ajax('GET', 'http://localhost:8080/telekom-services');
  },

  addService: function (service) {
    return this.ajax('POST', 'http://localhost:8080/telekom-services', service);
  },

  addSupplier: function (supplier) {
    return this.ajax('POST', 'http://localhost:8080/suppliers', supplier);
  },
});